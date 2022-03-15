import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class QuarterCircles extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"QuarterCircles"};
        QuarterCircles quarterCircles = new QuarterCircles();
        PApplet.runSketch(processingArgs, quarterCircles);
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int qcPixelSize = 50;
    private final int BorderSize = 1;

    private final Color[] colors = new Color[10];

    public void settings() {
        size(Width, Height);
    }

    public void draw() {
        background(255);
        noStroke();
        generateRandomColors();
        int imageSize = 2 * BorderSize + qcPixelSize;

        for (int x = BorderSize; x < Width; x += imageSize) {
            for (int y = BorderSize; y < Height; y += imageSize) {
                if ((int) random(0f, 5f) == 0 || x + imageSize > Width || y + imageSize > Height) {
                    continue;
                }

                image(GenerateQuarterCircle(), x, y, qcPixelSize, qcPixelSize);
            }
        }

        noLoop();
    }

    public void mouseClicked() {
        redraw();
    }

    private PImage GenerateQuarterCircle() {
        PImage img = createImage(qcPixelSize, qcPixelSize, ARGB);
        int xCenterOffset = getRandomDirection();
        int yCenterOffset = getRandomDirection();
        int colorIndex = getRandomColorIndex();

        for (int y = 0; y < qcPixelSize; y++) {
            for (int x = 0; x < qcPixelSize; x++) {
                // checking if pixel is inside circle -> distance to circle center < radius
                if ((x - xCenterOffset) * (x - xCenterOffset) + (y - yCenterOffset) * (y - yCenterOffset) < qcPixelSize * qcPixelSize) {
                    img.set(x, y, colors[colorIndex].getRGB());
                }
            }
        }

        return img;
    }

    private int getRandomDirection() {
        int centerOffset = qcPixelSize;
        if ((int) random(0, 2) == 0) {
            centerOffset = 0;
        }

        return centerOffset;
    }

    private Color redishColor(int brightness) {
        return new Color(200 + brightness, 50 + brightness, 50 + brightness);
    }

    private int getRandomColorIndex() {
        return (int) random(0f, colors.length - 1f);
    }

    private void generateRandomColors() {
        for (int i = 0; i < colors.length; i++) {
            colors[i] = redishColor((int) random(-50, 50));
        }
    }

}
