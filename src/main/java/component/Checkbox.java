package component;

import processing.core.PApplet;

public class Checkbox {

    private final PApplet sketch;
    private final float x;
    private final float y;
    private final float squareSize;
    private boolean isChecked;

    public Checkbox(PApplet sketch, float x, float y, float squareSize) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.squareSize = squareSize;
    }

    public void render() {
        if (isChecked) sketch.fill(255, 0, 0);
        else sketch.fill(255,255,255);
        sketch.rect(x, y, squareSize, squareSize);
    }

    public float getSquareSize() {
        return squareSize;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Checkbox switchState() {
        isChecked = !isChecked;
        return this;
    }

    public void cleanAndRefresh() {
        isChecked = false;
        render();
    }
}
