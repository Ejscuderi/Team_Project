package towers.model.game_objects

import towers.model.physics.PhysicsVector

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

  def collide(enemyPlayer: Player): Unit = {
    // caroline
    if (enemyPlayer.velocity.x > this.velocity.x) {
      this.velocity.x += enemyPlayer.velocity.x
      enemyPlayer.velocity.x = 0
    }
    else {
      enemyPlayer.velocity.x += this.velocity.x
      this.velocity.x = 0
    }
    if (enemyPlayer.velocity.y > this.velocity.y) {
      this.velocity.y += enemyPlayer.velocity.y
      enemyPlayer.velocity.y = 0
    }
    else {
      enemyPlayer.velocity.y += this.velocity.y
      this.velocity.y = 0
    }
  }

}
