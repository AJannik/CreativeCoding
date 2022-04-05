package Util.Geometry;

import Util.Vector2f;
import processing.core.PApplet;

public class Triangle extends Circle {
    public Triangle(PApplet sketch, Vector2f pos, float diameter) {
        super(sketch, pos, diameter);
    }

    public Triangle(PApplet sketch, Vector2f pos, float diameter, Vector2f direction, float acceleration) {
        super(sketch, pos, diameter, direction, acceleration);
    }

    @Override
    protected void draw() {
        sketch.pushMatrix();
        sketch.translate(pos.x, pos.y);
        sketch.rotate(PApplet.atan2(getVelocity().y, getVelocity().x));
        sketch.triangle(getRadius(), 0, -getRadius(), getRadius(), -getRadius(), -getRadius());
        sketch.popMatrix();
    }
}
