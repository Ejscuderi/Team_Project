package teamproject.model.physics

class PhysicsVector(var x: Double, var y: Double, var z: Double = 0.0) {

  def distance2d(other: PhysicsVector): Double = {
    Math.sqrt(Math.pow(x - other.x, 2.0) + Math.pow(y - other.y, 2.0))
  }

  def normal2d(): PhysicsVector = {
    if (x == 0 && y == 0) {
      new PhysicsVector(0, 0)
    } else {
      val magnitude = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0))
      new PhysicsVector(x / magnitude, y / magnitude, z)
    }
  }

  def normal2dVelocity(): PhysicsVector = {
    // calculates x and y components of velocity such that velocity = 25
    if (x == 0 && y == 0) {
      new PhysicsVector(0, 0)
    } else {
      val magnitude = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0))
      new PhysicsVector(5 * x / magnitude, 5 * y / magnitude, 0)
    }
  }

  override def toString: String = {
    "(" + x + ", " + y + ", " + z + ")"
  }

}
