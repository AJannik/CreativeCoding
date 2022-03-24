import Util.Ball;
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
    private ArrayList<Ball> triangleBoids = new ArrayList<>();

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        ellipseMode(CENTER);
        frameRate(30);
        for (int i = 0; i < numTris; i++) {
            triangleBoids.add(new Ball(20, new Vector2f(random(0f, Width), random(0f, Height))));
            triangleBoids.get(i).acceleration = triAcceleration;
        }
    }

    public void draw() {
        background(0);
        for (Ball tri : triangleBoids) {
            tri.direction = new Vector2f(mouseX, mouseY);
            tri.direction.sub(tri.pos);
            if (mousePressed) {
                tri.direction.mult(-1f);
            }

            tri.update(1f / frameRate);
            
            pushMatrix();
            translate(tri.pos.x, tri.pos.y);
            rotate(atan2(tri.getVelocity().y, tri.getVelocity().x));
            triangle(tri.getRadius(), 0, -tri.getRadius(), tri.getRadius(), -tri.getRadius(), -tri.getRadius());
            popMatrix();
        }
    }
}
