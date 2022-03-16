import processing.core.PApplet;

public class TransformQuads extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"TransformQuads"};
        TransformQuads transformQuads = new TransformQuads();
        PApplet.runSketch(processingArgs, transformQuads);
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int rectSize = 40;
    private final float maxRotationRad = 0.05f;
    private final float maxTranslation = 1f;
    private int seed = 0;

    public void settings() {
        size(Width, Height);
    }

    public void draw() {
        frameRate(30);
        randomSeed(seed);
        frameRate(30);
        background(255);
        fill(255);
        strokeWeight(4f);

        pushMatrix();
        translate((Width - 12f * rectSize) / 2f, 0);
        drawGrid();
        popMatrix();
    }

    private void drawGrid() {
        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 24; y++) {
                pushMatrix();
                translate(rectSize * x, rectSize * y);

                float modifier = sin(0.001f * millis());
                translate(random(-1f, 1f) * modifier * maxTranslation * y, random(-1f, 1f) * modifier * maxTranslation * y);
                rotate(random(-1f, 1f) * y * modifier * maxRotationRad);
                rect(0, 0, rectSize, rectSize);
                popMatrix();
            }
        }
    }

    public void mouseClicked() {
        seed = (int) random(Integer.MAX_VALUE - 1);
    }
}
