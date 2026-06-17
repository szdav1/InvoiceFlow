package com.sdp.invoiceflow.theming.style.elements;

import com.sdp.invoiceflow.theming.json.elements.JsonPaintElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class BackgroundStyleElement extends PaintStyle {
    public BackgroundStyleElement() {
    }

    public BackgroundStyleElement(final JsonPaintElement jsonBackgroundElement) {
        super(jsonBackgroundElement);
    }
}
