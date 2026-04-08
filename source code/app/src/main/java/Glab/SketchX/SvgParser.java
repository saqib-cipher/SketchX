package Glab.SketchX;

import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SvgParser {
    public static class SvgAttributes {
        private List<String> paths = new ArrayList<>();
        private List<String> fills = new ArrayList<>();
        private List<String> strokes = new ArrayList<>();
        private List<String> strokeWidths = new ArrayList<>();
        private String width = "24";
        private String height = "24";
        private String viewportWidth = "24";
        private String viewportHeight = "24";

        public List<String> getPaths() { return paths; }
        public List<String> getFills() { return fills; }
        public List<String> getStrokes() { return strokes; }
        public List<String> getStrokeWidths() { return strokeWidths; }
        public String getWidth() { return width; }
        public String getHeight() { return height; }
        public String getViewportWidth() { return viewportWidth; }
        public String getViewportHeight() { return viewportHeight; }
    }

    public static SvgAttributes extractSvgDetails(String svgContent) {
        SvgAttributes attrs = new SvgAttributes();
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(svgContent));
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String name = parser.getName();
                    if ("svg".equals(name)) {
                        attrs.width = parser.getAttributeValue(null, "width");
                        attrs.height = parser.getAttributeValue(null, "height");
                        String viewBox = parser.getAttributeValue(null, "viewBox");
                        if (viewBox != null) {
                            String[] parts = viewBox.split(" ");
                            if (parts.length == 4) {
                                attrs.viewportWidth = parts[2];
                                attrs.viewportHeight = parts[3];
                            }
                        }
                    } else if ("path".equals(name)) {
                        String d = parser.getAttributeValue(null, "d");
                        if (d != null) attrs.paths.add(d);
                        String fill = parser.getAttributeValue(null, "fill");
                        attrs.fills.add(fill != null ? fill : "none");
                        String stroke = parser.getAttributeValue(null, "stroke");
                        attrs.strokes.add(stroke != null ? stroke : "none");
                        String strokeWidth = parser.getAttributeValue(null, "stroke-width");
                        attrs.strokeWidths.add(strokeWidth != null ? strokeWidth : "1.0");
                    }
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attrs;
    }
}
