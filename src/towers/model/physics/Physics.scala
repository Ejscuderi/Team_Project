package towers.model.physics

import towers.model.game_objects.{Boundary, PhysicalObject}

object Physics {

  val EPSILON: Double = 0.000000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  def computePotentialLocation(obj: PhysicalObject, dt: Double): PhysicsVector = {
    val newX = obj.location.x + dt * obj.velocity.x
    val newY = obj.location.y + dt * obj.velocity.y
    val newZ = 0.0.max(obj.location.z + dt * obj.velocity.z)
    if(newZ < EPSILON){
      obj.onGround()
    }
    new PhysicsVector(newX, newY, newZ)
  }

  def updateVelocity(obj: PhysicalObject, world: World, dt: Double): Unit = {
    val newZV = obj.velocity.z - world.gravity * dt
    if (obj.location.z < EPSILON && newZV < 0.0) {
      obj.velocity.z = 0.0
    } else {
      obj.velocity.z = newZV
    }
  }

  def slope(p1: PhysicsVector, p2: PhysicsVector): Double = {
    if(p2.x - p1.x == 0.0){
      100000000000.0
//      Double.PositiveInfinity
    }else {
      (p2.y - p1.y) / (p2.x - p1.x)
    }
  }

  def yIntercept(p1: PhysicsVector, m: Double): Double = {
    p1.y - m * p1.x
  }

  def detectCollision(obj: PhysicalObject, potentialLocation: PhysicsVector, boundary: Boundary): Boolean = {

    if(obj.location.x == potentialLocation.x && obj.location.y == potentialLocation.y){
      return false
    }
    // only in x/y direction
    val mObj = slope(obj.location, potentialLocation)
    val bObj = yIntercept(obj.location, mObj)

    val mBound = slope(boundary.start, boundary.end)
    val bBound = yIntercept(boundary.start, mBound)
    if (equalDoubles(mObj, mBound)) {
      return false
    }

    //    m1x + b1 = m2x + b2
    //    m1x - m2x = b2 - b1
    //    x(m1x - m2) = b2 - b1
    //    x = (b2 - b1) / (m1x - m2)

    val ix: Double = (bBound - bObj) / (mObj - mBound)
    val iy: Double = ix * mObj + bObj
    val iy_redundant: Double = ix * mBound + bBound

    val objLeft = obj.location.x.min(potentialLocation.x)
    val objRight = obj.location.x.max(potentialLocation.x)

    val objUp = obj.location.y.min(potentialLocation.y)
    val objDown = obj.location.y.max(potentialLocation.y)

    val bLeft = boundary.start.x.min(boundary.end.x)
    val bRight = boundary.start.x.max(boundary.end.x)

    val bUp = boundary.start.y.min(boundary.end.y)
    val bDown = boundary.start.y.max(boundary.end.y)

    ((ix >= objLeft-EPSILON && ix <= objRight+EPSILON) && (iy >= objUp-EPSILON && iy <= objDown+EPSILON)) && ((ix >= bLeft -EPSILON&& ix <= bRight+EPSILON) && (iy >= bUp-EPSILON && iy <= bDown+EPSILON))
  }



  def updateWorld(world: World, deltaTime: Double): Unit = {

    for (obj <- world.objects) {
      // update velocity
      updateVelocity(obj, world, deltaTime)

      // get potential location
      val potentialLocation = computePotentialLocation(obj, deltaTime)

      // check collisions
      var collisionDetected = false
      for (wall <- world.boundaries) {
        if (detectCollision(obj, potentialLocation, wall)) {
          collisionDetected = true
          obj.collide()
        }
      }

      obj.location.z = potentialLocation.z
      if (!collisionDetected) {
        obj.location.x = potentialLocation.x
        obj.location.y = potentialLocation.y
      }

    }

    world.objects = world.objects.filter((po: PhysicalObject) => !po.destroyed)
  }

  }
