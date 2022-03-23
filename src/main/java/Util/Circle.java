package Util;

public class Circle {
    public float diameter;
    public Vector2f pos;


    public Circle(float diameter, Vector2f pos) {
        this.diameter = diameter;
        this.pos = pos;
    }

    public boolean circleCollision(Circle circle) {
        return pos.distance(circle.pos) < diameter / 2f + circle.diameter / 2f;
    }
}
