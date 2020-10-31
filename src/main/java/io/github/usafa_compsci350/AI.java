package io.github.usafa_compsci350;

import java.util.Random;

public class AI {
  private static Random rand
      = new Random(System.currentTimeMillis());
  private int wall;

  private int previous;

  public AI() {
    this.wall = 9;
    this.previous = 0;
  }

  public boolean getAImove(Pawn p, GamePieces[][] gamePieces,
                           Wall[] playerWalls) {
    int mov = (int) (rand.nextDouble() + .5);
    if (mov == 1 & wall != -1) {
      aiPlaceWall(playerWalls, gamePieces);
      return true;
    } else {
      aiPlacePawn(p, gamePieces);
      return false;
    }
  }

  private void aiPlacePawn(Pawn p, GamePieces[][] gamePieces) {

    int direction = (int) (rand.nextDouble() * 4) + 1;

    while (previous == direction) {
      direction = (int) (rand.nextDouble() * 4) + 1;
    }

    if (direction == 1) {
      p.setX1(p.getX1() - 2);
      if (p.getX1() < 1) {
        p.setX1(p.getX1() + 2);
        aiPlacePawn(p, gamePieces);
      }
    }

    if (direction == 2) {
      p.setX1(p.getX1() + 2);
      if (p.getX1() > 17) {
        p.setX1(p.getX1() - 2);
        aiPlacePawn(p, gamePieces);
      }

    }

    if (direction == 3) {
      p.setY1(p.getY1() - 2);
      if (p.getY1() < 1) {
        p.setY1(p.getY1() + 2);
        aiPlacePawn(p, gamePieces);
      }
    }

    if (direction == 4) {
      p.setY1(p.getY1() + 2);
      if (p.getY1() > 16) {
        p.setY1(p.getY1() - 2);
        aiPlacePawn(p, gamePieces);
      }
    }

    if (!isValidPawn(p, gamePieces, direction)) {
      aiPlacePawn(p, gamePieces);
    }
  }

  private void aiPlaceWall(Wall[] playerWalls, GamePieces[][] gamePieces) {
    int randomNum = 3 + (int) (rand.nextDouble() * ((15 - 3) + 1));
    if (randomNum % 2 != 0) {
      aiPlaceWall(playerWalls, gamePieces);
    }


    int randomNumY = 3 + (int) (rand.nextDouble() * ((15 - 3) + 1));
    if (randomNumY % 2 != 1) {
      aiPlaceWall(playerWalls, gamePieces);
    }

    int oldX = playerWalls[wall].getX1();
    int oldY = playerWalls[wall].getY1();
    int oldX2 = playerWalls[wall].getX2();
    int oldY2 = playerWalls[wall].getY2();

    playerWalls[wall].setX1(randomNum);
    playerWalls[wall].setY1(randomNumY);


    int randomDir = 1 + (int) (rand.nextDouble() * ((4 - 1) + 1));

    if (randomDir == 1) {
      playerWalls[wall].setX2(playerWalls[wall].getX1() + 2);
      playerWalls[wall].setY2(playerWalls[wall].getY1());
    }

    if (randomDir == 2) {
      playerWalls[wall].setX2(playerWalls[wall].getX1() - 2);
      playerWalls[wall].setY2(playerWalls[wall].getY1());
    }

    if (randomDir == 3) {
      playerWalls[wall].setY2(playerWalls[wall].getY1() + 2);
      playerWalls[wall].setX2(playerWalls[wall].getX1());
    }

    if (randomDir == 4) {
      playerWalls[wall].setY2(playerWalls[wall].getY1() - 2);
      playerWalls[wall].setX2(playerWalls[wall].getX1());
    }

    if (!isValidMove(gamePieces, playerWalls[wall])) {
      playerWalls[wall].setX1(oldX);
      playerWalls[wall].setY1(oldY);
      playerWalls[wall].setY2(oldY2);
      playerWalls[wall].setX2(oldX2);
      aiPlaceWall(playerWalls, gamePieces);
    }

    wall--;

  }

  private boolean isValidMove(GamePieces[][] gamePieces, Wall wallToPlace) {
    if (gamePieces[wallToPlace.getX1()]
        [wallToPlace.getY1()] == null) {
      return gamePieces[wallToPlace.getX2()][wallToPlace.getY2()] == null;
    }
    return false;

  }

  private boolean isValidPawn(Pawn p, GamePieces[][] gamePieces,
                              int direction) {
    if (gamePieces[p.getX1()][p.getY1()] == null) {
      if (direction == 1) {
        if (gamePieces[p.getX1() + 1][p.getY1()] == null) {
          return true;
        }
      }

      if (direction == 2) {
        if (gamePieces[p.getX1() - 1][p.getY1()] == null) {
          return true;
        }
      }

      if (direction == 3) {
        if (gamePieces[p.getX1()][p.getY1() + 1] == null) {
          return true;
        }
      }

      if (direction == 4) {
        if (gamePieces[p.getX1()][p.getY1() - 1] == null) {
          return true;
        }
      }

      return false;

    } else {
      return false;
    }

  }
}
