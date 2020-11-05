package io.github.usafa_compsci350;

import java.io.PrintStream;

public class Board {
  enum PawnId {
    NO_PAWN_PRESENT,
    PAWN1,
    PAWN2
  }

  /* Fields */
  //Size of board is 9x9 (so 9 per row)
  //Walls have their own movement lanes b/w pawn lanes
  //So there's an additional 8 places for walls
  //Finally there's +2 rows/columns for displaying unplaced walls
  public static final int SIZE = 19;
  private static final int NUM_WALLS = 20;
  private static final int numPlayers = 2;
  private int WALLS_PER_PLAYER;
  private final Wall[][] walls;
  private final Pawn[] pawns;

  /* Constructor */
  public Board() {
    WALLS_PER_PLAYER = NUM_WALLS / numPlayers;

    walls = new Wall[numPlayers][WALLS_PER_PLAYER];
    pawns = new Pawn[numPlayers];

    /* Create and place each wall */
    int loc = 0;
    for (int player = 0; player < numPlayers; ++player) {
      for (int wall = 0; wall < WALLS_PER_PLAYER; wall++) {
        if (player == 0) {
          walls[player][wall] = new Wall(0, loc);
        } else {
          walls[player][wall] = new Wall(SIZE - 1, loc);
        }
        loc += 2; //increment location (pawns and walls have their own lanes
      }
      loc = 0; //reset position
      /* Create and place pawns - Each pawn
      assignment is 1 player to 1 pawn w/ a unique initialization*/
      if (player == 0) {
        //centers player 1 pawn at starting position
        pawns[player] = new Pawn(1, 9);
      } else {
        //centers player 2 pawn at starting position
        pawns[player] = new Pawn(17, 9);
      }
    }
  }

  public static void main(String[] args) {
    Board board = new Board();
    board.play();
  }

  /*
   * play() - play the game
   */
  public void play() {
    drawBoard();
  }

  /*
   * drawBoard() - draw the gamePieces
   */
  private void drawBoard() {
    drawBoard(System.out);
  }

  public void drawBoard(PrintStream printStream) {
    for (int column = 0; column < SIZE; ++column) {
      for (int row = 0; row < SIZE; ++row) {
        /* Check each board on piece */
        if (isWall(column, row) != null) {
          printStream.print(isWall(column, row));
        } else if (isPawn(column, row) != null) {
          printStream.print(isPawn(column, row));
        } else {
          printStream.print(' ');
        }
        printStream.print(',');
      }
      printStream.println(); //let os handle column newlines
    }
  }

  /*
   * isWall() - returns "8" if a wall is at that location
   */
  private String isWall(int x, int y) {
    for (Wall[] playersWalls : walls) {
      for (Wall wall : playersWalls) {
        //test both wall locations
        if (wall.covers(x, y)) {
          return "8";
        }
      }
    }
    return null;
  }

  /*
   * isPawn() - returns "1" or "2" if a pawn is at that location
   */
  private String isPawn(int x, int y) {
    for (int i = 0; i < pawns.length; ++i) {
      if (pawns[i].covers(x, y)) {
        if (i == 0) {
          return "1";
        } else {
          return "2";
        }
      }
    }
    return null;
  }
}