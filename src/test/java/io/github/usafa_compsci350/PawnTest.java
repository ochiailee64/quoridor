package io.github.usafa_compsci350;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PawnTest {

  @Test
  void determineTopBlocking() {
    GamePieces[][] board = new GamePieces[5][5]; //test smaller board
    Pawn p1 = new Pawn(3, 3);
    assertFalse(p1.determineTopBlocking(board));
  }

  @Test
  void determineRightBlocking() {
    GamePieces[][] board = new GamePieces[5][5]; //test smaller board
    Pawn p1 = new Pawn(3, 3);
    assertFalse(p1.determineRightBlocking(board));
  }

  @Test
  void determineLeftBlocking() {
    GamePieces[][] board = new GamePieces[5][5]; //test smaller board
    Pawn p1 = new Pawn(3, 3);
    assertFalse(p1.determineLeftBlocking(board));
  }

  @Test
  void determineBotBlocking() {
    GamePieces[][] board = new GamePieces[5][5]; //test smaller board
    Pawn p1 = new Pawn(3, 3);
    assertFalse(p1.determineBotBlocking(board));
  }
}
