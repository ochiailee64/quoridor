package io.github.usafa_compsci350;

import java.io.PrintStream;
import java.util.Arrays;

public class Board {
  /* Fields */
  //Size of board is 9x9 (so 9 per row)
  //Walls have their own movement lanes b/w pwn lanes
  //So there's an additional 8 places for walls
  //Finally there's +2 rows/columns for displaying unplaced walls
  public static final int SIZE = 19;
  private static final int WALLSPERPLAYER = 10;
  private Wall[][] walls;
  private Pawn[] pawns;

  public static void main(String[] args) {
    Board board = new Board();
    board.play();
  }

  /*
   * play() - play the game
   */
  public void play() {
    int numPieces = 22;
    int numPlayers = 2;
    walls = new Wall[numPlayers][WALLSPERPLAYER];
    pawns = new Pawn[numPlayers];

    /* Place walls and pawns in gamePieces -
    Structured as [ [p1 walls], p1 pawn, [p2 walls], p2 pwn, ... ] */
    for (int piece = 0; piece < numPieces; ++piece) {
      /* Create and place each wall */
      int loc = 0;
      for (int player = 0; player < numPlayers; ++player) {
        for (int wall = 0; wall < WALLSPERPLAYER; wall++) {
          if (player == 0) {
            walls[player][wall] = new Wall(0, loc);
          } else {
            walls[player][wall] = new Wall(SIZE-1, loc);
          }
          loc += 2; //increment location (pawns and walls have their own lanes
        }
        loc = 0; //reset position
        /* Create and place pawns - Each pwn assignment is 1 player to 1 pawn w/ a unique initialization*/
        if (player == 0)
          pawns[player] = new Pawn(1, 9); //centers player 1 pawn at starting position
        else
          pawns[player] = new Pawn(17, 9); //centers player 2 pawn at starting position
      }
    }
    drawBoard();
  }

  /*
   * drawBoard() - draw the gamePieces
   */
  private void drawBoard() {
    for (int column = 0; column < SIZE; ++column) {
      for (int row = 0; row < SIZE; ++row) {
        /* Check each board on piece */
        if (isWall(column, row)) {
          System.out.print('8');
        }
        else if (isPawn(column, row)) {
          System.out.print('0');
        }
        else {
          System.out.print(' ');
        }
        System.out.print(',');
      }
      System.out.println(); //let os handle column newlines
    }
  }

  /*
   * isWall() - returns true if a wall is at that location
   */
  private boolean isWall(int x, int y) {
    for (Wall[] playersWalls : walls) {
      for (Wall wall : playersWalls) {
        //test both wall locations
        if (((wall.getX1() == x) && (wall.getY1() == y)) ||
            ((wall.getX2() == x) && (wall.getY2() == y)))
          return true;
      }
    }
    return false;
  }

  /*
   * isPawn() - returns true if a pawn is at that location
   */
  private boolean isPawn(int x, int y) {
    for (Pawn pawn : pawns) {
      if ((pawn.getX1() == x) && (pawn.getY1() == y))
        return true;
    }
    return false;
  }
}