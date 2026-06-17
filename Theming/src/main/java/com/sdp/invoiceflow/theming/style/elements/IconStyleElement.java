package com.sdp.invoiceflow.theming.style.elements;

import com.sdp.invoiceflow.theming.json.elements.JsonIconElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public final class IconStyleElement {
    @Data
    public static final class IconStyleAttribute {
        private String src;
        private int width;
        private int height;

        public IconStyleAttribute() {
            this.src = "";
            this.width = 0;
            this.height = 0;
        }

        public IconStyleAttribute(final String src, final int width, final int height) {
            this.src = src;
            this.width = width == 0 ? height : width;
            this.height = height == 0 ? width : height;
        }
    }

    private IconStyleAttribute stationary;
    private IconStyleAttribute hovered;
    private IconStyleAttribute clicked;

    public IconStyleElement() {
        this.stationary = new IconStyleAttribute();
        this.hovered = new IconStyleAttribute();
        this.clicked = new IconStyleAttribute();
    }

    public IconStyleElement(final JsonIconElement jsonIconElement) {
        if (jsonIconElement == null) {
            this.stationary = new IconStyleAttribute();
            this.hovered = new IconStyleAttribute();
            this.clicked = new IconStyleAttribute();
            return;
        }

        this.stationary = jsonIconElement.getStationary() == null ?
            new IconStyleAttribute() :
            new IconStyleAttribute(jsonIconElement.getStationary().getSrc(),
                jsonIconElement.getStationary().getWidth(), jsonIconElement.getStationary().getHeight());

        this.hovered = jsonIconElement.getHovered() == null ?
            this.stationary :
            new IconStyleAttribute(jsonIconElement.getHovered().getSrc(),
                jsonIconElement.getHovered().getWidth(), jsonIconElement.getHovered().getHeight());

        this.clicked = jsonIconElement.getClicked() == null ?
            this.hovered :
            new IconStyleAttribute(jsonIconElement.getClicked().getSrc(),
                jsonIconElement.getClicked().getWidth(), jsonIconElement.getClicked().getHeight());
    }
}
