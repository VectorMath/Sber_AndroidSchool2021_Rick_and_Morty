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
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getAirDate() != null ? getAirDate().hashCode() : 0);
        result = 31 * result + (getEpisodeNumber() != null ? getEpisodeNumber().hashCode() : 0);
        result = 31 * result + (getCharacters() != null ? getCharacters().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Episode)) {
            return false;
        }

        Episode that = (Episode) obj;

        if (getTitle() != null
                ? getTitle().equals(that.getTitle())
                : that.getTitle() == null)
            return false;

        if (getAirDate() != null
                ? getAirDate().equals(that.getAirDate())
                : that.getAirDate() == null)
            return false;

        if (getEpisodeNumber() != null
                ? getEpisodeNumber().equals(that.getEpisodeNumber())
                : that.getEpisodeNumber() == null)
            return false;

        if (getCharacters() != null
                ? getCharacters().equals(that.getCharacters())
                : that.getCharacters() == null)
            return false;

        return getId() == that.getId();
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Episode{");
        sb.append("mId: ").append(mId).append('\'');
        sb.append("mTitle: ").append(mTitle).append('\'');
        sb.append("mAirDate: ").append(mAirDate).append('\'');
        sb.append("mEpisodeNumber: ").append(mEpisodeNumber).append('\'');
        sb.append("mCharacters: ").append(mCharacters.toString()).append('\'');
        sb.append('}');
        return sb.toString();
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
