package io.github.usafa_compsci350;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
  /* Fields */
  public static final int SIZE = 19; //Size of board + 2 rows/columns for unplaced walls

  public static void main(String[] args) {
    Board board = new Board();
    board.play();
  }

  public void play() {
    int playerturn = 1;
    //Per current spec, num of players is 2
    GamePieces[][] gamePieces = new GamePieces[SIZE][SIZE];
    Scanner s = new Scanner(System.in);

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

    /* Draw Board */
    //drawBoard(gamePieces);

    /* Let user place pawns and walls */
    int p1WallIndex = 0; //place walls from "left to right" (really index 0 to 9)
    int p2WallIndex = 0;
    Pawn ctrlPwn = p1pawn; //player 1 always goes first
    while (determineWin(playerturn, ctrlPwn)) {
      drawBoard(gamePieces);
      if (playerturn == 1) {
        System.out.println("Turn: Player 1");
        if (turn(s, gamePieces, p1pawn, play1Walls, p1WallIndex)) {
          ++p1WallIndex;
          s.nextLine();
        }
        if (determineWin(playerturn, p1pawn) == 1) {
          break;
        }
        ++playerturn;
      } else if (playerturn == 2) {
        System.out.println("Turn: Player 2");
        if (turn(s, gamePieces, p2pawn, play2Walls, p2WallIndex)) {
          ++p2WallIndex;
          s.nextLine();
        }
        if (determineWin(playerturn, p2pawn) == 2) {
          break;
        }
        ++playerturn;
      } else if (playerturn == 3) {
        ++playerturn;
      } else {
        playerturn = 1;
      }
    }
    s.close(); //close scanner
    drawBoard(gamePieces);
    System.out.printf("Winner is %d won", playerturn);
  }
  /*
   * drawBoard() - draw the gamePieces
   */
  public static void drawBoard(GamePieces[][] gamePieces) {
    char[][] ascii = new char[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
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
  public static IsWall.isWall getInputWallorPawn(Scanner s) {
    String choice = s.nextLine();
    if ("wall".equalsIgnoreCase(choice)) {
      return IsWall.isWall.WALLIS;
    }
    if ("pawn".equalsIgnoreCase(choice)) {
      return IsWall.isWall.WALLISNT;
    }
    return IsWall.isWall.WALLISNT;
  }

  /*
   * updateBoard() - 'add' piece to gamePieces at a location
   */
  public static void updateBoard(GamePieces[][] gamePieces, GamePieces piece) {
    gamePieces[piece.getX()][piece.getY()] = piece;
  }

  /*
   * removeOldPiece() - sets old piece to null
   */
  public static void removeOldPiece(GamePieces[][] gamePieces, GamePieces piece) {
    gamePieces[piece.getX()][piece.getY()] = null;
  }

  /*
   * tailUpdate() - places second part of wall
   */
  public static void tailUpdate(GamePieces[][] gamePieces, Wall piece) {
    Wall temp = new Wall(piece.getX2(), piece.getY2());
    gamePieces[piece.getX2()][piece.getY2()] = temp;
    System.out.println(piece.getX2());
  }

  /*
   * Turn() - takes user commands to set pawn and wall locations
   */
  private static boolean turn(Scanner s, GamePieces[][] gamePieces,
                              Pawn pawn, Wall[] playerWalls, int wallIndex) {
    IsWall.isWall wallorNot = getInputWallorPawn(s);
    if (wallorNot == IsWall.isWall.WALLISNT) {
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
   * inputPlayerCount() - get number of players
   */
  private static int inputPlayerCount() {
    System.out.println("Welcome to the Quoridor!");
    Scanner s = new Scanner(System.in);
    while (true) {
      System.out.println("\nEnter the number of players (2 or 4): ");
      String input = s.next();
      //ensure input is an integer
      if ("2".equals(input)) {
        return 2;
      } else if ("4".equals(input)) {
        return 4;
      } else {
        System.out.println("Invalid number of players. Please try again.");
      }
    }
  }

  /*
   * determineWin() - check indices to check if a player has won
   */
  public static int determineWin(int playerTurn, Pawn p) {
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
