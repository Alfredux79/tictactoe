
package io.alfredux.ddd.tictactoe.domain.command;

import io.alfredux.ddd.tictactoe.domain.model.ArrayBoard;
import org.junit.Before;

public class ArrayBoardTest extends BoardTest {

    @Before
    public void setUp() throws Exception {
        board = new ArrayBoard();
    }
}