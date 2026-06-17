package com.sdp.invoiceflow.theming.json.elements;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class JsonIconElement implements JsonStyleElement {
    @Data
    @AllArgsConstructor
    public static final class JsonIconStyleAttribute implements JsonStyleAttribute {
        private String src;
        private int width;
        private int height;
    }

    private JsonIconStyleAttribute stationary;
    private JsonIconStyleAttribute hovered;
    private JsonIconStyleAttribute clicked;
}
