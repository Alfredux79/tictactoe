package io.alfredux.ddd.tictactoe.domain.model;

import io.alfredux.ddd.tictactoe.domain.command.Move;

public interface Player {
    Move move();
}
