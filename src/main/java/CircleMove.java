import processing.core.PApplet;

import java.awt.*;

public class CircleMove extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"CircleMove"};
        CircleMove circleMove = new CircleMove();
        PApplet.runSketch(processingArgs, circleMove);
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int diameterOuter = 40;
    private final int diameterInner = 20;
    private final float shiftStrength = 500f;
    private int seed = 0;

    public void settings() {
        size(Width, Height);
    }

    public void draw() {
        randomSeed(seed);
        frameRate(30);
        background(Color.white.getRGB());
        noStroke();

        fill(Color.black.getRGB());
        for (int x = diameterOuter / 2; x < Width; x += diameterOuter) {
            for (int y = diameterOuter / 2; y < Height; y += diameterOuter) {
                float shiftX = mouseX / (float) Width * random(-1f, 1f) * 1f / frameRate * shiftStrength;
                float shiftY = mouseY / (float) Height * random(-1f, 1f) * 1f / frameRate * shiftStrength;
                ellipse(x + shiftX, y + shiftY, diameterOuter, diameterOuter);
            }
        }

        fill(Color.white.getRGB());
        for (int x = diameterOuter / 2; x < Width; x += diameterOuter) {
            for (int y = diameterOuter / 2; y < Height; y += diameterOuter) {
                ellipse(x, y, diameterInner, diameterInner);
            }
        }
    }

    public void mouseClicked() {
        seed = (int) random(Integer.MAX_VALUE - 1);
    }
}
