package com.sdp.invoiceflow.theming.cache.elements;

import com.sdp.invoiceflow.theming.style.elements.BorderStyleElement;
import lombok.Data;

import java.awt.*;
import java.awt.geom.Point2D;

@Data
public final class BorderStyleElementCache {
    @Data
    public static final class BorderStyleCacheAttribute {
        private LinearGradientPaint paint;
        private int size;
        private int radius;

        public BorderStyleCacheAttribute(final Point2D start, final Point2D end, final BorderStyleElement.BorderStyleAttribute borderStyleAttribute) {
            this.paint = new LinearGradientPaint(start, end, borderStyleAttribute.getFractions(), borderStyleAttribute.getColors());
            this.size = borderStyleAttribute.getSize();
            this.radius = borderStyleAttribute.getRadius();
        }
    }

    private BorderStyleCacheAttribute stationary;
    private BorderStyleCacheAttribute hovered;
    private BorderStyleCacheAttribute clicked;

    public BorderStyleElementCache(final Point2D start, final Point2D end, final BorderStyleElement borderStyleElement) {
        this.stationary = new BorderStyleCacheAttribute(start, end, borderStyleElement.getStationary());
        this.hovered = new BorderStyleCacheAttribute(start, end, borderStyleElement.getHovered());
        this.clicked = new BorderStyleCacheAttribute(start, end, borderStyleElement.getClicked());
    }
}
