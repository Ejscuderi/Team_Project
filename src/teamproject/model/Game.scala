package teamproject.model

import play.api.libs.json.{JsValue, Json}
import teamproject.model.game_objects._
import teamproject.model.physics.{Physics, PhysicsVector, World}


class Game {

  val world: World = new World(10)

  var walls: List[Wall] = List()

  var level: Level = new Level()

  var players: Map[String, Player] = Map()
  val playerSize: Double = 0.3

  var lastUpdateTime: Long = System.nanoTime()


  def loadLevel(newLevel: Level): Unit = {
    world.boundaries = List()
    level = newLevel

    walls = List()

    blockTile(0, 0, level.gridWidth, level.gridHeight)

    level.wallLocations.foreach(wall => placeWall(wall.x, wall.y))
    players.values.foreach(player => player.location = startingVector())
  }


  def addPlayer(id: String): Unit = {
    val player = new Player(startingVector(), new PhysicsVector(0, 0))
    players += (id -> player)
    world.objects = player :: world.objects
  }


  def removePlayer(id: String): Unit = {
    players(id).destroy()
    players -= id
  }

  def blockTile(x: Int, y: Int, width: Int = 1, height: Int = 1): Unit = {
    val ul = new PhysicsVector(x, y)
    val ur = new PhysicsVector(x + width, y)
    val lr = new PhysicsVector(x + width, y + height)
    val ll = new PhysicsVector(x, y + height)

    world.boundaries ::= new Boundary(ul, ur)
    world.boundaries ::= new Boundary(ur, lr)
    world.boundaries ::= new Boundary(lr, ll)
    world.boundaries ::= new Boundary(ll, ul)
  }


  def placeWall(x: Int, y: Int): Unit = {
    blockTile(x, y)
    walls = new Wall(x, y) :: walls
  }


  def startingVector(): PhysicsVector = {
    new PhysicsVector(level.startingLocation.x + 0.5, level.startingLocation.y + 0.5)
  }



  def update(): Unit = {
    val time: Long = System.nanoTime()
    val dt = (time - this.lastUpdateTime) / 1000000000.0
    Physics.updateWorld(this.world, dt)
    checkIsPlayerAtBase()
    checkForPlayerHits()
    this.lastUpdateTime = time
  }

  def gameState(): String = {
    val gameState: Map[String, JsValue] = Map(
      "gridSize" -> Json.toJson(Map("x" -> level.gridWidth, "y" -> level.gridHeight)),
      "start" -> Json.toJson(Map("x" -> level.startingLocation.x, "y" -> level.startingLocation.y)),
      "base" -> Json.toJson(Map("x" -> level.base.x, "y" -> level.base.y)),
      "walls" -> Json.toJson(this.walls.map({ w => Json.toJson(Map("x" -> w.x, "y" -> w.y)) })),
      "players" -> Json.toJson(this.players.map({ case (k, v) => Json.toJson(Map(
        "x" -> Json.toJson(v.location.x),
        "y" -> Json.toJson(v.location.y),
        "v_x" -> Json.toJson(v.velocity.x),
        "v_y" -> Json.toJson(v.velocity.y),
        "id" -> Json.toJson(k))) }))
    )

    Json.stringify(Json.toJson(gameState))
  }

  def checkIsPlayerAtBase(): Unit = {
    // Whenever a player reaches the enemy base it will lose 1 point of health
    // and the player will be returned to the starting location of the level.
    // A player is determined to have reached the base if they are closer than
    // the size of the player from the center of the tile where the base is located.
    for ((k,v) <- this.players) { // Iterate through player map
      if (this.playerSize >= Math.sqrt(Math.pow(v.location.x - this.level.base.x - 0.5, 2) + Math.pow(v.location.y - this.level.base.y - 0.5, 2))) { // if playerSize is less than distance between player and base
      v.location.x = this.level.startingLocation.x + 0.5 // set player x location to start
      v.location.y = this.level.startingLocation.y + 0.5 // set player y location to start
      v.stop()
      }
    }
  }

  def checkForPlayerHits(): Unit = {
    // TODO:
    for ((k,v) <- this.players) {
      for ((key,value) <- this.players) {
        if (k != key && this.playerSize >= Math.sqrt(Math.pow(v.location.x - value.location.x, 2) + Math.pow(v.location.y - value.location.y, 2))) {
          v.playerHit(value)
        }
      }
    }
  }
}
