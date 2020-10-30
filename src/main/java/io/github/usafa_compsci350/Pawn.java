package io.github.usafa_compsci350;

import java.util.Scanner;

public class Pawn extends GamePieces {

  /*
   * Class Constructor
   */
  public Pawn(int x, int y) {
    super(x, y);
  }

  /*
   * determineBotBlocking() - return true there's no blocking wall upward
   */
  public boolean determineTopBlocking(GamePieces[][] board) {
    return board[x - 1][y] != null;
  }

  /*
   * determineBotBlocking() - return true there's no blocking wall to the right
   */
  public boolean determineRightBlocking(GamePieces[][] board) {
    return board[x][y + 1] != null;
  }

  /*
   * determineLeftBlocking() - return true there's no blocking wall to the left
   */
  public boolean determineLeftBlocking(GamePieces[][] board) {
    return board[x][y - 1] != null;
  }

  /*
   * determineBotBlocking() - return true there's no blocking wall downward
   */
  public boolean determineBotBlocking(GamePieces[][] board) {
    return board[x + 1][y] != null;
  }

  /*
   * newPawnPosition() - Update the pawn's position on the board based on user commands
   */
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
