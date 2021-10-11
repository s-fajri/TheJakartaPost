package com.test.tjp.screen.Home;

import com.test.tjp.base.BasePresenter;
import com.test.tjp.base.BaseView;
import com.test.tjp.data.model.Data;

import java.util.List;

public interface HomeContract {
    interface View extends BaseView<HomeContract.Presenter> {

        void getNewsComplete(List<Data> datas);

        void getNewsError(String message);
    }

    interface Presenter extends BasePresenter<HomeContract.View> {

        void getNewsList(int limit, int skip);
    }
}
