package io.github.usafa_compsci350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;

class BoardTest {

  @org.junit.jupiter.api.Test
  void getInputWallOrPawn() {
    Board board = new Board();

    Scanner validWall = new Scanner("wALl");
    Assertions.assertEquals(IsWall.TypeWall.WALLIS, board.getInputWallorPawn(validWall));
    Scanner validPawn = new Scanner("PaWn");
    assertEquals(IsWall.TypeWall.WALLIS,
        board.getInputWallorPawn(validPawn));
    Scanner invalidNum = new Scanner("1");
    assertEquals(IsWall.TypeWall.WALLISNT, board.getInputWallorPawn(invalidNum));
    Scanner invalidStr = new Scanner("heLLoTh3rr3Gen3r@lKen0bi");
    assertEquals(IsWall.TypeWall.WALLISNT, board.getInputWallorPawn(invalidStr));
  }

  @org.junit.jupiter.api.Test
  void determineWin() {
    Board board = new Board();

    Pawn p1 = new Pawn(17, 17);
    Pawn p2 = new Pawn(1, 1);
    Pawn p3 = new Pawn(5, 5);

    assertEquals(1, board.determineWin(1, p1));
    assertEquals(2, board.determineWin(2, p2));
    assertEquals(-1, board.determineWin(1, p3));
  }
}
