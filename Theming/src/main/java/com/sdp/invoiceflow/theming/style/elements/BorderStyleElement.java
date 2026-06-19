package com.sdp.invoiceflow.theming.style.elements;

import com.sdp.invoiceflow.theming.json.elements.JsonBorderElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

@Data
public final class BorderStyleElement {
    @Data
    @AllArgsConstructor
    public static final class BorderStyleAttribute implements PaintStyleUtility {
        private Color[] colors;
        private float[] fractions;
        private int size;
        private int radius;

        public BorderStyleAttribute() {
            this.colors = new Color[] { Color.black, Color.black };
            this.fractions = new float[] { 0.0F, 1.0F };
            this.size = 0;
            this.radius = 0;
        }

        public BorderStyleAttribute(final String[] colorStrs, final int size, final int radius) {
            if (colorStrs == null) {
                this.colors = new Color[] { Color.black, Color.black };
                this.fractions = new float[] { 0.0F, 1.0F };
            }
            else {
                this.colors = new Color[colorStrs.length];
                this.fractions = new float[this.colors.length];

                this.parseColors(this.colors, colorStrs);
                this.calculateEqualFractions(this.fractions, this.colors);
            }

            this.size = size;
            this.radius = radius;
        }
    }

    private BorderStyleAttribute stationary;
    private BorderStyleAttribute hovered;
    private BorderStyleAttribute clicked;

    public BorderStyleElement() {
        this.stationary = new BorderStyleAttribute();
        this.hovered = new BorderStyleAttribute();
        this.clicked = new BorderStyleAttribute();
    }

    public BorderStyleElement(final JsonBorderElement jsonBorderElement) {
        if (jsonBorderElement == null) {
            this.stationary = new BorderStyleAttribute();
            this.hovered = new BorderStyleAttribute();
            this.clicked = new BorderStyleAttribute();
            return;
        }

        this.stationary = jsonBorderElement.getStationary() == null ?
            new BorderStyleAttribute() :
            new BorderStyleAttribute(jsonBorderElement.getStationary().getColors(),
                jsonBorderElement.getStationary().getSize(), jsonBorderElement.getStationary().getRadius());

        this.hovered = jsonBorderElement.getHovered() == null ?
            this.stationary :
            new BorderStyleAttribute(jsonBorderElement.getHovered().getColors(),
                jsonBorderElement.getHovered().getSize(), jsonBorderElement.getHovered().getRadius());

        this.clicked = jsonBorderElement.getClicked() == null ?
            this.hovered :
            new BorderStyleAttribute(jsonBorderElement.getClicked().getColors(),
                jsonBorderElement.getClicked().getSize(), jsonBorderElement.getClicked().getRadius());
    }
}
