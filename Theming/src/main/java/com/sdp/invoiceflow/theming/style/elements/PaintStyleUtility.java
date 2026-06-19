package com.sdp.invoiceflow.theming.style.elements;

import java.awt.*;

public interface PaintStyleUtility {
    default void parseColors(final Color[] dest, final String[] colorStrs) {
        for (int i = 0; i < colorStrs.length; i++) {
            if (colorStrs[i].isBlank() || colorStrs[i].length() < 6) {
                dest[i] = Color.black;
                continue;
            }

            String base = colorStrs[i].substring(0, 7);
            String opacity = "FF";

            if (colorStrs[i].length() >= 8)
                opacity = colorStrs[i].substring(7, 9);

            Color baseColor;
            Color fullColor;

            try {
                baseColor = Color.decode(base);
                fullColor = new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), Integer.decode("#" + opacity));
            }
            catch (Exception exc) {
                fullColor = Color.black;
            }

            dest[i] = fullColor;
        }
    }

    default void calculateEqualFractions(final float[] dest, final Color[] colors) {
        final int length = colors.length;
        for (int i = 0; i < length; i++)
            dest[i] = ((float) i + 1) / length;
    }
}
