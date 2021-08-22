package com.eugenebaturov.rickandmorty.data.entity.list;

import com.eugenebaturov.rickandmorty.data.entity.EpisodeRequest;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность, который хранит информацию о эпизодах мульт-сериала "Рик и Морти".
 * <p>
 * [mEpisodes] - список эпизодов {@link EpisodeRequest}
 */
public class ListEpisodeRequest {

    @SerializedName("results")
    private List<EpisodeRequest> mEpisodes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListEpisodeRequest that = (ListEpisodeRequest) o;
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

    public List<EpisodeRequest> getEpisodes() {
        return mEpisodes;
    }
}
