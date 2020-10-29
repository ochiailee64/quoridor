package io.github.usafa_compsci350;

import java.util.Arrays;

public class Board {
  /* Fields */
  //Size of board + 2 rows/columns for unplaced walls
  public static final int SIZE = 19;
  private static final int WALLSPERPLAYER = 10;

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
    Wall[] play1Walls = new Wall[WALLSPERPLAYER]; //todo array?
    Wall[] play2Walls = new Wall[WALLSPERPLAYER];

    //place walls in their starting positions
    int loc = 0;
    for (int i = 0; i < WALLSPERPLAYER; i++) {
      play1Walls[i] = new Wall(0, loc);
      play2Walls[i] = new Wall(WALLSPERPLAYER-1, loc);

      gamePieces[play1Walls[i].getX()][play1Walls[i].getY()] = play1Walls[i]; //todo array?
      gamePieces[play2Walls[i].getX()][play2Walls[i].getY()] = play2Walls[i];

      loc += 2;
    }

    //initialize pawns at starting locations
    Pawn p1pawn = new Pawn(1, 9);
    Pawn p2pawn = new Pawn(17, 9);

    gamePieces[p1pawn.getX()][p1pawn.getY()] = p1pawn; //todo array?
    gamePieces[p2pawn.getX()][p2pawn.getY()] = p2pawn;

    drawBoard(gamePieces);
  }

  /*
   * drawBoard() - draw the gamePieces
   */
  private void drawBoard(GamePieces[][] gamePieces) {
    char[][] ascii = new char[SIZE][SIZE];
    for (int i = 0; i < gamePieces.length; i++) {
      for (int j = 0; j < gamePieces[i].length; j++) {
        if (gamePieces[i][j] != null) { //cannot call pickChar() on null
          ascii[i][j] = gamePieces[i][j].pickChar();
        }
        else {
          ascii[i][j] = ' ';
        }
      }
    }
    //have println() handle newlines for each row
    for (char[] row : ascii) {
      System.out.println(Arrays.toString(row));
    }
  }
}