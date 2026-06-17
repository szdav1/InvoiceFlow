package com.sdp.invoiceflow.theming.json.elements;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public final class JsonBackgroundElement extends JsonPaintElement {
    public JsonBackgroundElement(String[] stationary, String[] hovered, String[] clicked) {
        super(stationary, hovered, clicked);
    }
}
