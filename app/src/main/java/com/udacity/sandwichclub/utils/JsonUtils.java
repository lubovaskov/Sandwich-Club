package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich result;

        try {
            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject sandwichNameJSON = sandwichJSON.getJSONObject("name");

            String mainName = sandwichNameJSON.getString("mainName");

            JSONArray alsoKnownAsArray = sandwichNameJSON.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsArray.getString(i));
            }

            String placeOfOrigin = sandwichJSON.getString("placeOfOrigin");
            String description = sandwichJSON.getString("description");
            String image = sandwichJSON.getString("image");

            JSONArray ingredientsArray = sandwichJSON.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
            }

            result = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }
}
