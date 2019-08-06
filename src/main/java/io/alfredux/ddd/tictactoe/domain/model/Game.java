package io.alfredux.ddd.tictactoe.domain.model;

import io.alfredux.ddd.tictactoe.domain.command.CreateGame;
import io.alfredux.ddd.tictactoe.domain.command.Move;
import io.alfredux.ddd.tictactoe.domain.event.GameCreated;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
@Slf4j
@NoArgsConstructor
public class Game {

    @AggregateIdentifier
    private UUID gameId;

    private ComputerPlayer computer;
    private HumanPlayer human;
    private Board board;

    @CommandHandler
    public Game(CreateGame createGame) {
        log.info("creating Game with ID {}", createGame.getGameId());
        AggregateLifecycle.apply(new GameCreated(createGame.getGameId()));
    }

    @EventSourcingHandler
    public void apply(GameCreated event) {
        this.gameId = event.getGameID();
        this.human = new HumanPlayer();
        this.computer = new ComputerPlayer();
        this.board = new ArrayBoard();
        log.info("created Game with ID {}", gameId);
    }

    @CommandHandler
    public void on(Move move) {
        log.info("move requested {}", move);
    }

}
