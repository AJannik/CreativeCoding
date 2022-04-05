import Util.Geometry.Triangle;
import Util.Vector2f;
import processing.core.PApplet;

import java.util.ArrayList;

public class AttractedTris extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"AttractedTris"};
        PApplet.runSketch(processingArgs, new AttractedTris());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final int numTris = 100;
    private final float triAcceleration = 10f;
    private ArrayList<Triangle> triangleBoids = new ArrayList<>();

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        ellipseMode(CENTER);
        for (int i = 0; i < numTris; i++) {
            triangleBoids.add(new Triangle(this, new Vector2f(random(0f, Width), random(0f, Height)), 20));
        }
    }

    public void draw() {
        background(0);
        for (Triangle tri : triangleBoids) {
            Vector2f force = new Vector2f(mouseX, mouseY);
            force.sub(tri.pos);
            force.normalize();
            force.mult(triAcceleration);

            if (mousePressed) {
                force.mult(-1f);
            }

            tri.addForce(force);
            tri.run(1f / frameRate);
        }
    }
}
