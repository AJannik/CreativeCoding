package Util.ParticleSystemElements;

import Util.Vector2f;
import processing.core.PApplet;
import processing.core.PConstants;

public class CircleParticle extends Particle {
    public float diameter;

    public CircleParticle(float diameter, Vector2f pos, PApplet sketch, Vector2f direction, float acceleration, float lifespan) {
        super(sketch, pos, direction, acceleration, lifespan);
        this.diameter = diameter;
    }

    public CircleParticle(float diameter, Vector2f pos, PApplet sketch, float lifespan) {
        super(sketch, pos, lifespan);
        this.diameter = diameter;
    }

    @Override
    protected void draw() {
        sketch.stroke(200, 255f * getLifetimeRelative());
        sketch.fill(200, 255f * getLifetimeRelative());
        sketch.ellipseMode(PConstants.CENTER);
        sketch.ellipse(pos.x, pos.y, diameter, diameter);
    }
}
