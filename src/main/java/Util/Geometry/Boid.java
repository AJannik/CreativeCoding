package Util.Geometry;

import Util.Vector2f;
import processing.core.PApplet;

public class Boid extends Triangle {
    private final float perceptionRadius;
    private float maxSpeed = 8f;
    private float maxForce = 4f;

    public Boid(PApplet sketch, Vector2f pos, float diameter, float perceptionRadius) {
        super(sketch, pos, diameter);
        this.perceptionRadius = perceptionRadius;
    }

    public Boid(PApplet sketch, Vector2f pos, float diameter, float perceptionRadius, Vector2f direction, float acceleration) {
        super(sketch, pos, diameter, direction, acceleration);
        this.perceptionRadius = perceptionRadius;
    }

    @Override
    protected void update(float deltaTime) {
        super.update(deltaTime);
        clampToScreen();
    }

    public void flock(Boid[] boids) {
        Vector2f newDirection = calcNewDirection(boids);
        acceleration = newDirection.magnitude();
        direction.add(newDirection.normalized());
    }

    private Vector2f calcNewDirection(Boid[] boids) {
        Vector2f newDirection = new Vector2f(0, 0);
        Vector2f alignment = new Vector2f(0, 0);
        Vector2f cohesion = new Vector2f(0, 0);
        Vector2f separation = new Vector2f(0, 0);
        int numBoids = 0;

        for (Boid b : boids) {
            float distance = b.pos.distance(pos);
            if (b != this && distance < perceptionRadius) {
                alignment.add(b.velocity);
                cohesion.add(b.pos);

                Vector2f diff = Vector2f.sub(pos, b.pos);
                diff.div(distance);
                separation.add(diff);

                numBoids++;
            }
        }

        if (numBoids > 0) {
            alignment.div(numBoids);
            alignment.resize(maxSpeed);
            alignment.sub(velocity);
            alignment.limit(maxForce);

            cohesion.div(numBoids);
            cohesion.sub(pos);
            cohesion.resize(maxSpeed);
            cohesion.sub(velocity);
            cohesion.limit(maxForce);

            separation.div(numBoids);
            separation.resize(maxSpeed);
            separation.sub(velocity);
            separation.limit(maxForce);
        }

        alignment.mult(2f);
        separation.mult(2f);
        newDirection.add(alignment);
        newDirection.add(cohesion);
        newDirection.add(separation);
        return newDirection;
    }

    private void clampToScreen() {
        if (pos.x > sketch.width) {
            pos.x = 0;
        } else if (pos.x < 0) {
            pos.x = sketch.width;
        }

        if (pos.y > sketch.height) {
            pos.y = 0;
        } else if (pos.y < 0) {
            pos.y = sketch.height;
        }
    }
}
