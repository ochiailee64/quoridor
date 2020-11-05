package io.github.usafa_compsci350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class BoardTest {
  @Test
  public void printBoardTest() {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    //main only draws the board right now
    Board board = new Board();
    board.play();
    String actual = stream.toString();
    //expected string representation of board
    String expected =
        "8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8,\n"
            +
            " , , , , , , , , ,1, , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , , , , , , , , , , , ,\n"
            +
            " , , , , , , , , ,2, , , , , , , , , ,\n"
            +
            "8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8,\n";
    Assertions.assertEquals(expected, actual);
  }
}
