package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import java.awt.*;

public class MapMarkerSimple extends MapMarkerCircle {
    public static final double defaultMarkerSize = 5.0;

    public MapMarkerSimple(Layer layer, Coordinate coOrd, Color color) {
        super(layer, null, coOrd, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(color);
    }
}
