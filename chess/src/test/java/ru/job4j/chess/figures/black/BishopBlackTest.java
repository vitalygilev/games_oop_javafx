package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionIsStart() {
        BishopBlack blackBishopLeft = new BishopBlack(Cell.C1);
        assertThat(blackBishopLeft.position(), is(Cell.C1));
    }

    @Test
    public void whenWayIsC1G5() {
        BishopBlack blackBishopLeft = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(blackBishopLeft.way(blackBishopLeft.position(), Cell.G5), is(expected));
    }

    @Test
    public void whenWayIsG7F8() {
        BishopBlack blackBishopLeft = new BishopBlack(Cell.G7);
        Cell[] expected = new Cell[] {Cell.F8};
        assertThat(blackBishopLeft.way(blackBishopLeft.position(), Cell.F8), is(expected));
    }

    @Test
    public void whenWayIsB6G1() {
        BishopBlack blackBishopLeft = new BishopBlack(Cell.B6);
        Cell[] expected = new Cell[] {Cell.C5, Cell.D4, Cell.E3, Cell.F2, Cell.G1};
        assertThat(blackBishopLeft.way(blackBishopLeft.position(), Cell.G1), is(expected));
    }
}
