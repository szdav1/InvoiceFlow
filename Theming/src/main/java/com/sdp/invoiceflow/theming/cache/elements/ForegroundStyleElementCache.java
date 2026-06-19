package com.sdp.invoiceflow.theming.cache.elements;

import com.sdp.invoiceflow.theming.style.elements.PaintStyle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.awt.geom.Point2D;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class ForegroundStyleElementCache extends PaintStyleCache {
    public ForegroundStyleElementCache(Point2D start, Point2D end, PaintStyle paintStyle) {
        super(start, end, paintStyle);
    }
}
