package com.sdp.invoiceflow.theming.style.elements;

import com.sdp.invoiceflow.theming.json.elements.JsonPaintElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data
public abstract class PaintStyle {
    @Data
    @AllArgsConstructor
    public static final class ColorStyleAttribute implements PaintStyleAttribute {
        private Color[] colors;
        private float[] fractions;

        public ColorStyleAttribute(final String... colorStrs) {
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

        public ColorStyleAttribute() {
            this.colors = new Color[] { Color.black, Color.black };
            this.fractions = new float[] { 0.0F, 1.0F };
        }
    }

    private ColorStyleAttribute stationary;
    private ColorStyleAttribute hovered;
    private ColorStyleAttribute clicked;

    public PaintStyle() {
        this.stationary = new ColorStyleAttribute();
        this.hovered = new ColorStyleAttribute();
        this.clicked = new ColorStyleAttribute();
    }

    public PaintStyle(final JsonPaintElement jsonPaintElement) {
        if (jsonPaintElement == null) {
            this.stationary = new ColorStyleAttribute();
            this.hovered = new ColorStyleAttribute();
            this.clicked = new ColorStyleAttribute();
            return;
        }

        this.stationary = new ColorStyleAttribute(jsonPaintElement.getStationary());
        this.hovered = new ColorStyleAttribute(jsonPaintElement.getHovered());
        this.clicked = new ColorStyleAttribute(jsonPaintElement.getClicked());
    }
}
