package Util;

import processing.core.PApplet;
import processing.core.PConstants;

public class Ball extends Circle implements IGameObject {
    protected Vector2f velocity;
    public Vector2f direction;
    public float acceleration;

    public Ball(float diameter, Vector2f pos, PApplet sketch) {
        super(diameter, pos, sketch);
        this.velocity = new Vector2f(0f, 0f);
        this.direction = new Vector2f(0f, 0f);
        this.acceleration = 0f;
    }

    public Ball(float diameter, Vector2f pos, PApplet sketch, Vector2f direction, float acceleration) {
        super(diameter, pos, sketch);
        this.direction = direction;
        this.velocity = new Vector2f(0f, 0f);
        this.acceleration = acceleration;
    }

    public void update(float deltaTime) {
        direction.normalize();
        Vector2f v = direction;
        v.mult(acceleration);
        v.mult(deltaTime);
        velocity.add(v);
        velocity.limit(10f);
        pos.add(velocity);
    }

    protected void draw() {
        sketch.ellipseMode(PConstants.CENTER);
        sketch.ellipse(pos.x, pos.y, getRadius(), getRadius());
    }

    public void run(float deltaTime) {
        update(deltaTime);
        draw();
    }

    public Vector2f getVelocity() {
        return velocity;
    }
}
