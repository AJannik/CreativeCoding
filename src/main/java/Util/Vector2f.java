package Util;

import com.sun.javafx.geom.Vec2f;

public class Vector2f extends Vec2f {
    public Vector2f(float x, float y) {
        super(x, y);
    }

    public float magnitude() {
        if (x == 0f && y == 0) {
            return 0f;
        }

        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2f normalized() {
        if (magnitude() == 0f) {
            return new Vector2f(0f, 0f);
        }

        return new Vector2f(x / magnitude(), y / magnitude());
    }

    public void normalize() {
        if (magnitude() == 0f) {
            x = 0f;
            y = 0f;
            return;
        }

        x = x / magnitude();
        y = y / magnitude();
    }

    public void add(Vector2f v) {
        x += v.x;
        y += v.y;
    }

    public static Vector2f add(Vector2f a, Vector2f b) {
        Vector2f c = new Vector2f(a.x, a.y);
        c.add(b);
        return c;
    }

    public void sub(Vector2f v) {
        x -= v.x;
        y -= v.y;
    }

    public void mult(Vector2f v) {
        x *= v.x;
        y *= v.y;
    }

    public void mult(float f) {
        x *= f;
        y *= f;
    }

    public void limit(float f) {
        if (x > f) {
            x = f;
        }

        if (y > f) {
            y = f;
        }

        if (x < -f) {
            x = -f;
        }

        if (y < -f) {
            y = -f;
        }
    }
}
