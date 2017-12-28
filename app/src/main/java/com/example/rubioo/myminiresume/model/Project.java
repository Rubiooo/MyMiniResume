package com.example.rubioo.myminiresume.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jimmy on 2017/12/22.
 */

public class Project implements Parcelable {

    public String id;
    public String name;
    public Date startDate;
    public Date endDate;
    public List<String> details;

    public Project() { id = UUID.randomUUID().toString();}

    protected Project(Parcel in) {
        id = in.readString();
        name = in.readString();
        startDate = new Date(in.readLong());
        endDate = new Date(in.readLong());
        details = in.createStringArrayList();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeLong(startDate.getTime());
        dest.writeLong(endDate.getTime());
        dest.writeStringList(details);
    }

    @Override
    public int describeContents() { return 0; }
}
