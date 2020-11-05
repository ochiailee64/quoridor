package io.github.usafa_compsci350;

public abstract class GamePiece {
  private int x;
  private int y;

  public GamePiece(int x1, int y1) {
    this.x = x1;
    this.y = y1;
  }

  public int getX1() {
    return x;
  }

  public int getY1() {
    return y;
  }

  public void setX1(int x1) {
    this.x = x1;
  }

  public void setY1(int y1) {
    this.y = y1;
  }
}
