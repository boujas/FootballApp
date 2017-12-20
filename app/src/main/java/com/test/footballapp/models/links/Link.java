package com.test.footballapp.models.links;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

public class Link extends RealmObject implements Parcelable {

    private String href;

    public Link(){

    }

    private Link(Parcel in) {
        href = in.readString();
    }

    public Link(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Link{" +
                "href='" + href + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(href);
    }

    public static final Parcelable.Creator<Link> CREATOR
            = new Parcelable.Creator<Link>() {
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        public Link[] newArray(int size) {
            return new Link[size];
        }
    };
}
