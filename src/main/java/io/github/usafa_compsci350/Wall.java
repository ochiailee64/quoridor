package io.github.usafa_compsci350;

import java.util.Scanner;

public class Wall extends GamePieces {
  /* Fields */
  public int x2;
  public int y2;

  /*
   * Constructor w/ super call to GamePieces
   */
  public Wall(int x1, int y1) {
    super(x1, y1);
    x2 = x1;
    y2 = y1;
  }

  /*
   * getX2() - getter function
   */
  public int getX2() {
    return x2;
  }

  /*
   * getY2() - getter function
   */
  public int getY2() {
    return y2;
  }

  /*
   * setX2() - set x2 field
   */
  public void setX2(int x2) {
    this.x2 = x2;
  }

  /*
   * setY2() - set y2 field
   */
  public void setY2(int y2) {
    this.y2 = y2;
  }

  /*
   * blockSecond() - put in the second half.
   */
  public void blockSecond(int x, int y) {
    x2 = x;
    y2 = y;
  }

  /*
   * newPosition() - set new position
   */
  public void newPosition(Scanner s) {
    int newX = 0;
    int newY = 0;
    while (true) {
      System.out.println("Enter new x");
      newX = s.nextInt();

      System.out.println("Enter new y");
      newY = s.nextInt();

      if (newX % 2 != 0 && newY % 2 != 0) {
        System.out.println("Not valid");
      } else {
        break;
      }
    }

    x1 = newX;
    y1 = newY;

    System.out.println("Please enter up, down, left, or right: ");
    Scanner sx = new Scanner(System.in);
    String direction = sx.nextLine();
    if ("up".equalsIgnoreCase(direction)) {
      x2 = newX - 2;
      y2 = y1;
    } else if ("down".equalsIgnoreCase(direction)) {
      x2 = newX + 2;
      y2 = y1;
    } else if ("left".equalsIgnoreCase(direction)) {
      y2 = newY - 2;
      x2 = newX;
    } else {
      y2 = newY + 2;
      x2 = newX;
    }
  }
}
