package io.github.usafa_compsci350;

import java.io.PrintStream;

public class Board {
  /* Fields */
  //Size of board is 9x9 (so 9 per row)
  //Walls have their own movement lanes b/w pawn lanes
  //So there's an additional 8 places for walls
  //Finally there's +2 rows/columns for displaying unplaced walls
  public static final int SIZE = 19;
  private static final int NUM_WALLS = 20;
  private static final int numPlayers = 2;
  private final Wall[][] walls;
  private final Pawn[] pawns;

  /* Constructor */
  public Board() {
    int wallsPerPlayer = NUM_WALLS / numPlayers;
    walls = new Wall[numPlayers][wallsPerPlayer];
    pawns = new Pawn[numPlayers];

    /* Create and place each wall */
    int loc = 0;
    for (int player = 0; player < numPlayers; ++player) {
      for (int wall = 0; wall < wallsPerPlayer; wall++) {
        int row = player == 0 ? 0 : SIZE - 1;
        walls[player][wall] = new Wall(row, loc);
        loc += 2; //increment location (pawns and walls have their own lanes
      }
      loc = 0; //reset position
      /* Create and place pawns - Each pawn
      assignment is 1 player to 1 pawn w/ a unique initialization */
      //center pawns at starting positions
      int row = player == 0 ? 1 : 17;
      pawns[player] = new Pawn(row, 9);
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
    for (int row = 0; row < SIZE; ++row) {
      for (int column = 0; column < SIZE; ++column) {
        /* Check each board on piece */
        if (isWall(row, column) != null) {
          printStream.print(isWall(row, column));
        } else if (isPawn(row, column) != null) {
          printStream.print(isPawn(row, column));
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