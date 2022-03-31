import Util.ParticleSystem;
import Util.Vector2f;
import processing.core.PApplet;

public class ParticleSystemSketch extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"ParticleSystem"};
        PApplet.runSketch(processingArgs, new ParticleSystemSketch());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final ParticleSystem ps = new ParticleSystem(this, new Vector2f(200, 200));

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        ellipseMode(CENTER);
    }

    public void draw() {
        background(255);
        ps.addCircleParticle(this, 25, new Vector2f(500, 200), new Vector2f(0f, 1f), 5f, 5f);
        ps.applyForce(new Vector2f(random(-5f, 5f), -8f));

        ps.run(1f / frameRate);
    }
}
