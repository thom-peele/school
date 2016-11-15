package com.infosupport;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by thom on 11/15/16.
 */
public class GameTest {
    private Game game;
    @Before
    public void init() {
        game = new Game();
    }

    @Test
    public void canCreateGame() { // kan weg
        new Game();
    }

    @Test
    public void canRollGutterGame() {
        rollMany(20, 0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void canRollOneGame() {
        rollMany(20, 1);
        assertThat(game.score(), is(20));

    }

    private void rollMany(final int rolls, final int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}

