package com.sdp.invoiceflow.theming.style.elements;

import com.sdp.invoiceflow.theming.json.elements.JsonPaintElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data
public abstract class PaintStyle {
    @Data
    @AllArgsConstructor
    public static final class PaintStyleAttribute implements PaintStyleUtility {
        private Color[] colors;
        private float[] fractions;

        public PaintStyleAttribute(final String... colorStrs) {
            if (colorStrs == null) {
                this.colors = new Color[] { Color.black, Color.black };
                this.fractions = new float[] { 0.0F, 1.0F };
                return;
            }

            this.colors = new Color[colorStrs.length];
            this.fractions = new float[this.colors.length];

            this.parseColors(this.colors, colorStrs);
            this.calculateEqualFractions(this.fractions, this.colors);
        }

        public PaintStyleAttribute() {
            this.colors = new Color[] { Color.black, Color.black };
            this.fractions = new float[] { 0.0F, 1.0F };
        }
    }

    private PaintStyleAttribute stationary;
    private PaintStyleAttribute hovered;
    private PaintStyleAttribute clicked;

    public PaintStyle() {
        this.stationary = new PaintStyleAttribute();
        this.hovered = new PaintStyleAttribute();
        this.clicked = new PaintStyleAttribute();
    }

    public PaintStyle(final JsonPaintElement jsonPaintElement) {
        if (jsonPaintElement == null) {
            this.stationary = new PaintStyleAttribute();
            this.hovered = new PaintStyleAttribute();
            this.clicked = new PaintStyleAttribute();
            return;
        }

        this.stationary = new PaintStyleAttribute(jsonPaintElement.getStationary());
        this.hovered = new PaintStyleAttribute(jsonPaintElement.getHovered());
        this.clicked = new PaintStyleAttribute(jsonPaintElement.getClicked());
    }
}
