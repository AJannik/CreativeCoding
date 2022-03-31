package Util;

import processing.core.PApplet;

public class Circle {
    public float diameter;
    public Vector2f pos;
    protected PApplet sketch;

    public Circle(float diameter, Vector2f pos, PApplet sketch) {
        this.diameter = diameter;
        this.pos = pos;
        this.sketch = sketch;
    }

    public boolean circleCollision(Circle circle) {
        return pos.distance(circle.pos) < getRadius() + circle.getRadius();
    }

    public float getRadius() {
        return diameter / 2f;
    }
}
