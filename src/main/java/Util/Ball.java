package Util;

public class Ball extends Circle implements IGameObject {
    private Vector2f velocity;
    public Vector2f direction;
    public float acceleration;

    public Ball(float diameter, Vector2f pos) {
        super(diameter, pos);
        this.velocity = new Vector2f(0f, 0f);
        this.direction = new Vector2f(0f, 0f);
        this.acceleration = 0f;
    }

    public Ball(float diameter, Vector2f pos, Vector2f direction, float speed) {
        super(diameter, pos);
        this.direction = direction;
        this.velocity = new Vector2f(0f, 0f);
        this.acceleration = speed;
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
}
