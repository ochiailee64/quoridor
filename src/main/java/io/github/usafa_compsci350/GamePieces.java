package io.github.usafa_compsci350;

public class GamePieces {
  public int x;
  public int y;

  public GamePieces(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void movePiece(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
