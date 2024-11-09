package test;

import colorclicker.Board;
import colorclicker.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;
import java.awt.Color;

class BoardTest {

    private Board board;
    private final int boardSize = 3;

    @BeforeEach
    void setUp() {
        board = new Board(boardSize);
    }

    @Test
    void testBoardInit() {
        assertEquals(boardSize, board.getBoardSize());
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                assertNotNull(board.get(i, j));
            }
        }
    }

    @Test
    void testIsOverWhenBoardIsEmpty() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                assertNull(board.get(i, j).getColor());
            }
        }
        assertFalse(board.isOver());
    }

    @Test
    void testIsOverWhenBoardIsFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board.get(i, j).setColor(Color.BLUE);
            }
        }
        assertTrue(board.isOver());
    }

    @Test
    void testGetFieldByCoordinates() {
        Field field = board.get(1, 1);
        assertNotNull(field);
    }

    @Test
    void testGetFieldByPoint() {
        Point point = new Point(2, 2);
        Field field = board.get(point);
        assertNotNull(field);
    }
}