import processing.core.PApplet;

public class Snowflake extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"Snowflake"};
        PApplet.runSketch(processingArgs, new Snowflake());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int numSegments = 12;

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        background(0);
        stroke(255, 100);
        strokeWeight(20);
    }

    public void draw() {
        if (!mousePressed) {
            return;
        }

        float mX = mouseX - Width / 2f;
        float mY = mouseY - Height / 2f;
        float pmX = pmouseX - Width / 2f;
        float pmY = pmouseY - Height / 2f;

        translate(Width / 2f, Height / 2f);
        float radAngle = 2 * PI / numSegments;

        for (int i = 0; i < numSegments; i++) {
            rotate(radAngle);
            line(mX, mY, pmX, pmY);
            // symmetry
            pushMatrix();
            scale(-1, 1);
            line(mX, mY, pmX, pmY);
            popMatrix();
        }
    }
}
