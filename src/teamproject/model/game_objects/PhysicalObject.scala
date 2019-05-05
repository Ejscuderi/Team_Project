package teamproject.model.game_objects

import teamproject.model.physics.PhysicsVector

class PhysicalObject(var location: PhysicsVector, var velocity: PhysicsVector) extends GameObject {

  def onGround(): Unit = {}
  def collide(): Unit = {}


  override def toString = s"PhysicalObject($location, $velocity)"
}
