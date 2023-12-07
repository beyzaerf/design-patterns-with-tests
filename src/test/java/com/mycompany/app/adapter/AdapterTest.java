package com.mycompany.app.adapter;

import com.mycompany.app.adapter.adapters.SquarePegAdapter;
import com.mycompany.app.adapter.round.RoundHole;
import com.mycompany.app.adapter.round.RoundPeg;
import com.mycompany.app.adapter.square.SquarePeg;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class AdapterTest {
    RoundHole roundHole = new RoundHole(5);
    RoundPeg roundPeg = new RoundPeg(5);

    @Test
    public void roundFitsRound() {

        assertTrue(roundHole.fits(roundPeg));
    }

    @Test
    public void smallSquareFitsRoundHole() {
        SquarePeg squarePeg = new SquarePeg(2);
        // roundHole.fits(squarePeg); // gives compiler error because roundHole isn't compatible with square shape
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);
        assertTrue(roundHole.fits(squarePegAdapter));
    }

    @Test
    public void bigSquareFitsRoundHole() {
        SquarePeg squarePeg = new SquarePeg(20);
        // roundHole.fits(squarePeg); // gives compiler error because roundHole isn't compatible with square shape
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);
        assertFalse(roundHole.fits(squarePegAdapter)); // assert false bc square is too big to fit into round hole
    }
}
