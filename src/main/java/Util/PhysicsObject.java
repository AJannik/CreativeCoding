package Util;

import processing.core.PApplet;

public class PhysicsObject extends GameObject {
    protected Vector2f velocity;
    public Vector2f direction;
    public float acceleration;

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
        velocity.limit(10f);
        pos.add(velocity);
    }

    protected void draw() {
    }

    public Vector2f getVelocity() {
        return velocity;
    }
}
