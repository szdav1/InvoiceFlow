package com.sdp.invoiceflow.theming.cache;

import com.sdp.invoiceflow.theming.cache.elements.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class StyleCache {
    private BackgroundStyleElementCache background;
    private ForegroundStyleElementCache foreground;
    private BorderStyleElementCache border;
    private IconStyleElementCache icon;
    private FontStyleElementCache font;
}
