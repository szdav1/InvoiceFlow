package com.sdp.invoiceflow.theming.json.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class JsonPaintElement implements JsonStyleElement {
    private String[] stationary;
    private String[] hovered;
    private String[] clicked;
}
