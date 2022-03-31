import Util.Triangle;
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
            triangleBoids.add(new Triangle(20, new Vector2f(random(0f, Width), random(0f, Height)), this));
            triangleBoids.get(i).acceleration = triAcceleration;
        }
    }

    public void draw() {
        background(0);
        for (Triangle tri : triangleBoids) {
            tri.direction = new Vector2f(mouseX, mouseY);
            tri.direction.sub(tri.pos);
            if (mousePressed) {
                tri.direction.mult(-1f);
            }

            pushMatrix();
            translate(tri.pos.x, tri.pos.y);
            rotate(atan2(tri.getVelocity().y, tri.getVelocity().x));
            tri.run(1f / frameRate);
            popMatrix();
        }
    }
}
