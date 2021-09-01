package com.example.android.contactlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("roster")
    @Expose
    private List<Data> roster = null;

    public User(List<Data> roster) {
        this.roster = roster;
    }

    public List<Data> getRoster() {
        return roster;
    }

    public void setRoster(List<Data> roster) {
        this.roster = roster;
    }
}
