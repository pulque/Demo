package com.lizheblogs.demo.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by LiZhe on 2019-09-27.
 * com.lizheblogs.demo.common.utils
 */
public class GsonUtils {

    /**
     * create once, reuse
     */
    private static Gson gson;

    private static void initGson() {
        if (gson == null) {
            JsonDeserializer<Integer> jsonDeserializer = new JsonDeserializer<Integer>() {
                @Override
                public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    try {
                        return json.getAsInt();
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                }
            };
            gson = new GsonBuilder()
                    .registerTypeAdapter(int.class, jsonDeserializer)
                    .excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .disableHtmlEscaping()
                    .setLenient()
                    .create();
        }
    }

    /**
     * Convert Object to Json
     *
     * @param object class
     * @return json
     */
    public static String objectToJson(Object object) {
        initGson();
        return gson.toJson(object);
    }

    /**
     * Convert json to object
     *
     * @param jsonString json
     * @param clazz      class
     * @return class
     */
    public static <T> T jsonToObject(String jsonString, Class<T> clazz) {
        initGson();
        T t = null;
        try {
            t = gson.fromJson(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * Convert json to object
     *
     * @param jsonString json
     * @param typeOfT      class
     * @return class
     */
    public static <T> T jsonToObject(String jsonString, Type typeOfT) {
        initGson();
        T t = null;
        try {
            t = gson.fromJson(jsonString, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
