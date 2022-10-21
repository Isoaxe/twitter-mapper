package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MapMarkerComplex extends MapMarkerCircle {
    public static final double markerRadius = 13.0;
    private Image miniProfilePic;
    private Color color;
    private static final int profilePicSide = 20;

    public MapMarkerComplex(Layer layer, Coordinate coOrd, Color color, Image miniProfilePic) {
        super(layer, null, coOrd, markerRadius, STYLE.FIXED, getDefaultStyle());
        this.miniProfilePic = miniProfilePic;
        this.color = color;
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {
        int profilePicX = position.x - profilePicSide / 2;
        int profilePicY = position.y - profilePicSide / 2;
        int markerX = position.x - (int) markerRadius;
        int markerY = position.y - (int) markerRadius;
        float markerDiameterFloat = (float) markerRadius * 2;
        int markerDiameterInt = (int) markerRadius * 2;

        g.setClip(new Ellipse2D.Float(markerX, markerY, markerDiameterFloat, markerDiameterFloat));
        g.setColor(color);
        g.fillOval(markerX, markerY, markerDiameterInt, markerDiameterInt);

        g.drawImage(miniProfilePic, profilePicX, profilePicY, 20, 20, null);
    }
}
