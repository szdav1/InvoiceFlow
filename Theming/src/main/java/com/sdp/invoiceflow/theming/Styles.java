package com.sdp.invoiceflow.theming;

import com.sdp.invoiceflow.theming.json.parser.JsonParser;
import com.sdp.invoiceflow.theming.style.Style;
import com.sdp.invoiceflow.theming.style.converter.StyleConverter;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class Styles {
    private static final Map<String, Style> styles = new HashMap<>();

    @SuppressWarnings("all")
    public static void loadStyle(final String filePath) {
        if (!styles.isEmpty())
            return;

        try {
            JsonParser.parseJson(filePath).forEach((styleName, jsonStyle) ->
                styles.put(styleName.toLowerCase(), StyleConverter.fromJsonStyle(jsonStyle)));
        }
        catch (Exception e) {
            e.printStackTrace(); // TODO: Load backup styles
        }
    }

    public static Style get(final String styleName) {
        return styles.getOrDefault(styleName.toLowerCase(), Style.withDefaults());
    }
}
