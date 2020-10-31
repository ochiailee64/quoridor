package io.github.usafa_compsci350;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

  @org.junit.jupiter.api.Test
  void getInputWallorPawn() {
    Scanner validWall = new Scanner("wALl");
    Assertions.assertEquals(IsWall.IsWaLl.WALLIS, Board.getInputWallorPawn(validWall));
    Scanner validPawn = new Scanner("PaWn");
    assertEquals(IsWall.IsWaLl.WALLIS, Board.getInputWallorPawn(validPawn));
    Scanner invalidNum = new Scanner("1");
    assertEquals(IsWall.IsWaLl.WALLISNT, Board.getInputWallorPawn(invalidNum));
    Scanner invalidStr = new Scanner("heLLoTh3rr3Gen3r@lKen0bi");
    assertEquals(IsWall.IsWaLl.WALLISNT, Board.getInputWallorPawn(invalidStr));
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
