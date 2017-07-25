package com.example.user.sharepreference;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 7/25/2017.
 */


public class EntryUI implements Parcelable {

    protected String name;
    protected String lastName;

    public EntryUI(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public EntryUI() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "EntryUI{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    protected EntryUI(Parcel in) {
        name = in.readString();
        lastName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<EntryUI> CREATOR = new Parcelable.Creator<EntryUI>() {
        @Override
        public EntryUI createFromParcel(Parcel in) {
            return new EntryUI(in);
        }

        @Override
        public EntryUI[] newArray(int size) {
            return new EntryUI[size];
        }
    };
}