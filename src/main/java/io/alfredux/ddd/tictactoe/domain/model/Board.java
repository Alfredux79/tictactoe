package io.alfredux.ddd.tictactoe.domain.model;

import io.alfredux.ddd.tictactoe.domain.exception.ForbiddenMoveException;

import java.util.Optional;

public interface Board {

    void move(Integer x, Integer y, Cell cell) throws ForbiddenMoveException;

    Optional<Cell> getWinner();
}
