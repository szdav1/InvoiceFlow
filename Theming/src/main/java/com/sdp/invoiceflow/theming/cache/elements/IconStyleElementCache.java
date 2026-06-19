package com.sdp.invoiceflow.theming.cache.elements;

import com.sdp.invoiceflow.theming.style.elements.IconStyleElement;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public final class IconStyleElementCache {
    private ImageIcon stationary;
    private ImageIcon hovered;
    private ImageIcon clicked;

    public IconStyleElementCache(final int proportionBase, final IconStyleElement iconStyleElement) {
        this.stationary = new ImageIcon(new ImageIcon(iconStyleElement.getStationary().getSrc()).getImage()
            .getScaledInstance(proportionBase * iconStyleElement.getStationary().getWidth() / 100,
                proportionBase * iconStyleElement.getStationary().getHeight() / 100, Image.SCALE_SMOOTH));

        this.hovered = new ImageIcon(new ImageIcon(iconStyleElement.getHovered().getSrc()).getImage()
            .getScaledInstance(proportionBase * iconStyleElement.getHovered().getWidth() / 100,
                proportionBase * iconStyleElement.getHovered().getHeight() / 100, Image.SCALE_SMOOTH));

        this.clicked = new ImageIcon(new ImageIcon(iconStyleElement.getClicked().getSrc()).getImage()
            .getScaledInstance(proportionBase * iconStyleElement.getClicked().getWidth() / 100,
                proportionBase * iconStyleElement.getClicked().getHeight() / 100, Image.SCALE_SMOOTH));
    }
}
