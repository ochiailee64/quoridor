package io.github.usafa_compsci350;

public class GamePieces {
  protected int x1;
  protected int y1;

  public GamePieces(int x1, int y1) {
    this.x1 = x1;
    this.y1 = y1;
  }

  public int getX() {
    return x1;
  }

  public int getY() {
    return y1;
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
