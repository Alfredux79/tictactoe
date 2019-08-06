package io.alfredux.ddd.tictactoe.domain.command;

import io.alfredux.ddd.tictactoe.domain.exception.ForbiddenMoveException;
import io.alfredux.ddd.tictactoe.domain.model.Board;
import io.alfredux.ddd.tictactoe.domain.model.Cell;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    Board board;

    @Test
    public void whenBoardIsEmptyShouldNotHaveWinner() {
        assertEquals(board.getWinner(), Optional.empty());
    }

    @Test(expected = ForbiddenMoveException.class)
    public void whenTheSameCellIsAttemptedTwice() throws ForbiddenMoveException {
        board.move(0, 0, Cell.O);
        board.move(0, 0, Cell.O);
    }

    @Test
    public void whenFirstVerticalRowHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(0, 0, Cell.O);
        board.move(0, 1, Cell.O);
        board.move(0, 2, Cell.O);
        assertEquals(board.getWinner(), Optional.of(Cell.O));
    }

    @Test
    public void whenSecondVerticalRowHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(1, 0, Cell.X);
        board.move(1, 1, Cell.X);
        board.move(1, 2, Cell.X);
        assertEquals(board.getWinner(), Optional.of(Cell.X));
    }

    @Test
    public void whenThirdVerticalRowHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(2, 0, Cell.X);
        board.move(2, 1, Cell.X);
        board.move(2, 2, Cell.X);
        assertEquals(board.getWinner(), Optional.of(Cell.X));
    }

    @Test
    public void whenFirstHorizontalRowHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(0, 0, Cell.O);
        board.move(1, 0, Cell.O);
        board.move(2, 0, Cell.O);
        assertEquals(board.getWinner(), Optional.of(Cell.O));
    }

    @Test
    public void whenSecondHorizontalRowHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(0, 1, Cell.O);
        board.move(1, 1, Cell.O);
        board.move(2, 1, Cell.O);
        assertEquals(board.getWinner(), Optional.of(Cell.O));
    }

    @Test
    public void whenThirdHorizontalRowHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(0, 2, Cell.O);
        board.move(1, 2, Cell.O);
        board.move(2, 2, Cell.O);
        assertEquals(board.getWinner(), Optional.of(Cell.O));
    }

    @Test
    public void whenFirstDiagonalHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(0, 0, Cell.O);
        board.move(1, 1, Cell.O);
        board.move(2, 2, Cell.O);
        assertEquals(board.getWinner(), Optional.of(Cell.O));
    }

    @Test
    public void whenSecondDiagonalHasWinnerShouldReturnAWinner() throws ForbiddenMoveException {
        board.move(2, 0, Cell.O);
        board.move(1, 1, Cell.O);
        board.move(0, 2, Cell.O);
        assertEquals(board.getWinner(), Optional.of(Cell.O));
    }
}
