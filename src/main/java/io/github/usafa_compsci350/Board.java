package io.github.usafa_compsci350;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;


public class Board {
  public static final int SIZE = 19;

  public static void main(String[] args) {
    Board board = new Board();
    DrawingPanel panel = new DrawingPanel(450, 450);
    Graphics g = panel.getGraphics();
    g.setColor(Color.CYAN);
    board.draw(g);

    board.play();
  }

  public void draw(Graphics g){
    for (int i = 0; i < 18; i++) {
      for (int j = 0; j < 18; j++) {
        g.draw3DRect(i * 25, j * 25, 25, 25, (i%2 == 0));
      }
    }
  }



  public void play() {
    int playerturn = 1;
    GamePieces[][] gamePieces = new GamePieces[SIZE][SIZE];

    Scanner s = null;
    try {
      s = new Scanner(System.in);

      Wall[] play1Walls = new Wall[10];
      Wall[] play2Walls = new Wall[10];

      int loc = 0;
      for (int i = 0; i < 10; i++) {
        play1Walls[i] = new Wall(0, loc);
        play2Walls[i] = new Wall(18, loc);

        gamePieces[play1Walls[i].getX1()][play1Walls[i].getY1()]
            = play1Walls[i];
        gamePieces[play2Walls[i].getX1()][play2Walls[i].getY1()]
            = play2Walls[i];

        loc += 2;
      }

      boolean isAi = inputPlayerCount(s) == 1;
      AI andrew = new AI();

      Pawn p1pawn = new Pawn(1, 9);
      Pawn p2pawn = new Pawn(17, 9);

      gamePieces[p1pawn.getX1()][p1pawn.getY1()] = p1pawn;
      gamePieces[p2pawn.getX1()][p2pawn.getY1()] = p2pawn;


      int p1WallIndex = 0;
      int p2WallIndex = 0;
      if (isAi) {
        p2WallIndex = 9;
      }

      s.nextLine();

      while (true) {
        drawBoard(gamePieces);
        if (playerturn == 1) {
          System.out.println("Turn: Player 1");
          if (turn(s, gamePieces, p1pawn, play1Walls, p1WallIndex)) {
            ++p1WallIndex;
            s.nextLine();
          }
          if (determineWin(playerturn, p1pawn) == 1) {
            System.out.printf("Winner is %d won", playerturn);
            break;
          }
          ++playerturn;
        } else if (playerturn == 2) {
          System.out.println("Turn: Player 2");
          if (isAi) {
            Pawn old = new Pawn(p2pawn.getX1(), p2pawn.getY1());
            if (andrew.getAImove(p2pawn, gamePieces, play2Walls)) {
              tailUpdate(gamePieces, play2Walls[p2WallIndex]);
              updateBoard(gamePieces, play2Walls[p2WallIndex]);
              p2WallIndex--;
            } else {
              updateBoard(gamePieces, p2pawn);
              removeOldPiece(gamePieces, old);
            }
          } else {
            if (turn(s, gamePieces, p2pawn, play2Walls, p2WallIndex)) {
              ++p2WallIndex;
              s.nextLine();
            }
          }
          if (determineWin(playerturn, p2pawn) == 2) {
            System.out.printf("Winner is %d won", playerturn);
            break;
          }
          ++playerturn;
        } else if (playerturn == 3) {
          ++playerturn;
        } else {
          playerturn = 1;
        }
      }
    } finally {
      if (s != null) {
        s.close();
      }
    }
  }


  public void drawBoard(GamePieces[][] gamePieces) {
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

  public static IsWall.IsWaLl getInputWallorPawn(Scanner s) {
    String choice = s.nextLine();
    if ("wall".equalsIgnoreCase(choice)) {
      return IsWall.IsWaLl.WALLIS;
    }
    if ("pawn".equalsIgnoreCase(choice)) {
      return IsWall.IsWaLl.WALLISNT;
    }
    return IsWall.IsWaLl.WALLISNT;
  }

  public void updateBoard(GamePieces[][] gamePieces, GamePieces piece) {
    gamePieces[piece.getX1()][piece.getY1()] = piece;
  }

  public void removeOldPiece(GamePieces[][] gamePieces,
                                    GamePieces piece) {
    gamePieces[piece.getX1()][piece.getY1()] = null;
  }


  public void tailUpdate(GamePieces[][] gamePieces, Wall piece) {
    Wall temp = new Wall(piece.getX2(), piece.getY2());
    gamePieces[piece.getX2()][piece.getY2()] = temp;
    System.out.println(piece.getX2());
  }

  private boolean turn(Scanner s, GamePieces[][] gamePieces,
                              Pawn pawn, Wall[] playerWalls, int wallIndex) {
    IsWall.IsWaLl wallorNot = getInputWallorPawn(s);
    if (wallorNot == IsWall.IsWaLl.WALLISNT) {
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

  private int inputPlayerCount(Scanner s) {
    System.out.println("Welcome to the Quoridor!");
    while (true) {
      System.out.println("\nEnter the number of players (1 or 2): ");
      String input = s.next();

      if ("1".equals(input)) {
        return 1;
      } else if ("2".equals(input)) {
        return 2;
      } else {
        System.out.println("Invalid number of players. Please try again.");
      }
    }
  }

  public static int determineWin(int playerturn, Pawn p) {
    if (playerturn == 1) {
      if (p.getX1() >= 17) {
        return 1;
      }
    } else if (playerturn == 2) {
      if (p.getX1() <= 1) {
        return 2;
      }
    } else {
      return -1;
    }
    return -1;
  }
}
