package Util;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleSystem extends GameObject{
    private final ArrayList<Particle> particles = new ArrayList<>();

    public ParticleSystem(PApplet sketch, Vector2f pos) {
        super(sketch, pos);
    }

    @Override
    protected void update(float deltaTime) {
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.run(deltaTime);
            if (!p.isAlive()) {
                it.remove();
            }
        }
    }

    @Override
    protected void draw() {
    }

    public void addCircleParticle(PApplet sketch, float radius, Vector2f offset, Vector2f direction, float acceleration, float lifespan) {
        particles.add(new CircleParticle(radius, Vector2f.add(pos, offset), sketch, direction, acceleration, lifespan));
    }

    public void applyForce(Vector2f force) {
        for (Particle p: particles) {
            p.addForce(force);
        }
    }
}
