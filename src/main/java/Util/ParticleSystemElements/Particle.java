package Util.ParticleSystemElements;

import Util.PhysicsObject;
import Util.Vector2f;
import processing.core.PApplet;

public class Particle extends PhysicsObject {
    protected final float lifespan;
    protected float lifetime;

    public Particle(PApplet sketch, Vector2f pos, float lifespan) {
        super(sketch, pos, new Vector2f(0, 0), 0);
        this.lifespan = lifespan;
        lifetime = lifespan;
    }

    public Particle(PApplet sketch, Vector2f pos, Vector2f direction, float acceleration, float lifespan) {
        super(sketch, pos, direction, acceleration);
        this.lifespan = lifespan;
        lifetime = lifespan;
    }

    @Override
    protected void update(float deltaTime) {
        super.update(deltaTime);
        lifetime = Math.max(lifetime - deltaTime, 0f);
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
