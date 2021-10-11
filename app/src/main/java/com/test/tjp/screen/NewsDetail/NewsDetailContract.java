package com.test.tjp.screen.NewsDetail;

import com.test.tjp.base.BasePresenter;
import com.test.tjp.base.BaseView;
import com.test.tjp.data.model.Data;

public interface NewsDetailContract {
    interface View extends BaseView<NewsDetailContract.Presenter> {

        void failedGetNewsDetail(String message);

        void successGetNewsDetail(Data data);
    }

    interface Presenter extends BasePresenter<NewsDetailContract.View> {

        void getNewsDetail(String sPath);
    }
}
