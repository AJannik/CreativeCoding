import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

public class PolarCoords extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"PolarCoords"};
        PApplet.runSketch(processingArgs, new PolarCoords());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int PixelSizeRosePattern = 100;
    private final int BorderSize = 20;
    private ArrayList<Color> colors = new ArrayList<>();
    private final int imagePixelSize = 2 * BorderSize + PixelSizeRosePattern;

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        stroke(255);
        strokeWeight(1f);
        noFill();

        for (int y = 0; y < Height / imagePixelSize; y++) {
            for (int x = 0; x < Width / imagePixelSize; x++) {
                colors.add(generateRandomColor());
            }
        }

        //noLoop();
    }

    public void draw() {
        background(0);

        for (int y = 1; y < Height / imagePixelSize; y++) {
            for (int x = 1; x < Width / imagePixelSize; x++) {
                pushMatrix();
                translate(x * imagePixelSize, y * imagePixelSize);
                drawRosePattern(x, y);
                popMatrix();
            }
        }
    }

    private void drawRosePattern(float x, float y) {
        stroke(colors.get((Width / imagePixelSize * ((int) x - 1) + ((int) y - 1))).getRGB()); // 2d index to 1d index
        float k = y / x;

        beginShape();
        for (float alpha = 0f; alpha < PI * 2f * x; alpha += 0.05f) {
            float r = PixelSizeRosePattern / 2f * cos(k * alpha) + sin(0.005f * millis()) * 2f; // artistic values
            vertex(r * cos(alpha), r * sin(alpha)); // polar to cartesian
        }
        endShape(CLOSE);
    }

    private Color generateRandomColor() {
        return new Color((int) random(0, 255), (int) random(0, 255), (int) random(0, 255), 255);
    }
}
