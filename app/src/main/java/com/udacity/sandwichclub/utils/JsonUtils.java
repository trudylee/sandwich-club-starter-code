package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwichJson = new JSONObject(json);

        return new Sandwich(getString(sandwichJson.getJSONObject("name"), "mainName"),
                getStringList(sandwichJson.getJSONObject("name"), "alsoKnownAs"),
                getString(sandwichJson, "placeOfOrigin"),
                getString(sandwichJson, "description"),
                getString(sandwichJson, "image"),
                getStringList(sandwichJson, "ingredients"));
    }

    private static String getString(JSONObject json, String key) throws JSONException {
        return json.getString(key);
    }

    private static List<String> getStringList(JSONObject names, String key) throws JSONException {
        List<String> strings = new ArrayList<>();
        JSONArray jsonArray = names.getJSONArray(key);
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                strings.add(jsonArray.getString(i));
            }
        }
        return strings;
    }
}
