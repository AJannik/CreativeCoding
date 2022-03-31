package Util;

import processing.core.PApplet;
import processing.core.PConstants;

public class Circle extends PhysicsObject {
    public float diameter;

    public Circle(float diameter, Vector2f pos, PApplet sketch) {
        super(sketch, pos, new Vector2f(0, 0), 0);
        this.diameter = diameter;
    }

    public Circle(PApplet sketch, Vector2f pos, Vector2f direction, float acceleration, float diameter) {
        super(sketch, pos, direction, acceleration);
        this.diameter = diameter;
    }

    public boolean circleCollision(Circle circle) {
        return pos.distance(circle.pos) < getRadius() + circle.getRadius();
    }

    @Override
    protected void draw() {
        sketch.ellipseMode(PConstants.CENTER);
        sketch.ellipse(pos.x, pos.y, diameter, diameter);
    }

    public float getRadius() {
        return diameter / 2f;
    }
}
