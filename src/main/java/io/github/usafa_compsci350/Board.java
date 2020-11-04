package io.github.usafa_compsci350;

import java.util.Arrays;

public class Board {
  /* Fields */
  //Size of board is 9x9 (so 9 per row)
  //Walls have their own movement lanes b/w pwn lanes
  //So there's an additional 8 places for walls
  //Finally there's +2 rows/columns for displaying unplaced walls
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
    GamePiece[][] gamePieces = new GamePiece[SIZE][SIZE]; //make into a 1D array
    /* Create and initialize wall and pawn positions */
    Wall[] play1Walls = new Wall[WALLSPERPLAYER]; //todo array? -awaiting clarification
    Wall[] play2Walls = new Wall[WALLSPERPLAYER]; //todo array?

    //place walls in their starting positions
    int loc = 0;
    for (int i = 0; i < WALLSPERPLAYER; i++) {
      play1Walls[i] = new Wall(0, loc);
      play2Walls[i] = new Wall(WALLSPERPLAYER-1, loc);

      gamePieces[play1Walls[i].getX1()][play1Walls[i].getY1()] = play1Walls[i]; //todo array? -awaiting clarification
      gamePieces[play2Walls[i].getX1()][play2Walls[i].getY1()] = play2Walls[i]; //todo array?

      loc += 2;
    }

    //initialize pawns at starting locations
    Pawn p1pawn = new Pawn(1, 9); //todo array? -awaiting clarification
    Pawn p2pawn = new Pawn(17, 9); //todo array?

    gamePieces[p1pawn.getX1()][p1pawn.getY1()] = p1pawn; //todo array? -awaiting clarification
    gamePieces[p2pawn.getX1()][p2pawn.getY1()] = p2pawn; //todo array?

    drawBoard(gamePieces);
  }

  /*
   * drawBoard() - draw the gamePieces
   */
  private void drawBoard(GamePiece[][] gamePieces) {
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