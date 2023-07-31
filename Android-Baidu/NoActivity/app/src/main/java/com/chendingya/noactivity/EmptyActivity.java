package com.chendingya.noactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.*;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.chendingya.noactivity.fragment.Frag_home;
import com.chendingya.noactivity.fragment.Frag_user;
import com.chendingya.noactivity.fragment.Frag_video;

public class EmptyActivity extends AppCompatActivity {


    private ImageView home;
    private ImageView video;
    private ImageView user;
    private Bundle bundle;
    private String addnews;
    public static String username;
    public int frag;
    static public String news_data = "[" +
            "{" +
            "'title':'青春的盛会 团结的盛会'," +
            "'subtitle':'新华网'," +
            "'tip':'置顶'" +
            "}," +
            "{" +
            "'title':'习近平大运会致辞'," +
            "'subtitle':'央视网新闻'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'中央气象台史上第二个暴雨红色预警'," +
            "'subtitle':'海报新闻'," +
            "'tip':'热点'," +
            "'pic':'/storage/emulated/0/Pictures/p1.png'" +
            "}," +
            "{" +
            "'title':'金正恩会见李鸿忠'," +
            "'subtitle':'新华社国际'," +
            "'tip':'置顶'," +
            "'pic':''" +
            "}," +
            "{" +
            "'title':'河南一地降水量达220.3毫米'," +
            "'subtitle':'大河报'," +
            "'tip':'热门'" +
            "}" +
            "]";
    static public String video_data = "[" +
            "{" +
            "'video_title':'成都大运会开幕式 最大的“显眼包”蓉宝实力圈粉 全程蹦跳转圈比心'," +
            "'username':'封面新闻'," +
            "'video_img':'https://pics2.baidu.com/feed/86d6277f9e2f07086f89789e379b3495ab01f2e8.jpeg@f_auto?token=7c5757766b52931770d3585b17e2bab7'," +
            "'video_src':'http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8'" +
            "}," +
            "{" +
            "'video_title':'现在做游戏都有人往嘴里喂饭？专访《鸣潮》开发团队！'," +
            "'username':'差评硬件部'," +
            "'video_img':'https://i0.hdslb.com/bfs/archive/0d0174735d728895b6de2af404834c6183c2f77f.jpg@672w_378h_1c_!web-home-common-cover.webp'," +
            "'video_src':'http://vjs.zencdn.net/v/oceans.mp4'" +
            "}," +
            "{" +
            "'video_title':'装修现场蹦迪？Battle甲方！清华建筑师的真实工作状态'," +
            "'username':'大物是也'," +
            "'video_img':'https://i1.hdslb.com/bfs/archive/131dcdbc676b15cbfaeff854f7f70b894c0152c4.jpg@672w_378h_1c_!web-home-common-cover.webp'," +
            "'video_src':'https://www.bilibili.com/video/BV1uP41167Pb/?spm_id_from=333.1007.tianma.2-2-5.click'" +
            "}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        bundle = this.getIntent().getExtras();

        home = findViewById(R.id.home1);
        video = findViewById(R.id.video1);
        user = findViewById(R.id.user1);
        turn_frag(home);

        if (bundle != null) {
            if (bundle.getInt("flag") == 1) {
                addnews = "{'title':'" + bundle.getString("title") + "'," +
                        "'subtitle':'" + bundle.getString("subtitle") + "'," +
                        "'tip':'" + bundle.getString("tip") + "'";
                if (bundle.getString("pic") != null)
                    addnews += ",'pic':'" + bundle.getString("pic") + "'},";
                else
                    addnews += "},";
                StringBuilder s = new StringBuilder(news_data);
                s.insert(1, addnews);
                news_data = s.toString();

                //写入文件
                //获取准确的路径,context.getPackageName()得到包名
                File dir = new File("data/data/" + this.getPackageName());
                //如果文件夹不存在，则创建指定的文件
                if (!dir.exists() || !dir.isDirectory()) {
                    dir.mkdir();
                }
                //文件声明
                File file = new File(dir, "news.txt");
                //输入流
                InputStream inputStream = null;
                //输出流
                OutputStream outputStream = null;
                //若不存在，通过IO流的方式，将assets目录下的数据库文件，写入到项目模拟手机中，当开启模拟
                //器时，会将数据库文件写入到模拟手机的内存中
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    //创建文件
                    file.createNewFile();
                    //加载文件
                    inputStream = new ByteArrayInputStream(news_data.getBytes());
                    //输出到文件
                    outputStream = new FileOutputStream(file);

                    byte[] buffer = new byte[1024];
                    int len;
                    //按字节写入
                    while ((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭资源
                    if (outputStream != null) {

                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else if (bundle.getInt("flag") == 2) {
                turn_frag(video);
            } else if (bundle.getInt("flag") == 3) {
                turn_frag(user);
            }
        }

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
                System.out.println("click home");
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
                System.out.println("click video");

            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
                System.out.println("click user");

            }
        });

    }


    public void turn_frag(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Frag_home f1 = new Frag_home();
        Frag_video f2 = new Frag_video();
        Frag_user f3 = new Frag_user();
        if (v.getId() == R.id.home1) {
            if (frag != 1) {
                ft.replace(R.id.frag, f1);
                frag = 1;
            }
        } else if (v.getId() == R.id.video1) {
            if (frag != 2) {
                ft.replace(R.id.frag, f2);
                frag = 2;
            }
        } else if (v.getId() == R.id.user1) {
            if (frag != 3) {
                ft.replace(R.id.frag, f3);
                frag = 3;
            }
        }

        ft.commit();
    }


}

