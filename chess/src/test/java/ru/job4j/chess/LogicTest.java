package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenWayIsFree() {
        BishopBlack blackBishopLeft = new BishopBlack(Cell.G7);
        Logic logic = new Logic();
        logic.add(blackBishopLeft);
        assertThat(logic.move(Cell.G7, Cell.C3), is(true));
    }

    @Test
    public void whenWayIsBlocked() {
        BishopBlack blackBishopLeft = new BishopBlack(Cell.C1);
        BishopWhite whiteBishopLeft = new BishopWhite(Cell.E3);
        Logic logic = new Logic();
        logic.add(blackBishopLeft);
        logic.add(whiteBishopLeft);
        assertThat(logic.move(Cell.C1, Cell.H6), is(false));
    }

}
