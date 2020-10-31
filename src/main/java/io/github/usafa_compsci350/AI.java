package io.github.usafa_compsci350;

import java.util.Random;

public class AI {
    private static java.util.Random rand
            = new Random(System.currentTimeMillis());
    private int wall;

    private int previous;

    public AI() {
        this.wall = 9;
        this.previous = 0;
    }

    public boolean getAIMove(Pawn P, GamePieces[][] gamePieces, Wall[] playerWalls) {
        int mov = (int) (rand.nextDouble() + .5);
        if (mov == 1 & wall != -1) {
            AIPlaceWall(playerWalls, gamePieces);
            return true;
        } else {
            AIPlacePawn(P, gamePieces);
            return false;
        }
    }

    private void AIPlacePawn(Pawn p, GamePieces[][] gamePieces) {

        int direction = (int) ((rand.nextDouble() * 4) + 1);

        while (previous == direction) {
            direction = (int) ((rand.nextDouble() * 4) + 1);
        }

        if (direction == 1) {
            p.setX(p.getX() - 2);
            if (p.getX() < 1)
                p.setX(p.getX() + 2);
            AIPlacePawn(p, gamePieces);
        }

        if (direction == 2) {
            p.setX(p.getX() + 2);
            if (p.getX() > 17) {
                p.setX(p.getX() - 2);
                AIPlacePawn(p, gamePieces);
            }

        }

        if (direction == 3) {
            p.setY(p.getY() - 2);
            if (p.getY() < 1) {
                p.setY(p.getY() + 2);
                AIPlacePawn(p, gamePieces);
            }
        }

        if (direction == 4) {
            p.setY(p.getY() + 2);
            if (p.getY() > 16) {
                p.setY(p.getY() - 2);
                AIPlacePawn(p, gamePieces);
            }
        }

        if (!isValidPawn(p, gamePieces, direction))
            AIPlacePawn(p, gamePieces);
    }

    private void AIPlaceWall(Wall[] playerWalls, GamePieces[][] gamePieces) {
        int randomNum = 3 + (int) (rand.nextDouble() * ((15 - 3) + 1));
        if (randomNum % 2 != 0)
            AIPlaceWall(playerWalls, gamePieces);


        int randomNumY = 3 + (int) (rand.nextDouble() * ((15 - 3) + 1));
        if (randomNumY % 2 != 1)
            AIPlaceWall(playerWalls, gamePieces);

        int oldX = playerWalls[wall].getX();
        int oldY = playerWalls[wall].getY();
        int oldX2 = playerWalls[wall].getX2();
        int oldY2 = playerWalls[wall].getY2();

        playerWalls[wall].setX(randomNum);
        playerWalls[wall].setY(randomNumY);


        int randomDir = 1 + (int) (rand.nextDouble() * ((4 - 1) + 1));

        if (randomDir == 1) {
            playerWalls[wall].setX2(playerWalls[wall].getX() + 2);
            playerWalls[wall].setY2(playerWalls[wall].getY());
        }

        if (randomDir == 2) {
            playerWalls[wall].setX2(playerWalls[wall].getX() - 2);
            playerWalls[wall].setY2(playerWalls[wall].getY());
        }

        if (randomDir == 3) {
            playerWalls[wall].setY2(playerWalls[wall].getY() + 2);
            playerWalls[wall].setX2(playerWalls[wall].getX());
        }

        if (randomDir == 4) {
            playerWalls[wall].setY2(playerWalls[wall].getY() - 2);
            playerWalls[wall].setX2(playerWalls[wall].getX());
        }

        if (!isValidMove(gamePieces, playerWalls[wall])) {
            playerWalls[wall].setX(oldX);
            playerWalls[wall].setY(oldY);
            playerWalls[wall].setY2(oldY2);
            playerWalls[wall].setX2(oldX2);
            AIPlaceWall(playerWalls, gamePieces);
        }

        wall--;

    }

    private boolean isValidMove(GamePieces[][] gamePieces, Wall wallToPlace) {
        if (gamePieces[wallToPlace.getX()][wallToPlace.getY()] == null) {
            return gamePieces[wallToPlace.getX2()][wallToPlace.getY2()] == null;
        }
        return false;

    }

    private boolean isValidPawn(Pawn p, GamePieces[][] gamePieces, int direction) {
        if (gamePieces[p.getX()][p.getY()] == null) {
            if (direction == 1) {
                if (gamePieces[p.getX() + 1][p.getY()] == null)
                    return true;
            }

            if (direction == 2) {
                if (gamePieces[p.getX() - 1][p.getY()] == null)
                    return true;
            }

            if (direction == 3) {
                if (gamePieces[p.getX()][p.getY() + 1] == null)
                    return true;
            }

            if (direction == 4) {
                if (gamePieces[p.getX()][p.getY() - 1] == null)
                    return true;
            }

            return false;

        } else
            return false;

    }
}
