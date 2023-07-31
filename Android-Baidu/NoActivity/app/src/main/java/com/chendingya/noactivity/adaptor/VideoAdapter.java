package com.chendingya.noactivity.adaptor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chendingya.noactivity.VideoplayActivity;
import com.chendingya.noactivity.bean.Video_bean;
import com.chendingya.noactivity.R;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<Video_bean> mContactList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View contactView;//存储解析到的view
        ImageView video;
        TextView video_title;
        TextView username;
        TextView tip;

        public ViewHolder(@NonNull View view) {
            super(view);
            contactView = view;
            video_title = view.findViewById(R.id.video_title);
            username = view.findViewById(R.id.username);
            video = view.findViewById(R.id.video);
        }
    }

    public VideoAdapter(List<Video_bean> videoList) {
        mContactList = videoList;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //解析layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        //新建一个viewHolder绑定解析到的view
        final VideoAdapter.ViewHolder viewHolder = new VideoAdapter.ViewHolder(view);
        //监听每一项的点击事件
        viewHolder.contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                /**
                 * 拿到video data实例
                 */
                Video_bean video_bean = mContactList.get(position);

                Intent intent = new Intent(view.getContext(), VideoplayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("src", video_bean.getVideo_src());
                bundle.putString("video_title", video_bean.getVideo_title());
                bundle.putString("username", video_bean.getUsername());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        Video_bean video_bean = mContactList.get(position);
        System.out.println("video " + video_bean.getVideo_title() + video_bean.getVideo_img() + " username " + video_bean.getUsername());
        holder.video_title.setText(video_bean.getVideo_title());
        holder.username.setText(video_bean.getUsername());
        Glide.with(holder.contactView).load(video_bean.getVideo_img()).into(holder.video);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

}