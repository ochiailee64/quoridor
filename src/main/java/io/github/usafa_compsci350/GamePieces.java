package io.github.usafa_compsci350;

public class GamePieces {
  protected int x1;
  protected int y1;

  public GamePieces(int x, int y) {
    this.x1 = x;
    this.y1 = y;
  }

  public int getX() {
    return x1;
  }

  public int getY() {
    return y1;
  }

  public void movePiece(int x, int y) {
    this.x1 = x;
    this.y1 = y;
  }
}
