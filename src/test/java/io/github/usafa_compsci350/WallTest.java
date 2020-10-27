package io.github.usafa_compsci350;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WallTest {


  @Test
  void getXWall() {
    Wall w = new Wall(5, 5);
    assertEquals(5, w.getX());
  }

  @Test
  void getYWall() {
    Wall w = new Wall(5, 5);
    assertEquals(5, w.getY());
  }

  @Test
  void getY2() {
    Wall w = new Wall(5, 5, 6, 6);
    //not initialized until later
    assertEquals(0, w.getY2());
  }

  @Test
  void getX2() {
    Wall w = new Wall(5, 5, 6, 6);
    //not initialized until later
    assertEquals(0, w.getX2());
  }
}
