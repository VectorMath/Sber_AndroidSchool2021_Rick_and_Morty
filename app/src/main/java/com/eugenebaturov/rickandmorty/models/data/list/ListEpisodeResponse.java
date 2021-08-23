package com.eugenebaturov.rickandmorty.models.data.list;

import com.eugenebaturov.rickandmorty.models.data.EpisodeResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о эпизодах мульт-сериала "Рик и Морти".
 * <p>
 * [mEpisodes] - список эпизодов {@link EpisodeResponse}
 */
public class ListEpisodeResponse {

    @SerializedName("results")
    private List<EpisodeResponse> mEpisodes;

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
    public String toString() {
        return "ListEpisodeRequest{" +
                "mEpisodes=" + mEpisodes +
                '}';
    }

    public List<EpisodeResponse> getEpisodes() {
        return mEpisodes;
    }
}
