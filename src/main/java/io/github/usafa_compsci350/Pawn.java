package io.github.usafa_compsci350;

import java.util.Scanner;

public class Pawn extends GamePieces {

  public Pawn(int x, int y) {
    super(x, y);
  }

  public boolean determineTopBlocking(GamePieces[][] board) {
    return board[x - 1][y] != null;
  }

  public boolean determineRightBlocking(GamePieces[][] board) {
    return board[x][y + 1] != null;
  }

  public boolean determineLeftBlocking(GamePieces[][] board) {
    return board[x][y - 1] != null;
  }

  public boolean determineBotBlocking(GamePieces[][] board) {
    return board[x + 1][y] != null;
  }

  public void newPawnPosition(Scanner s, GamePieces[][] board) {
    System.out.println("Please enter up down left right");
    while (true) {
      String direction = s.nextLine();
      if (direction.equalsIgnoreCase("up")) {
        if (!determineTopBlocking(board)) {
          x -= 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }

      if (direction.equalsIgnoreCase("down")) {
        if (!determineBotBlocking(board)) {
          //System.out.println("is this reached");
          x += 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }

      if (direction.equalsIgnoreCase("left")) {
        if (!determineLeftBlocking(board)) {
          y -= 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }

      if (direction.equalsIgnoreCase("right")) {
        if (!determineRightBlocking(board)) {
          y += 2;
          break;
        } else {
          System.out.println("invalid move");
        }
      }
    }
  }
}
