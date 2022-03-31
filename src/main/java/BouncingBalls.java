import Util.Geometry.Circle;
import Util.Vector2f;
import processing.core.PApplet;

import java.util.ArrayList;

public class BouncingBalls extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"BouncingBalls"};
        PApplet.runSketch(processingArgs, new BouncingBalls());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int numBalls = 100;
    private final float ballAcceleration = 10f;
    private ArrayList<Circle> bouncingBalls = new ArrayList<>();

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        ellipseMode(CENTER);
        for (int i = 0; i < numBalls; i++) {
            bouncingBalls.add(new Circle(20, new Vector2f(random(0f, Width), random(0f, Height)), this));
            bouncingBalls.get(i).acceleration = ballAcceleration;
        }
    }

    public void draw() {
        background(0);
        for (Circle b : bouncingBalls) {
            b.direction = new Vector2f(mouseX, mouseY);
            b.direction.sub(b.pos);
            if (mousePressed) {
                b.direction.mult(-1f);
            }

            b.run(1f / frameRate);
        }
    }
}
