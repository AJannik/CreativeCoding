package Util;

import processing.core.PApplet;

public class Particle extends Ball {
    private final float lifespan;
    private float lifetime;

    public Particle(float diameter, Vector2f pos, PApplet sketch, Vector2f direction, float acceleration, float lifespan) {
        super(diameter, pos, sketch, direction, acceleration);
        this.lifespan = lifespan;
        lifetime = lifespan;
    }

    public Particle(float diameter, Vector2f pos, PApplet sketch, float lifespan) {
        super(diameter, pos, sketch);
        this.lifespan = lifespan;
        lifetime = lifespan;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        lifetime = Math.max(lifetime - deltaTime, 0f);
    }

    @Override
    protected void draw() {
        sketch.stroke(0f, 255f * getLifetimeRelative());
        sketch.fill(0f, 255f * getLifetimeRelative());
        super.draw();
    }

    public float getLifetimeRelative() {
        return lifetime / lifespan;
    }

    public float getLifetimeAbsolute() {
        return lifetime;
    }

    public boolean isAlive() {
        return lifetime > 0f;
    }
}
