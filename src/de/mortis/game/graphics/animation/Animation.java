package de.mortis.game.graphics.animation;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] frames;
    private int currentFrame, numFrame;

    private int count, delay, timesPlayed;

    public Animation(BufferedImage[] frames) {
        timesPlayed = 0;
        setFrames(frames);

        stop();
    }

    public Animation() {
        timesPlayed = 0;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        numFrame = frames.length;

        currentFrame = 0;
        count = 0;
        timesPlayed = 0;
        delay = 2;
    }

    public void update() {
        if(delay == -1) return;
        count++;

        if(count == delay) {
            currentFrame++;
            count = 0;
        }

        if(currentFrame == numFrame) {
            currentFrame = 0;
            timesPlayed++;
        }
    }

    public void stop() {
        setDelay(-1);
    }

    public BufferedImage[] getFrames() {
        return frames;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getNumFrame() {
        return numFrame;
    }

    public void setNumFrame(int numFrame) {
        this.numFrame = numFrame;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public BufferedImage getImage() { return frames[currentFrame]; }
}
