package teamproject.model.game_objects

import teamproject.model.physics.PhysicsVector

class Player(inputLocation: PhysicsVector,
             inputVelocity: PhysicsVector) extends PhysicalObject(inputLocation, inputVelocity) {

  val speed: Double = 4.0

  def move(direction: PhysicsVector){
    val normalDirection = direction.normal2d()
    this.velocity = new PhysicsVector(normalDirection.x * speed, normalDirection.y * speed)
  }

  def stop(): Unit ={
    this.velocity = new PhysicsVector(0, 0)
  }

  def playerHit(otherPlayer: Player): Unit = {
    if (this.velocity.x != otherPlayer.velocity.x && this.velocity.x > otherPlayer.velocity.x) {
      // if x velocities are not equal and x velocity of this is greater than x velocity of otherPlayer
      otherPlayer.velocity.x += 0.90 * this.velocity.x
    }else if(this.velocity.x != otherPlayer.velocity.x) {
      // if x velocities are not equal
      this.velocity.x += 0.90 * otherPlayer.velocity.x
    }
    if (this.velocity.y != otherPlayer.velocity.y && this.velocity.y > otherPlayer.velocity.x) {
      // if y velocities are not equal and x velocity of this is greater than x velocity of otherPlayer
      otherPlayer.velocity.y += 0.90 * this.velocity.y
    }else if(this.velocity.y != otherPlayer.velocity.y) {
      // if y velocities are not equal
      this.velocity.y += 0.90 * otherPlayer.velocity.y

    }
  }

}
