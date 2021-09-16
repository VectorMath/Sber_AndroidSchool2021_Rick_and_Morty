package com.eugenebaturov.rickandmorty.data.converter;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class StringConverter {

    @TypeConverter
    public String ConvertToString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1)
                result.append(list.get(i)).append(", ");
            else
                result.append(list.get(i));
        }

        return result.toString();
    }

    @TypeConverter
    public List<String> ConvertToList(String string) {
        return Arrays.asList(string.split(","));
    }
}
