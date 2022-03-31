package Util;

import processing.core.PApplet;

public class Triangle extends Ball{
    public Triangle(float diameter, Vector2f pos, PApplet sketch) {
        super(diameter, pos, sketch);
    }

    @Override
    protected void draw() {
        sketch.triangle(getRadius(), 0, -getRadius(), getRadius(), -getRadius(), -getRadius());
    }
}
