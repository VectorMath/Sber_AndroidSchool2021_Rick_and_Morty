package com.eugenebaturov.rickandmorty.data.converter;

import androidx.room.TypeConverter;

import java.util.List;

/**
 * Конвертирует список в строку.
 */
public class ListConverter implements Converter<List<String>, String> {
    @TypeConverter
    @Override
    public String convert(List<String> from) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (i < result.length() - 1)
                result.append(from.get(i)).append(", ");
            else
                result.append(from.get(i));
        }

        return result.toString();
    }
}
