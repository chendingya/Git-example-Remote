package com.chendingya.noactivity.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.chendingya.noactivity.EmptyActivity;
import com.chendingya.noactivity.login.LoginActivity;
import com.chendingya.noactivity.R;
import com.chendingya.noactivity.login.User;
import com.chendingya.noactivity.login.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_user#newInstance} factory method to
 * create an instance of this fragment.
 * Frag_user类继承自Fragment类。
 * 类中定义了一些私有变量和控件，例如login按钮、username文本视图、phone文本视图等。
 * 通过newInstance方法创建Frag_user类的实例，并传入参数。
 * 在onCreate方法中获取传入的参数值。
 * onCreateView方法用于创建并返回Fragment的布局。
 * onActivityCreated方法在Activity与Fragment关联之后调用，用于初始化界面和设置事件监听器。
 * 如果用户未登录，显示未登录时的布局；如果用户已登录，显示已登录时的布局。
 * 响应登录按钮点击事件，跳转到登录页面。
 * 如果用户已登录，获取用户信息并显示在对应的控件上。
 * 设置更改头像功能，点击设置头像按钮弹出对话框。
 * 实现更改头像功能，打开相册选择图片，并将选择的图片显示在界面上。
 * 处理从相册选择图片的结果，在不同的Android版本上分别处理。
 * 获取图片路径。
 * 显示选择的图片，并更新头像路径。
 */
public class Frag_user extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button login;
    private TextView username;
    private TextView phone;
    private TextView age;
    private TextView sex;
    private ImageView photo;
    private ImageView set_photo;
    private String photopath;
    private ImageView img;
    private String user;
    private View set_photo_layout;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_user() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_user.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_user newInstance(String param1, String param2) {
        Frag_user fragment = new Frag_user();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println(User.class);
        if (EmptyActivity.username == null) {
            return inflater.inflate(R.layout.frag_user_unlogin, container, false);
        } else {
            return inflater.inflate(R.layout.frag_user, container, false);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        login = (Button) getActivity().findViewById(R.id.login);

        if (EmptyActivity.username == null)
            //登陆
            login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }
            });
        else{

            //获取用户信息
            Map<String, String> info = new HashMap<>();
            UserService US = new UserService(getContext());
            info = US.get_userinfo(EmptyActivity.username);
            username = getActivity().findViewById(R.id.user_name);
            phone = getActivity().findViewById(R.id.user_phone);
            sex = getActivity().findViewById(R.id.user_sex);
            age = getActivity().findViewById(R.id.user_age);
            photo = getActivity().findViewById(R.id.user_photo);
            user = info.get("username");
            username.setText(user);
            phone.setText(info.get("phone"));
            age.setText(info.get("age"));
            sex.setText(info.get("sex"));
            photopath = info.get("photo");
            if(photopath !=null) {
                Bitmap bitmap = BitmapFactory.decodeFile(photopath);
                photo.setImageBitmap(bitmap);
            }
            //设置头像
            set_photo = getActivity().findViewById(R.id.set_photo);
            set_photo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //获取内容
                    set_photo_layout =View.inflate(getContext(),R.layout.dialog_user_picture,null);
                    setLayout(photopath);
                    //创建对象
                    AlertDialog.Builder b=new AlertDialog.Builder(getContext());
                    //修改标题
                    b.setTitle("点击图片更改头像");
                    //赋值内容设置窗口
                    b.setView(set_photo_layout);
                    //修改
                    b.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            UserService US = new UserService(getContext());
                            US.update_photo(user,photopath);
                            Bitmap bitmap = BitmapFactory.decodeFile(photopath);
                            photo.setImageBitmap(bitmap);

                        }
                    });
                    b.setNegativeButton("取消",null);

                    b.show();

                }
            });
        }

    }

    private void setLayout(String photopath){
        img = set_photo_layout.findViewById(R.id.user_pic);
        if(photopath !=null) {
            Bitmap bitmap = BitmapFactory.decodeFile(photopath);
            img.setImageBitmap(bitmap);
        }
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //如果没有权限则申请权限
                if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
                //调用打开相册
                openAlbum();
            }
        });
    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 2); // 打开相册
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 判断手机系统版本号
        if (Build.VERSION.SDK_INT >= 19) {
            // 4.4及以上系统使用这个方法处理图片
            handleImageOnKitKat(data);
        } else {
            // 4.4以下系统使用这个方法处理图片
            handleImageBeforeKitKat(data);
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        try {
        Uri uri = data.getData();
        Log.d("TAG", "handleImageOnKitKat: uri is " + uri);

        if (DocumentsContract.isDocumentUri(getContext(), uri)) {
            // 如果是document类型的Uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1]; // 解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            }
            else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        }
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // 如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        }
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            // 如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath); // 根据图片路径显示图片
        } catch (Exception e) {
            e.printStackTrace();// 输出异常信息

        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }

    @SuppressLint("Range")
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        // 通过Uri和selection来获取真实的图片路径
        Cursor cursor = getActivity().getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            setLayout(imagePath);
            photopath = imagePath;
        }
        else {
            Toast.makeText(getContext(), "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }


}
