package io.github.usafa_compsci350;

import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class BoardTest {
  @Test
  public void drawBoardTest() {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    //main only draws the board right now
    Board board = new Board();
    board.drawBoard(new PrintStream(stream));
    String actual = stream.toString();
    //expected string representation of board
    String expected =
        "8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , ,1, , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , , , , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            " , , , , , , , , ,2, , , , , , , , , ,"
            +
            System.lineSeparator()
            +
            "8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8, ,8,"
            +
            System.lineSeparator();
    Assertions.assertEquals(expected, actual);
  }
}
