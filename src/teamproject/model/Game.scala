package towers.model

import play.api.libs.json.{JsValue, Json}
import towers.model.game_objects._
import towers.model.physics.{Physics, PhysicsVector, World}


class Game {

  val world: World = new World(10)

  //var towers: List[DodgeBallTower] = List()
  var walls: List[Wall] = List()
  var projectiles: List[PhysicalObject] = List()

  //var baseHealth = 10

  var level: Level = new Level()

  var players: Map[String, Player] = Map() // Maps player name to Player
  val playerSize: Double = 0.3

  var lastUpdateTime: Long = System.nanoTime()


  def loadLevel(newLevel: Level): Unit = {
    world.boundaries = List()
    level = newLevel

    projectiles.foreach(po => po.destroy())
    //towers = List()
    walls = List()
    projectiles = List()

    blockTile(0, 0, level.gridWidth, level.gridHeight)

    //level.towerLocations.foreach(tower => placeTower(tower.x, tower.y))
    level.wallLocations.foreach(wall => placeWall(wall.x, wall.y))
    players.values.foreach(player => player.location = startingVector())

    //baseHealth = level.maxBaseHealth
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


  def addProjectile(projectile: PhysicalObject): Unit = {
    projectiles = projectile :: projectiles
    world.objects = projectile :: world.objects
  }


  def startingVector(): PhysicsVector = {
    new PhysicsVector(level.startingLocation.x + 0.5, level.startingLocation.y + 0.5)
  }



  def update(): Unit = {
    val time: Long = System.nanoTime()
    val dt = (time - this.lastUpdateTime) / 1000000000.0
    Physics.updateWorld(this.world, dt)
    checkForPlayerHits()
    //checkForBaseDamage()
    projectiles = projectiles.filter(po => !po.destroyed)
    this.lastUpdateTime = time
  }

  def gameState(): String = {
    val gameState: Map[String, JsValue] = Map(
      "gridSize" -> Json.toJson(Map("x" -> level.gridWidth, "y" -> level.gridHeight)),
      "start" -> Json.toJson(Map("x" -> level.startingLocation.x, "y" -> level.startingLocation.y)),
      //"base" -> Json.toJson(Map("x" -> level.base.x, "y" -> level.base.y)),
      //"maxBaseHealth" -> Json.toJson(level.maxBaseHealth),
      "walls" -> Json.toJson(this.walls.map({ w => Json.toJson(Map("x" -> w.x, "y" -> w.y)) })),
      "players" -> Json.toJson(this.players.map({ case (k, v) => Json.toJson(Map(
        "x" -> Json.toJson(v.location.x),
        "y" -> Json.toJson(v.location.y),
        "v_x" -> Json.toJson(v.velocity.x),
        "v_y" -> Json.toJson(v.velocity.y),
        "id" -> Json.toJson(k))) })),
      "projectiles" -> Json.toJson(this.projectiles.map({ po => Json.toJson(Map("x" -> po.location.x, "y" -> po.location.y)) }))
    )

    Json.stringify(Json.toJson(gameState))
  }


  def checkForPlayerHits(): Unit = {
    // TODO: Objective 3
  }


}
