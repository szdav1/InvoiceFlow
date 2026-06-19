package com.sdp.invoiceflow.theming;

import com.sdp.invoiceflow.theming.cache.StyleCache;
import com.sdp.invoiceflow.theming.cache.elements.*;
import com.sdp.invoiceflow.theming.json.JsonStyle;
import com.sdp.invoiceflow.theming.json.parser.JsonParser;
import com.sdp.invoiceflow.theming.style.elements.*;

import java.awt.geom.Point2D;
import java.util.Map;

@SuppressWarnings("all")
public class Theming {
    public static void main(String[] args) throws Exception {
        Map<String, JsonStyle> jtos = JsonParser.parseJson(Theming.class.getResource("/Theme.json").getFile());
        BackgroundStyleElement bg = new BackgroundStyleElement(jtos.get("Window").getBackground());
        ForegroundStyleElement fg = new ForegroundStyleElement(jtos.get("Window").getForeground());
        BorderStyleElement br = new BorderStyleElement(jtos.get("Window").getBorder());
        IconStyleElement in = new IconStyleElement(jtos.get("Window").getIcon());
        FontStyleElement ft = new FontStyleElement(jtos.get("Window").getFont());
        System.out.println(bg);
        System.out.println(fg);
        System.out.println(br);
        System.out.println(in);
        System.out.println(ft);

        Styles.loadStyle(Theming.class.getResource("/Theme.json").getFile());
        System.out.println(Styles.get("mainpanel"));

        final int WIDTH = 1920;
        final int HEIGHT = 1080;

        StyleCache cache = StyleCache.builder()
            .background(new BackgroundStyleElementCache(new Point2D.Float(0, 0), new Point2D.Float(200, 200), bg))
            .foreground(new ForegroundStyleElementCache(new Point2D.Float(0, 0), new Point2D.Float(200, 200), fg))
            .border(new BorderStyleElementCache(new Point2D.Float(0, 0), new Point2D.Float(200, 200), br))
            .icon(new IconStyleElementCache(WIDTH, in))
            .font(new FontStyleElementCache(WIDTH, ft))
            .build();

        System.out.println(cache);
    }
}
