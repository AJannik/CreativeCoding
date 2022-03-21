package Util;

import com.sun.javafx.geom.Vec2f;

public class Circle {
    public float diameter;
    public Vec2f pos;

    public Circle(float diameter, Vec2f pos) {
        this.diameter = diameter;
        this.pos = pos;
    }

    public boolean circleCollision(Circle circle) {
        return pos.distance(circle.pos) < diameter / 2f + circle.diameter / 2f;
    }
}
