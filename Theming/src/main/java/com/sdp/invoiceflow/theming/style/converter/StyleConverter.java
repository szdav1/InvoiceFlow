package com.sdp.invoiceflow.theming.style.converter;

import com.sdp.invoiceflow.theming.json.JsonStyle;
import com.sdp.invoiceflow.theming.style.Style;
import com.sdp.invoiceflow.theming.style.elements.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class StyleConverter {
    public static Style convertFromJsonStyle(final JsonStyle jsonStyle) {
        return Style.builder()
            .background(new BackgroundStyleElement(jsonStyle.getBackground()))
            .foreground(new ForegroundStyleElement(jsonStyle.getForeground()))
            .border(new BorderStyleElement(jsonStyle.getBorder()))
            .icon(new IconStyleElement(jsonStyle.getIcon()))
            .font(new FontStyleElement(jsonStyle.getFont()))
            .build();
    }
}
