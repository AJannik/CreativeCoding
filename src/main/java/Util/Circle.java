package Util;

import processing.core.PApplet;

public class Circle extends GameObject{
    public float diameter;

    public Circle(float diameter, Vector2f pos, PApplet sketch) {
        super(sketch, pos);
        this.diameter = diameter;
    }

    public boolean circleCollision(Circle circle) {
        return pos.distance(circle.pos) < getRadius() + circle.getRadius();
    }

    public float getRadius() {
        return diameter / 2f;
    }

    @Override
    protected void update(float deltaTime) {
    }

    @Override
    protected void draw() {
        sketch.ellipse(pos.x, pos.y, diameter, diameter);
    }

    @Override
    public void run(float deltaTime) {
        update(deltaTime);
        draw();
    }
}
