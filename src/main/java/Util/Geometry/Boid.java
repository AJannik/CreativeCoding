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
        Vector2f alignment = align(boids);
        alignment.mult(2f);
        Vector2f cohesion = cohesion(boids);
        Vector2f separation = separation(boids);
        separation.mult(2f);

        Vector2f newDirection = new Vector2f(0, 0);
        newDirection.add(alignment);
        newDirection.add(cohesion);
        newDirection.add(separation);
        acceleration = newDirection.magnitude();
        direction.add(newDirection.normalized());
    }

    private Vector2f align(Boid[] boids) {
        Vector2f steeringForce = new Vector2f(0, 0);
        int numBoids = 0;
        for (Boid b : boids) {
            if (b != this && b.pos.distance(pos) < perceptionRadius) {
                steeringForce.add(b.velocity);
                numBoids++;
            }
        }

        if (numBoids > 0) {
            steeringForce.div(numBoids);
            steeringForce.resize(maxSpeed);
            steeringForce.sub(velocity);
            steeringForce.limit(maxForce);
        }

        return steeringForce;
    }

    private Vector2f cohesion(Boid[] boids) {
        Vector2f steeringForce = new Vector2f(0, 0);
        int numBoids = 0;
        for (Boid b : boids) {
            if (b != this && b.pos.distance(pos) < perceptionRadius) {
                steeringForce.add(b.pos);
                numBoids++;
            }
        }

        if (numBoids != 0) {
            steeringForce.div(numBoids);
            steeringForce.sub(pos);
            steeringForce.resize(maxSpeed);
            steeringForce.sub(velocity);
            steeringForce.limit(maxForce);
        }

        return steeringForce;
    }

    private Vector2f separation(Boid[] boids) {
        Vector2f steeringForce = new Vector2f(0, 0);
        int numBoids = 0;
        for (Boid b : boids) {
            float distance = b.pos.distance(pos);
            if (b != this && distance < perceptionRadius) {
                Vector2f diff = Vector2f.sub(pos, b.pos);
                diff.div(distance);
                steeringForce.add(diff);
                numBoids++;
            }
        }

        if (numBoids != 0) {
            steeringForce.div(numBoids);
            steeringForce.resize(maxSpeed);
            steeringForce.sub(velocity);
            steeringForce.limit(maxForce);
        }

        return steeringForce;
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
