package io.github.usafa_compsci350;

import java.util.Scanner;

public class Pawn extends GamePieces {

  public Pawn(int x, int y) {
    super(x, y);
  }

  public boolean determineTopBlocking(GamePieces[][] board) {
    return board[x1 - 1][y1] != null;
  }

  public boolean determineRightBlocking(GamePieces[][] board) {
    return board[x1][y1 + 1] != null;
  }

  public boolean determineLeftBlocking(GamePieces[][] board) {
    return board[x1][y1 - 1] != null;
  }

  public boolean determineBotBlocking(GamePieces[][] board) {
    return board[x1 + 1][y1] != null;
  }

  public void newPawnPosition(Scanner s, GamePieces[][] board) {
    System.out.println("Please enter up down left right");
    while (true) {
      String direction = s.nextLine();
      if ("up".equalsIgnoreCase(direction)) {
        if (!determineTopBlocking(board)) {
          x1 -= 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }

      if ("down".equalsIgnoreCase(direction)) {
        if (!determineBotBlocking(board)) {
          //System.out.println("is this reached");
          x1 += 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }

      if ("left".equalsIgnoreCase(direction)) {
        if (!determineLeftBlocking(board)) {
          y1 -= 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }

      if ("right".equalsIgnoreCase(direction)) {
        if (!determineRightBlocking(board)) {
          y1 += 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }
    }
  }
}
