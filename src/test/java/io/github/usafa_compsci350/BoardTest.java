package io.github.usafa_compsci350;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import org.junit.jupiter.api.Assertions;



class BoardTest {

  @org.junit.jupiter.api.Test
  void getInputWallorPawn() {
    Scanner validWall = null;
    try {
      validWall = new Scanner("wALl");
      assertEquals(IsWall.IsWaLl.WALLIS,
          Board.getInputWallorPawn(validWall));
    } finally {
      if (validWall != null) {
        validWall.close();
      }
    }
  }

  @org.junit.jupiter.api.Test
  void determineWin() {
    Pawn p1 = new Pawn(17, 17);
    Pawn p2 = new Pawn(1, 1);
    Pawn p3 = new Pawn(5, 5);

    assertEquals(1, Board.determineWin(1, p1));
    assertEquals(2, Board.determineWin(2, p2));
    assertEquals(-1, Board.determineWin(1, p3));
  }
}
