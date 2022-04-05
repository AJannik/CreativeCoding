import Util.Geometry.Boid;
import Util.Vector2f;
import processing.core.PApplet;

public class Flocking extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"Flocking"};
        PApplet.runSketch(processingArgs, new Flocking());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private Boid[] boids = new Boid[100];

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30f);
        ellipseMode(CENTER);
        for (int i = 0; i < boids.length; i++) {
            boids[i] = new Boid(this, new Vector2f(random(0f, Width), random(0f, Height)), 15f, 50f, new Vector2f(random(-1f, 1f), random(-1f, 1f)).normalized(), 50f);
        }
    }

    public void draw() {
        background(0);
        for (Boid b : boids) {
            b.run(1f / frameRate);
            b.flock(boids);
        }
    }
}
