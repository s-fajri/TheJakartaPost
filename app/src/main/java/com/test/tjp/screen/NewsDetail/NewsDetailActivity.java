package com.test.tjp.screen.NewsDetail;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.test.tjp.R;
import com.test.tjp.utils.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

public class NewsDetailActivity extends DaggerAppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    NewsDetailFragment mFragment;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);
        mUnbinder = ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        toolbar.setBackgroundColor(Color.WHITE);
        toolbar.setTitle("Detail Berita");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        NewsDetailFragment newsDetailFragment = (NewsDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        if (newsDetailFragment == null) {
            newsDetailFragment = mFragment;
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), newsDetailFragment, R.id.fragment_container);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    public String getExtraData() {
        return getIntent().getStringExtra("path");
    }

}
