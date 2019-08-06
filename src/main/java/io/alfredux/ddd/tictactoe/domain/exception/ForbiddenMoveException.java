package io.alfredux.ddd.tictactoe.domain.exception;

public class ForbiddenMoveException extends Exception {
    public ForbiddenMoveException(String message) {
        super(message);
    }
}
