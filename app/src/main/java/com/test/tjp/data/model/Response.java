package com.test.tjp.data.model;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("code")
    private Integer code;

    @SerializedName("text")
    private String text;

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
