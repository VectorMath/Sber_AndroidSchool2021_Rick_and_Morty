package com.eugenebaturov.rickandmorty.data.converter;

/**
 * Конвертер данных.
 *
 * @param <F> изначальный тип данных.
 * @param <T> конечный тип данных.
 */
public interface Converter<F, T> {

    /**
     * Конвертирует данные.
     *
     * @param from изначальные данные.
     * @return отконвертированные данные.
     */
    T convert(F from);
}
