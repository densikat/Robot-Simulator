package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

  @Test
  public void validaateIncorrectDirection() {
    Direction direction = new Direction();
    assertFalse(direction.validateDirection("NORTHE"));
  }

}
