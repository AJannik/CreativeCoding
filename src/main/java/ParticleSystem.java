import Util.Particle;
import Util.Vector2f;
import processing.core.PApplet;

public class ParticleSystem extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"ParticleSystem"};
        PApplet.runSketch(processingArgs, new ParticleSystem());
    }

    private final int Width = 1000;
    private final int Height = 1000;
    private Particle p = new Particle(100, new Vector2f(200, 200), this, new Vector2f(1f, 0f), 1f,5f);

    public void settings() {
        size(Width, Height);
    }

    public void setup() {
        frameRate(30);
        ellipseMode(CENTER);
    }

    public void draw() {
        background(255);
        p.run(1f / frameRate);
    }
}
