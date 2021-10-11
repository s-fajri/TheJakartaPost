package com.test.tjp.adapter;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.test.tjp.R;
import com.test.tjp.data.model.Data;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {

    public interface OnItemClickListener {
        void onItemClick(Data data);
    }

    Application application;
    List<Data> listNews;
    private final OnItemClickListener listener;

    public NewsAdapter(Application application, OnItemClickListener listener) {
        this.application = application;
        this.listener = listener;
        listNews = new ArrayList<>();
    }

    public void setItemData(List<Data> results) {
        listNews.clear();
        listNews.addAll(results);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsAdapter.NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_adapter, parent, false);

        return new NewsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVH holder, int position) {
        holder.bind(listNews.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    class NewsVH extends RecyclerView.ViewHolder {

        @BindView(R.id.ivGambar) AppCompatImageView ivGambar;
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvTime) TextView tvTime;

        public NewsVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bind(Data data, OnItemClickListener listener) {
            String urlnya = data.getGallery().get(0).getPathThumbnail().replaceAll("http:", "https:");
            Picasso.get().load(urlnya).into(ivGambar);
            tvTitle.setText(data.getTitle());
            tvTime.setText(data.getPublishedDate());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(data);
                }
            });

        }
    }

}