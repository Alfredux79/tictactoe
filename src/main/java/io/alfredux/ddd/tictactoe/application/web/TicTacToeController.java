package io.alfredux.ddd.tictactoe.application.web;

import com.google.common.collect.ImmutableMap;
import io.alfredux.ddd.tictactoe.application.web.response.ApiResponse;
import io.alfredux.ddd.tictactoe.domain.command.CreateGame;
import io.alfredux.ddd.tictactoe.domain.command.Move;
import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

@RestController
public class TicTacToeController {

    private static final String COMMAND = "command";

    @Autowired
    private CommandBus commandBus;

    @PostMapping("create")
    public ApiResponse newGame(@RequestBody CreateGame createGame) {
        commandBus.dispatch(asCommandMessage(createGame));
        return new ApiResponse(ImmutableMap.of(
                COMMAND, createGame
        ));
    }

    @PostMapping("move")
    public ApiResponse move(@RequestBody Move move) {
        commandBus.dispatch(asCommandMessage(move));
        return new ApiResponse(ImmutableMap.of(
                COMMAND, move
        ));
    }
}
