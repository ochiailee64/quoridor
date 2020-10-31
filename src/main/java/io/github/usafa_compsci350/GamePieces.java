package io.github.usafa_compsci350;

public class GamePieces {
  protected int x1;
  protected int y1;

  public GamePieces(int x, int y) {
    this.x1 = x;
    this.y1 = y;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public void setY1(int y1) {
    this.y1 = y1;
  }

  public void setX1(int x1) {
    this.x1 = x1;
  }

  public void movePiece(int x, int y) {
    this.x1 = x;
    this.y1 = y;
  }
}
