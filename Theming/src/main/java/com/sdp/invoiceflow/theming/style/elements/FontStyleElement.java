package com.sdp.invoiceflow.theming.style.elements;

import com.sdp.invoiceflow.theming.json.elements.JsonFontElement;
import lombok.Data;

import java.awt.*;

@Data
public final class FontStyleElement {
    @Data
    public static final class FontStyleAttribute {
        private String family;
        private int ligature;
        private int size;

        public FontStyleAttribute() {
            this.family = Font.MONOSPACED;
            this.ligature = Font.PLAIN;
            this.size = 12;
        }

        public FontStyleAttribute(final String family, final String ligature, final int size) {
            this.family = family == null || family.isBlank() ? Font.MONOSPACED : family;
            this.ligature = this.parseLigature(ligature);
            this.size = size <= 0 ? 12 : size;
        }

        private int parseLigature(final String ligatureStr) {
            if (ligatureStr == null || ligatureStr.isBlank())
                return Font.PLAIN;

            return switch (ligatureStr.toLowerCase()) {
                case "bold" -> Font.BOLD;
                case "italic" -> Font.ITALIC;
                default -> Font.PLAIN;
            };
        }
    }

    private FontStyleAttribute stationary;
    private FontStyleAttribute hovered;
    private FontStyleAttribute clicked;

    public FontStyleElement() {
        this.stationary = new FontStyleAttribute();
        this.hovered = new FontStyleAttribute();
        this.clicked = new FontStyleAttribute();
    }

    public FontStyleElement(final JsonFontElement jsonFontElement) {
        if (jsonFontElement == null) {
            this.stationary = new FontStyleAttribute();
            this.hovered = new FontStyleAttribute();
            this.clicked = new FontStyleAttribute();
            return;
        }

        this.stationary = jsonFontElement.getStationary() == null ?
            new FontStyleAttribute() :
            new FontStyleAttribute(jsonFontElement.getStationary().getFamily(), jsonFontElement.getStationary().getLigature(),
                jsonFontElement.getStationary().getSize());

        this.hovered = jsonFontElement.getHovered() == null ?
            this.stationary :
            new FontStyleAttribute(jsonFontElement.getHovered().getFamily(), jsonFontElement.getHovered().getLigature(),
                jsonFontElement.getHovered().getSize());

        this.clicked = jsonFontElement.getClicked() == null ?
            this.hovered :
            new FontStyleAttribute(jsonFontElement.getClicked().getFamily(), jsonFontElement.getClicked().getLigature(),
                jsonFontElement.getClicked().getSize());
    }
}
