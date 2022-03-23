import processing.core.PApplet;

public class Fractal extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"Fractal"};
        PApplet.runSketch(processingArgs, new Fractal());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int maxIterations = 7;

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        ellipseMode(CENTER);
        noStroke();
        frameRate(30);
    }

    public void draw() {
        background(0);
        translate(Width / 2f, Height / 2f);
        int recursionDepth = (int) map(mouseX, 0f, width, 1f, maxIterations);

        drawFractal(recursionDepth);
    }

    private void drawFractal(int depth) {
        if (depth == 0) {
            ellipse(0, 0, Width, Width);
            return;
        }

        depth--;
        rotate(0.0005f * millis());
        scale(0.44f);
        float scaleX = 1f;
        float scaleY = 1f;
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 1) {
                scaleX *= -1f;
            }

            scaleY *= -1f;

            pushMatrix();
            scale(scaleX, scaleY);
            translate(Width / 2f, Height / 2f);
            drawFractal(depth);
            popMatrix();
        }
    }
}
