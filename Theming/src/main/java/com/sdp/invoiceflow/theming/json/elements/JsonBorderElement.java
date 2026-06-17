package com.sdp.invoiceflow.theming.json.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class JsonBorderElement implements JsonStyleElement {
    @Data
    @AllArgsConstructor
    public static final class JsonBorderStyleAttribute implements JsonStyleAttribute {
        private String[] colors;
        private int size;
        private int radius;
    }

    private JsonBorderStyleAttribute stationary;
    private JsonBorderStyleAttribute hovered;
    private JsonBorderStyleAttribute clicked;
}
