import Util.ParticleSystemElements.ParticleSystem;
import Util.Vector2f;
import processing.core.PApplet;

public class ParticleSystemSketch extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"ParticleSystem"};
        PApplet.runSketch(processingArgs, new ParticleSystemSketch());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private final ParticleSystem ps = new ParticleSystem(this, new Vector2f(Width / 2f, Height / 2f));
    private final float forceTime = 1f;
    private float timer = 2f;
    private Vector2f force = new Vector2f(0f, 0f);

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        ellipseMode(CENTER);
        blendMode(ADD);
        colorMode(HSB, 255);
    }

    public void draw() {
        background(0f);

        if (timer >= forceTime) {
            force = new Vector2f(random(-20f, 20f), random(-40f, 40f));
            timer = 0f;
        }

        if (ps.getNumberParticles() < 100) {
            ps.addImageParticle(this, new Vector2f(0, 0), new Vector2f(100, 100), 2f, "src/main/resources/dot.png");
        }

        ps.applyForce(force);
        ps.run(1f / frameRate);
        timer += 1f / frameRate;
    }
}
