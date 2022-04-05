package Util;

import processing.core.PApplet;

public class PhysicsObject extends GameObject {
    protected Vector2f velocity;
    protected Vector2f direction;
    protected float acceleration;

    public PhysicsObject(PApplet sketch, Vector2f pos, Vector2f direction, float acceleration) {
        super(sketch, pos);
        this.direction = direction;
        this.acceleration = acceleration;
        this.velocity = new Vector2f(0f, 0f);
    }

    protected void update(float deltaTime) {
        direction.normalize();
        Vector2f v = direction;
        v.mult(acceleration);
        v.mult(deltaTime);
        velocity.add(v);
        velocity.limit(8f);
        pos.add(velocity);
        acceleration = 0;
        direction.mult(0);
    }

    protected void draw() {
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void addForce(Vector2f force) {
        acceleration += force.magnitude();
        direction.add(force.normalized());
        direction.normalize();
    }
}
