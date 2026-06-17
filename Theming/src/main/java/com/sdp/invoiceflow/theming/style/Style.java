package com.sdp.invoiceflow.theming.style;

import com.sdp.invoiceflow.theming.style.elements.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Style {
    private BackgroundStyleElement background;
    private ForegroundStyleElement foreground;
    private BorderStyleElement border;
    private IconStyleElement icon;
    private FontStyleElement font;

    public static Style withDefaults() {
        return Style.builder()
            .background(new BackgroundStyleElement())
            .foreground(new ForegroundStyleElement())
            .border(new BorderStyleElement())
            .icon(new IconStyleElement())
            .font(new FontStyleElement())
            .build();
    }
}
