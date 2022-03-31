package Util;

import processing.core.PApplet;

public abstract class GameObject {
    public Vector2f pos;
    protected PApplet sketch;

    public GameObject(PApplet sketch, Vector2f pos) {
        this.sketch = sketch;
        this.pos = pos;
    }

    protected abstract void update(float deltaTime);

    protected abstract void draw();

    public void run(float deltaTime) {
        update(deltaTime);
        draw();
    }
}
