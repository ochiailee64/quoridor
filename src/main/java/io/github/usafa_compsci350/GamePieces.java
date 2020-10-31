package io.github.usafa_compsci350;

public class GamePieces {
  protected int xLocation;
  protected int yLocation;

  public GamePieces(int x, int y) {
    this.xLocation = x;
    this.yLocation = y;
  }

  public int getxLocation() {
    return xLocation;
  }

  public int getyLocation() {
    return yLocation;
  }

  public void setyLocation(int yLocation) {
    this.yLocation = yLocation;
  }

  public void setxLocation(int xLocation) {
    this.xLocation = xLocation;
  }

  public void movePiece(int x, int y) {
    this.xLocation = x;
    this.yLocation = y;
  }
}
