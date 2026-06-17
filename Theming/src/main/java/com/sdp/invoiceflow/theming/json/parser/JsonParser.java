package com.sdp.invoiceflow.theming.json.parser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.sdp.invoiceflow.theming.exceptions.InvalidColorThemeFilePathException;
import com.sdp.invoiceflow.theming.exceptions.MalformedJsonAsColorThemeException;
import com.sdp.invoiceflow.theming.json.JsonStyle;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class JsonParser {
    private static final Gson converter = new Gson();

    private static String readJson(final String filePath) throws InvalidColorThemeFilePathException {
        StringBuilder strb = new StringBuilder();
        try (RandomAccessFile reader = new RandomAccessFile(new File(filePath), "r")) {
            String line;

            while ((line = reader.readLine()) != null) {
                strb.append(line);
            }
        }
        catch (Exception e) {
            throw new InvalidColorThemeFilePathException(filePath);
        }

        return strb.toString();
    }

    public static Map<String, JsonStyle> parseJson(final String filePath)
        throws InvalidColorThemeFilePathException, MalformedJsonAsColorThemeException, JsonSyntaxException {

        final String jsonContent = readJson(filePath);
        if (jsonContent.isBlank())
            throw new MalformedJsonAsColorThemeException(filePath);

        Map<String, JsonStyle> jsonThemeObjects = new HashMap<>();
        final JsonObject rootJsonObject = converter.fromJson(jsonContent, JsonObject.class);

        rootJsonObject.entrySet().forEach(jsonEntry ->
            jsonThemeObjects.put(jsonEntry.getKey(), converter.fromJson(jsonEntry.getValue(), JsonStyle.class)));

        return jsonThemeObjects;
    }
}
