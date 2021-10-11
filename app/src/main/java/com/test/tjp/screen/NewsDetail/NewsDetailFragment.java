package com.test.tjp.screen.NewsDetail;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.ContentLoadingProgressBar;

import com.squareup.picasso.Picasso;
import com.test.tjp.R;
import com.test.tjp.base.BaseFragment;
import com.test.tjp.data.model.Data;

import javax.inject.Inject;

import butterknife.BindView;

public class NewsDetailFragment extends BaseFragment implements NewsDetailContract.View {

    @BindView(R.id.tvTitleDetails)
    AppCompatTextView tvTitleDetails;
    @BindView(R.id.ivGambarBesar)
    AppCompatImageView ivGambarBesar;
    @BindView(R.id.tvTimePublished)
    AppCompatTextView tvTimePublished;
    @BindView(R.id.tvContent)
    AppCompatTextView tvContent;

    private String sPath;

    @Inject
    NewsDetailContract.Presenter mPresenter;

    @Inject
    public NewsDetailFragment() {
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_news_detail;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NewsDetailActivity newsDetailActivity = (NewsDetailActivity) getActivity();
        sPath = newsDetailActivity.getExtraData();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView(Bundle state) {
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.getNewsDetail(sPath);
    }

    @Override
    public void failedGetNewsDetail(String message) {
        Toast.makeText(parentActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successGetNewsDetail(Data data) {
        String urlnya = data.getGallery().get(0).getPathLarge().replaceAll("http:", "https:");
        Picasso.get().load(urlnya).into(ivGambarBesar);

        tvTitleDetails.setText(data.getTitle());
        tvTimePublished.setText(data.getPublishedDate());
        tvContent.setText(Html.fromHtml(data.getContent()));
    }
}
