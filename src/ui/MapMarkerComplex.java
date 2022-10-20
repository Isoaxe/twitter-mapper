package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapMarkerComplex extends MapMarkerCircle {
    public static final double defaultMarkerSize = 5.0;
    private Image miniProfilePic;
    private  static final int profilePicSide = 20;

    public MapMarkerComplex(Layer layer, Coordinate coOrd, Color color, Image miniProfilePic) {
        super(layer, null, coOrd, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        this.miniProfilePic = miniProfilePic;
        setColor(Color.BLACK);
        setBackColor(color);
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {
        int profilePicX = position.x - profilePicSide / 2;
        int profilePicY = position.y - profilePicSide / 2;
        g.drawImage(miniProfilePic, profilePicX, profilePicY, 20, 20, null);
    }
}
