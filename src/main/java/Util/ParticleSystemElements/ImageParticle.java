package Util.ParticleSystemElements;

import Util.Vector2f;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class ImageParticle extends Particle {
    public Vector2f size;
    private final PImage img;

    public ImageParticle(PApplet sketch, Vector2f pos, Vector2f size, Vector2f direction, float acceleration, float lifespan, String imgPath) {
        super(sketch, pos, direction, acceleration, lifespan);
        img = sketch.loadImage(imgPath);
        this.size = size;
    }

    public ImageParticle(PApplet sketch, Vector2f pos, Vector2f size, float lifespan, String imgPath) {
        super(sketch, pos, lifespan);
        img = sketch.loadImage(imgPath);
        this.size = size;
    }

    @Override
    protected void draw() {
        sketch.imageMode(PConstants.CENTER);
        sketch.tint((int) ((0.05 * sketch.millis()) % 256), 255, 255, 255 * getLifetimeRelative());
        sketch.image(img, pos.x, pos.y, size.x, size.y);
    }
}
