package com.test.tjp.screen.Home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.test.tjp.R;
import com.test.tjp.adapter.NewsAdapter;
import com.test.tjp.base.BaseFragment;
import com.test.tjp.data.model.Data;
import com.test.tjp.screen.NewsDetail.NewsDetailActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    @BindView(R.id.rvListNews)
    RecyclerView rvListNews;
    @BindView(R.id.srlList)
    SwipeRefreshLayout srlList;

    private final int limit = 10;
    private int page = 1;
    List<Data> dataAll = new ArrayList<>();;

    NewsAdapter newsAdapter;
    LinearLayoutManager linearLayoutManager;

    @Inject
    HomeContract.Presenter mPresenter;

    @Inject
    public HomeFragment() {
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle state) {
        linearLayoutManager = new LinearLayoutManager(parentActivity(), LinearLayoutManager.VERTICAL, false);
        rvListNews.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(parentActivity().getApplication(), new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Data data) {
                Intent intent = new Intent(parentActivity(), NewsDetailActivity.class);
                intent.putExtra("path", data.getPath());
                startActivity(intent);
            }
        });
        rvListNews.setAdapter(newsAdapter);

        mPresenter.getNewsList(limit, (limit * page) - limit);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);

        srlList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                dataAll.clear();
                mPresenter.getNewsList(limit, 0);
//                mPresenter.getNewsList(limit, (limit * page) - limit);
            }
        });

        rvListNews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(parentActivity(), "Load more news", Toast.LENGTH_SHORT).show();
                    mPresenter.getNewsList(limit, (limit * page) - limit);
                }
            }
        });
    }

    @Override
    public void getNewsComplete(List<Data> datas) {
        page++;
        srlList.setRefreshing(false);
        dataAll.addAll(datas);

        if (dataAll.size() != 0) {
            newsAdapter.setItemData(dataAll);
        } else {
            Toast.makeText(parentActivity(), "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getNewsError(String message) {
        Toast.makeText(parentActivity(), message, Toast.LENGTH_LONG).show();
    }
}
