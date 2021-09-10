package com.eugenebaturov.rickandmorty.models.data.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о эпизодах мульт-сериала "Рик и Морти".
 */
public final class ListEpisodeResponse {

    @SerializedName("results")
    @NonNull
    private final List<EpisodeResponse> mEpisodes;

    /**
     * Конструктор класса.
     *
     * @param mEpisodes список эпизодов {@link EpisodeResponse}
     */
    public ListEpisodeResponse(@NonNull final List<EpisodeResponse> mEpisodes) {
        this.mEpisodes = mEpisodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListEpisodeResponse that = (ListEpisodeResponse) o;
        return Objects.equals(mEpisodes, that.mEpisodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mEpisodes);
    }

    @Override
    @NonNull
    public String toString() {
        return "ListEpisodeRequest{" +
                "mEpisodes=" + mEpisodes +
                '}';
    }

    @NonNull
    public List<EpisodeResponse> getEpisodes() {
        return mEpisodes;
    }
}
