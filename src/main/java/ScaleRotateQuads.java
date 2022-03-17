import processing.core.PApplet;

public class ScaleRotateQuads extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"ScaleRotateQuads"};
        ScaleRotateQuads scaleRotateQuads = new ScaleRotateQuads();
        PApplet.runSketch(processingArgs, scaleRotateQuads);
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final float minScaleFactor = 0.8f;
    private final float minRotationRad = 0.01f;
    private final int maxIterations = 200;

    public void settings() {
        size(Width, Height);
    }

    public void draw() {
        background(255);
        rectMode(CENTER);
        translate(width / 2f, height / 2f);
        int sizeX = 900;
        int sizeY = 750;
        int iterations = (int) map(mouseX, 0f, width, 3f, maxIterations);
        float scaleFactor = map(iterations, 3f, maxIterations, minScaleFactor, 0.99f);
        float maxRotationRad = map(mouseY, 0f, height, minRotationRad, 0.5f);
        float rotationRad = map(iterations, maxIterations, 3f, minRotationRad, maxRotationRad);

        for (int i = 1; i <= iterations; i++) {
            rotate(rotationRad);
            rect(0, 0, sizeX, sizeY);
            sizeX *= scaleFactor;
            sizeY *= scaleFactor;
        }
    }
}
