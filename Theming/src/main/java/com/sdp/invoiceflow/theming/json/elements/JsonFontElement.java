package com.sdp.invoiceflow.theming.json.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class JsonFontElement implements JsonStyleElement {
    @Data
    @AllArgsConstructor
    public static final class JsonFontStyleAttribute implements JsonStyleAttribute {
        private String family;
        private String ligature;
        private int size;
    }

    private JsonFontStyleAttribute stationary;
    private JsonFontStyleAttribute hovered;
    private JsonFontStyleAttribute clicked;
}
