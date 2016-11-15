package com.infosupport;

/**
 * Created by thom
 * On 15-11-2016.
 */
public class Game {

    private int score;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}
