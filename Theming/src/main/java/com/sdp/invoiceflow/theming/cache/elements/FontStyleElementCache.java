package com.sdp.invoiceflow.theming.cache.elements;

import com.sdp.invoiceflow.theming.style.elements.FontStyleElement;
import lombok.Data;

import java.awt.*;

@Data
public final class FontStyleElementCache {
    private Font stationary;
    private Font hovered;
    private Font clicked;

    @SuppressWarnings("all")
    public FontStyleElementCache(final int proportionBase, final FontStyleElement fontStyleElement) {
        this.stationary = new Font(fontStyleElement.getStationary().getFamily(), fontStyleElement.getStationary().getLigature(),
            proportionBase * fontStyleElement.getStationary().getSize() / 100);

        this.hovered = new Font(fontStyleElement.getHovered().getFamily(), fontStyleElement.getHovered().getLigature(),
            proportionBase * fontStyleElement.getHovered().getSize() / 100);

        this.clicked = new Font(fontStyleElement.getClicked().getFamily(), fontStyleElement.getClicked().getLigature(),
            proportionBase * fontStyleElement.getClicked().getSize() / 100);
    }
}
