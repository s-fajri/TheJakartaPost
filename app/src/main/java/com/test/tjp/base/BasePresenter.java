package com.test.tjp.base;

public interface BasePresenter<T> {
    void takeView(T view);

    void dropView();
}
