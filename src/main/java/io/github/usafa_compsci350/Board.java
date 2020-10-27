package io.github.usafa_compsci350;

import java.util.Arrays;

public class Board {
  /* Fields */
  //Size of board + 2 rows/columns for unplaced walls
  public static final int SIZE = 19;

  public static void main(String[] args) {
    Board board = new Board();
    board.play();
  }

  /*
   * play() - play the game
   */
  public void play() {
    GamePieces[][] gamePieces = new GamePieces[SIZE][SIZE];
    /* Create and initialize wall and pawn positions */
    Wall[] play1Walls = new Wall[10];
    Wall[] play2Walls = new Wall[10];

    //place walls in their starting positions
    int loc = 0;
    for (int i = 0; i < 10; i++) {
      play1Walls[i] = new Wall(0, loc);
      play2Walls[i] = new Wall(18, loc);

      gamePieces[play1Walls[i].getX()][play1Walls[i].getY()] = play1Walls[i];
      gamePieces[play2Walls[i].getX()][play2Walls[i].getY()] = play2Walls[i];

      loc += 2;
    }

    //initialize pawns at starting locations
    Pawn p1pawn = new Pawn(1, 9);
    Pawn p2pawn = new Pawn(17, 9);

    gamePieces[p1pawn.getX()][p1pawn.getY()] = p1pawn;
    gamePieces[p2pawn.getX()][p2pawn.getY()] = p2pawn;

    drawBoard(gamePieces);
  }

  /*
   * drawBoard() - draw the gamePieces
   */
  public static void drawBoard(GamePieces[][] gamePieces) {
    char[][] ascii = new char[SIZE][SIZE];
    for (int i = 0; i < gamePieces.length; i++) {
      for (int j = 0; j < gamePieces[i].length; j++) {
        if (gamePieces[i][j] instanceof Pawn) {
          ascii[i][j] = '0';
        } else if (gamePieces[i][j] instanceof Wall) {
          ascii[i][j] = '8';
        } else {
          ascii[i][j] = ' ';
        }
      }
    }
    for (char[] row : ascii) {
      System.out.println(Arrays.toString(row));
    }
  }
}