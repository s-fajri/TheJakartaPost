package com.test.tjp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("id")
    private String id;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("location")
    private String location;

    @SerializedName("title")
    private String title;

    @SerializedName("path")
    private String path;

    @SerializedName("summary")
    private String summary;

    @SerializedName("content")
    private String content;

//    @SerializedName("channels")
//    private Channels channels;

//    @SerializedName("tags")
//    private List<Tag> tags = null;

    @SerializedName("gallery")
    private List<Gallery> gallery = null;

//    @SerializedName("is_premium")
//    private Boolean isPremium;

//    @SerializedName("is_longform")
//    private Boolean isLongform;

    @SerializedName("source_id")
    private Integer sourceId;

    @SerializedName("line")
    private String line;

    public String getId() {
        return id;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public String getLine() {
        return line;
    }

    public static class Gallery {
        @SerializedName("id")
        private Integer id;

        @SerializedName("title")
        private String title;

        @SerializedName("path_origin")
        private String pathOrigin;

        @SerializedName("path_thumbnail")
        private String pathThumbnail;

        @SerializedName("path_small")
        private String pathSmall;

        @SerializedName("path_medium")
        private String pathMedium;

        @SerializedName("path_large")
        private String pathLarge;

        @SerializedName("source")
        private String source;

        @SerializedName("content")
        private String content;

        @SerializedName("photographer")
        private String photographer;

        @SerializedName("keyword")
        private String keyword;

        public Integer getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getPathOrigin() {
            return pathOrigin;
        }

        public String getPathThumbnail() {
            return pathThumbnail;
        }

        public String getPathSmall() {
            return pathSmall;
        }

        public String getPathMedium() {
            return pathMedium;
        }

        public String getPathLarge() {
            return pathLarge;
        }

        public String getSource() {
            return source;
        }

        public String getContent() {
            return content;
        }

        public String getPhotographer() {
            return photographer;
        }

        public String getKeyword() {
            return keyword;
        }
    }

}
