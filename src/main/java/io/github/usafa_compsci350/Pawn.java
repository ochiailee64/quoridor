package io.github.usafa_compsci350;

public class Pawn extends GamePiece {
  /*
   * Class Constructor
   */
  public Pawn(int x, int y) {
    super(x, y);
  }

  /*
   * covers() - returns true if a pawn is at position x,y
   */
  public boolean covers(int x, int y) {
    if (this.getX1() == x && this.getY1() == y) {
      return true;
    }
    return false;
  }
}
