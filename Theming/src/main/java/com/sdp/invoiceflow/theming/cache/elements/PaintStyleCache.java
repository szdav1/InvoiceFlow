package com.sdp.invoiceflow.theming.cache.elements;

import com.sdp.invoiceflow.theming.style.elements.PaintStyle;
import lombok.Data;

import java.awt.*;
import java.awt.geom.Point2D;

@Data
public abstract class PaintStyleCache {
    private LinearGradientPaint stationary;
    private LinearGradientPaint hovered;
    private LinearGradientPaint clicked;

    public PaintStyleCache(final Point2D start, final Point2D end, final PaintStyle paintStyle) {
        this.stationary = new LinearGradientPaint(start, end, paintStyle.getStationary().getFractions(),
            paintStyle.getStationary().getColors());

        this.hovered = new LinearGradientPaint(start, end, paintStyle.getHovered().getFractions(),
            paintStyle.getHovered().getColors());

        this.clicked = new LinearGradientPaint(start, end, paintStyle.getClicked().getFractions(),
            paintStyle.getClicked().getColors());
    }
}
