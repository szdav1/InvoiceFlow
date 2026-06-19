package com.sdp.invoiceflow.theming.cache.elements;

import com.sdp.invoiceflow.theming.style.elements.PaintStyle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.awt.geom.Point2D;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class BackgroundStyleElementCache extends PaintStyleCache {
    public BackgroundStyleElementCache(final Point2D start, final Point2D end, final PaintStyle paintStyle) {
        super(start, end, paintStyle);
    }
}
