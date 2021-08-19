package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Episode {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mTitle;

    @SerializedName("air_date")
    private String mAirDate;

    @SerializedName("episode")
    private String mEpisodeCount;

    @SerializedName("characters")
    private List<String> mCharacters;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAirDate() {
        return mAirDate;
    }

    public String getEpisodeCount() {
        return mEpisodeCount;
    }

    public List<String> getCharacters() {
        return mCharacters;
    }
}
