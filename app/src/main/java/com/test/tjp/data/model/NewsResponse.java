package com.test.tjp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {

    @SerializedName("response")
    private Response response;

    @SerializedName("data")
    private List<Data> datas;

    public Response getResponse() {
        return response;
    }

    public List<Data> getDatas() {
        return datas;
    }

}
