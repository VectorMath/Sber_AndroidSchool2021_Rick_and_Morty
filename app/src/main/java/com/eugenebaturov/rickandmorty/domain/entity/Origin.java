package com.eugenebaturov.rickandmorty.domain.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Подкласс, который является полем для класса-сущности {@link Character}.
 * <p>
 * Хранит в себе информацию о месте рождения персонажа.
 * <p>
 * [mName] - название локации.
 * <p>
 * [mUrl] - ссылка на локацию, информацию о которой хранит класс-сущность {@link Location}.
 */
public class Origin {

    @SerializedName("name")
    private String mName;

    @SerializedName("url")
    private String mUrl;

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Origin)) {
            return false;
        }

        Origin that = (Origin) obj;

        if (getName() != null
                ? getName().equals(that.getName())
                : that.getName() == null)
            return false;

        return getUrl() != null
                ? getUrl().equals(that.getUrl())
                : that.getUrl() == null;
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Origin{");
        sb.append("mName: ").append(mName).append('\'');
        sb.append("mUrl: ").append(mUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }
}
