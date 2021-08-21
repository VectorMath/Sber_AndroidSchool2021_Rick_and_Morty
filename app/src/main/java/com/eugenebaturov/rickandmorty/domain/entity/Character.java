package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Класс-сущность, который хранит информацию о персонаже мульт-сериала "Рик и Морти".
 * <p>
 * [mId] - id персонажа.
 * <p>
 * [mName] - имя персонажа.
 * <p>
 * [mStatus] - статус персонажа(Жив, Мёртв, Неизвестно).
 * <p>
 * [mSpecies] - раса персонажа.
 * <p>
 * [mType] - отличительная черта персонажа.
 * <p>
 * [mGender] - гендер персонажа.
 * <p>
 * [mImage] - изображение персонажа.
 * <p>
 * [mOrigin] - место рождения персонажа. Реализовано через класс {@link Origin}
 * <p>
 * [mCurrentLocation] - текущее местоположение персонажа.
 * Реализовано через класс {@link CurrentLocation}
 * <p>
 * [mEpisodes] - ссылка на эпизоды в которых персонаж появился.
 */
public class Character {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("species")
    private String mSpecies;

    @SerializedName("type")
    private String mType;

    @SerializedName("gender")
    private String mGender;

    @SerializedName("image")
    private String mImage;

    @SerializedName("origin")
    private Origin mOrigin;

    @SerializedName("location")
    private CurrentLocation mCurrentLocation;

    @SerializedName("episode")
    private List<String> mEpisodes;

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Character)) {
            return false;
        }

        Character that = (Character) obj;

        if (getName() != null
                ? !getName().equals(that.getName())
                : that.getName() != null)
            return false;

        if (getStatus() != null
                ? !getStatus().equals(that.getStatus())
                : that.getStatus() != null)
            return false;

        if (getSpecies() != null
                ? !getSpecies().equals(that.getSpecies())
                : that.getSpecies() != null)
            return false;

        if (getType() != null
                ? !getType().equals(that.getType())
                : that.getType() != null)
            return false;

        if (getGender() != null
                ? !getGender().equals(that.getGender())
                : that.getGender() != null)
            return false;

        if (getImage() != null
                ? !getImage().equals(that.getImage())
                : that.getImage() != null)
            return false;

        if (getOrigin() != null
                ? !getOrigin().equals(that.getOrigin())
                : that.getOrigin() != null)
            return false;

        if (getCurrentLocation() != null
                ? !getCurrentLocation().equals(that.getCurrentLocation())
                : that.getCurrentLocation() != null)
            return false;

        if (getEpisodes() != null
                ? getEpisodes().equals(that.getEpisodes())
                : that.getEpisodes() == null)
            return false;

        return getId() == that.getId();
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("mId: ").append(mId).append('\'');
        sb.append("mName: ").append(mName).append('\'');
        sb.append("mStatus: ").append(mStatus).append('\'');
        sb.append("mSpecies: ").append(mSpecies).append('\'');
        sb.append("mType: ").append(mType).append('\'');
        sb.append("mGender: ").append(mGender).append('\'');
        sb.append("mImage: ").append(mImage).append('\'');
        sb.append("mOrigin: ").append(getOrigin().toString()).append('\'');
        sb.append("mCurrentLocation: ").append(getCurrentLocation().toString()).append('\'');
        sb.append("mEpisodes: ").append(getEpisodes().toString()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getSpecies() {
        return mSpecies;
    }

    public String getType() {
        return mType;
    }

    public String getGender() {
        return mGender;
    }

    public String getImage() {
        return mImage;
    }

    public Origin getOrigin() {
        return mOrigin;
    }

    public CurrentLocation getCurrentLocation() {
        return mCurrentLocation;
    }

    public List<String> getEpisodes() {
        return mEpisodes;
    }
}
