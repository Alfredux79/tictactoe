package io.alfredux.ddd.tictactoe.domain.model;

import io.alfredux.ddd.tictactoe.domain.exception.ForbiddenMoveException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static io.alfredux.ddd.tictactoe.domain.model.Cell._;

@Slf4j
public class ArrayBoard implements Board {

    @Getter
    private Cell[][] cells = new Cell[][]{{_, _, _}, {_, _, _}, {_, _, _}};

    @Override
    public void move(Integer x, Integer y, Cell cell) throws ForbiddenMoveException {
        if (_.equals(cells[x][y])) {
            cells[x][y] = cell;
        } else {
            throw new ForbiddenMoveException("position taken");
        }
    }

    @Override
    public Optional<Cell> getWinner() {
        log.debug("Checking board \n {}", print());
        //Upper left corner
        Cell cellToCheck = cells[0][0];
        if (!_.equals(cellToCheck)) {
            if (
                    (cellToCheck.equals(cells[0][1]) && cellToCheck.equals(cells[0][2])) ||
                            (cellToCheck.equals(cells[1][1]) && cellToCheck.equals(cells[2][2])) ||
                            (cellToCheck.equals(cells[1][0]) && cellToCheck.equals(cells[2][0]))
            ) {
                return Optional.of(cellToCheck);
            }
        }

        //Lower left corner
        cellToCheck = cells[0][2];
        if (!_.equals(cellToCheck)) {
            if (
                    (cellToCheck.equals(cells[1][1]) && cellToCheck.equals(cells[2][0])) ||
                            (cellToCheck.equals(cells[1][2]) && cellToCheck.equals(cells[2][2]))
            ) {
                return Optional.of(cellToCheck);
            }
        }

        //Lower right corner
        cellToCheck = cells[2][2];

        if (!_.equals(cellToCheck) && cellToCheck.equals(cells[2][1]) && cellToCheck.equals(cells[2][0])) {
            return Optional.of(cellToCheck);
        }

        //center vertical
        cellToCheck = cells[1][0];
        if (!_.equals(cellToCheck) && cellToCheck.equals(cells[1][1]) && cellToCheck.equals(cells[1][2])) {
            return Optional.of(cellToCheck);
        }

        //center horizontal
        cellToCheck = cells[0][1];
        if (!_.equals(cellToCheck) && cellToCheck.equals(cells[1][1]) && cellToCheck.equals(cells[2][1])) {
            return Optional.of(cellToCheck);
        }

        return Optional.empty();
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                sb.append(cells[j][i] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
