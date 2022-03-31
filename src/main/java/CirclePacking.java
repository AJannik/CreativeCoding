import Util.Geometry.Circle;
import Util.Vector2f;
import processing.core.PApplet;

import java.util.ArrayList;

public class CirclePacking extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"CirclePacking"};
        PApplet.runSketch(processingArgs, new CirclePacking());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int numCircles = 200;
    private ArrayList<Circle> circles = new ArrayList<>();

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        background(0);
        for (int i = 0; i < numCircles; i++) {
            addCircle();
        }
    }

    public void draw() {
        for (Circle circle : circles) {
            circle.run(1f / frameRate);

            boolean collision = false;
            for (Circle other : circles) {
                if (circle != other && circle.circleCollision(other)) {
                    collision = true;
                    break;
                }
            }

            if (!collision) {
                circle.diameter++;
            }
        }
    }

    private void addCircle() {
        boolean validPos = true;
        Vector2f pos;

        do {
            pos = new Vector2f(random(0f, Width), random(0f, Height));
            for (Circle circle : circles) {
                if (circle.circleCollision(new Circle(1f, pos, this))) {
                    validPos = false;
                    break;
                }
            }
        } while (!validPos);


        circles.add(new Circle(1f, pos, this));
    }
}
