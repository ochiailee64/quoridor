package io.github.usafa_compsci350;

import java.util.Arrays;
import java.util.Scanner;

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
    //Per current spec, num of players is 2
    GamePieces[][] gamePieces = new GamePieces[SIZE][SIZE];
    Scanner s = null;
    int playerTurn = 1;
    try {
      s = new Scanner(System.in);

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

      /* Let user place pawns and walls */
      //place walls from "left to right" (really index 0 to 9)
      int p1WallIndex = 0;
      int p2WallIndex = 0;
      Pawn ctrlPwn = p1pawn; //player 1 always goes first
      while (determineWin(playerTurn - 1,
          ctrlPwn) == 0) { //check the previous turn
        drawBoard(gamePieces);
        if (playerTurn == 1) {
          System.out.println("Turn: Player 1");
          if (turn(s, gamePieces, p1pawn, play1Walls, p1WallIndex)) {
            ++p1WallIndex;
            s.nextLine();
          }
          ++playerTurn;
          ctrlPwn = p1pawn;
        } else if (playerTurn == 2) {
          System.out.println("Turn: Player 2");
          if (turn(s, gamePieces, p2pawn, play2Walls, p2WallIndex)) {
            ++p2WallIndex;
            s.nextLine();
          }
          ++playerTurn;
          ctrlPwn = p2pawn;
        } else if (playerTurn == 3) {
          ++playerTurn;
        } else {
          playerTurn = 1;
        }
      }
    } finally {
      s.close(); //close scanner
    }
    drawBoard(gamePieces);
    System.out.printf("Player %d has won!", playerTurn);
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

  /*
   * getInputWallorPawn() - Let user choose to place a "wall" or "pawn"
   */
  public IsWall.TypeWall getInputWallorPawn(Scanner s) {
    System.out.println("Choice wall or pawn: ");
    String choice = s.nextLine();
    if ("wall".equalsIgnoreCase(choice)) {
      return IsWall.TypeWall.WALLIS;
    } else if ("pawn".equalsIgnoreCase(choice)) {
      return IsWall.TypeWall.WALLISNT;
    }
    return IsWall.TypeWall.WALLISNT;
  }

  /*
   * updateBoard() - 'add' piece to gamePieces at a location
   */
  public void updateBoard(GamePieces[][] gamePieces, GamePieces piece) {
    gamePieces[piece.getX()][piece.getY()] = piece;
  }

  /*
   * removeOldPiece() - sets old piece to null
   */
  public void removeOldPiece(GamePieces[][] gamePieces, GamePieces piece) {
    gamePieces[piece.getX()][piece.getY()] = null;
  }

  /*
   * tailUpdate() - places second part of wall
   */
  public void tailUpdate(GamePieces[][] gamePieces, Wall piece) {
    Wall temp = new Wall(piece.getX2(), piece.getY2());
    gamePieces[piece.getX2()][piece.getY2()] = temp;
    System.out.println(piece.getX2());
  }

  /*
   * Turn() - takes user commands to set pawn and wall locations
   */
  private boolean turn(Scanner s, GamePieces[][] gamePieces,
                       Pawn pawn, Wall[] playerWalls, int wallIndex) {
    IsWall.TypeWall wallorNot = getInputWallorPawn(s);
    if (wallorNot == IsWall.TypeWall.WALLISNT) {
      System.out.println("selected pawn");
      removeOldPiece(gamePieces, pawn);
      pawn.newPawnPosition(s, gamePieces);
      updateBoard(gamePieces, pawn);
      return false;
    } else {
      System.out.println("selected wall");
      removeOldPiece(gamePieces, playerWalls[wallIndex]);
      playerWalls[wallIndex].newPosition(s);
      tailUpdate(gamePieces, playerWalls[wallIndex]);
      updateBoard(gamePieces, playerWalls[wallIndex]);
      return true;
    }
  }

  /*
   * determineWin() - check position indices to check if a player has won
   */
  public int determineWin(int playerTurn, Pawn p) {
    if (playerTurn == 1) {
      if (p.getX() >= 17) { //opponent start
        return 1;
      }
    } else if (playerTurn == 2) {
      if (p.getX() <= 1) { //opponent start
        return 2;
      }
    }
    return 0;
  }
}
