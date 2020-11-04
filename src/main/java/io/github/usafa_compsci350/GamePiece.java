package io.github.usafa_compsci350;

public class GamePiece {
  private int x1;
  private int y1;

  public GamePiece(int x1, int y1) {
    this.x1 = x1;
    this.y1 = y1;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public void setX1(int x1) {
    this.x1 = x1;
  }

  public void setY1(int y1) {
    this.y1 = y1;
  }

  /*
   * pickChar() - char to print based on class instance
   */
  protected char pickChar() {
    String objClassInstance = this.getClass().getName();
    if ("io.github.usafa_compsci350.Pawn".equalsIgnoreCase(objClassInstance)) {
      return '0';
    }
    else {
      return '8';
    }
  }
}
