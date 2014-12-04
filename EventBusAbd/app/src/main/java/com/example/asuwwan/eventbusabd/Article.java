package com.example.asuwwan.eventbusabd;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASuwwan on 12/4/2014.
 */
public class Article implements Parcelable {
    private String title;
    private String content;

    public Article(String title,String content){
        this.title=title;
        this.content=content;
    }
    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    protected Article(Parcel in) {

        title = in.readString();
        content = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(content);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
