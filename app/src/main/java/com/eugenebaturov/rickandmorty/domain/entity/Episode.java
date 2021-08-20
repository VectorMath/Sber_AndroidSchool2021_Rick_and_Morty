package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Класс-сущность, который хранит информацию об эпизоде мульт-сериала "Рик и Морти".
 * <p>
 * [mId] - id эпизода.
 * <p>
 * [mTitle] - название эпизода.
 * <p>
 * [mAirDate] - дата выпуска эпизода(пример: September 10, 2017).
 * <p>
 * [mEpisodeCount] - номер эпизода(пример: S03E07).
 * <p>
 * [mCharacters] - ссылка на персонажей, которые появились в эпизоде.
 */
public class Episode {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mTitle;

    @SerializedName("air_date")
    private String mAirDate;

    @SerializedName("episode")
    private String mEpisodeNumber;

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

    public String getEpisodeNumber() {
        return mEpisodeNumber;
    }

    public List<String> getCharacters() {
        return mCharacters;
    }
}
