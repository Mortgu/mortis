package de.mortis.game.util;

import de.mortis.game.entitys.Entity;

public class AABB {

    private Vector2f pos;

    private float xOffset = 0, yOffset = 0;
    private float w, h, r;
    private int size;

    private Entity e;

    public AABB(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w, h);
    }

    public AABB(Vector2f pos, int r, Entity e) {
        this.pos = pos;
        this.r = r;
        this.e = e;

        size = r;
    }

    public void setBox(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;

        size = Math.max(w, h);
    }

    public void setCircle(Vector2f pos, int r) {
        this.pos = pos;
        this.r = r;

        size = r;
    }

    public void setWidth(float f) {
        w = f;
    }
    public void setHeight(float f) {
        this.h = f;
    }

    public  void setXOffset(float f) { xOffset = f; }
    public  void setYOffset(float f) { yOffset = f; }

    public boolean collides(AABB bBox) {
         float ax = ((pos.getWorldVar().x + (xOffset)) + (w / 2));
         float ay = ((pos.getWorldVar().y + (yOffset)) + (h / 2));
         float bx = ((bBox.pos.getWorldVar().x + (bBox.xOffset / 2)) + (w / 2));
         float by = ((bBox.pos.getWorldVar().y + (bBox.yOffset / 2)) + (h / 2));

         if(Math.abs(ax - bx) < (this.w / 2) + (bBox.w / 2)) {
             if(Math.abs(ay - by) < (this.h / 2) + (bBox.h / 2)) {
                 return true;
             }
         }
         return false;
    }

    public boolean colCircleBox(AABB aBox) {

        float cx = (float) (pos.getWorldVar().x + r / Math.sqrt(2) - e.getSize() / Math.sqrt(2));
        float cy = (float) (pos.getWorldVar().y + r / Math.sqrt(2) - e.getSize() / Math.sqrt(2));

        float xDelta = cx - Math.max(aBox.pos.getWorldVar().x + (aBox.getWidth() / 2), Math.min(cx, aBox.pos.getWorldVar().x));
        float yDelta = cy - Math.max(aBox.pos.getWorldVar().y + (aBox.getWidth() / 2), Math.min(cy, aBox.pos.getWorldVar().y));

        if((xDelta * yDelta + yDelta * yDelta) < ((this.r / Math.sqrt(2)) * (this.r / Math.sqrt(2)))) {
            return true;
        }

        return false;
    }

    public Vector2f getPos() {
        return pos;
    }

    public float getWidth() {
        return w;
    }

    public float getHeight() {
        return h;
    }

    public float getRadius() {
        return r;
    }

    public int getSize() {
        return size;
    }
}
