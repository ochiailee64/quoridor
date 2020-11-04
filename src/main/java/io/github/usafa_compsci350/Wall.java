package io.github.usafa_compsci350;

public class Wall extends GamePiece {
  /* Fields */
  private int x2;
  private int y2;

  /*
   * Constructor w/ super call to GamePiece
   */
  public Wall(int x1, int y1) {
    super(x1, y1);
    //place both ends of wall in the
    //same place initially before player interaction
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
}
