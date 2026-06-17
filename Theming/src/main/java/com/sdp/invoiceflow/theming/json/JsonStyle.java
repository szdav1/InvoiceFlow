package com.sdp.invoiceflow.theming.json;

import com.sdp.invoiceflow.theming.json.elements.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class JsonStyle {
    private JsonBackgroundElement background;
    private JsonForegroundElement foreground;
    private JsonBorderElement border;
    private JsonIconElement icon;
    private JsonFontElement font;
}
