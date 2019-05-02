package towers.model

import akka.actor.{Actor, ActorRef}
import towers.model.physics.PhysicsVector


class GameActor extends Actor {

  var players: Map[String, ActorRef] = Map()
  var towers: List[ActorRef] = List()

  val game: Game = new Game()
  var levelNumber = 0
  loadLevel(levelNumber)

  def loadLevel(levelNumber: Int): Unit ={
    val level = Level(levelNumber)
    game.loadLevel(level)
  }

  override def receive: Receive = {
    case message: AddPlayer => game.addPlayer(message.username)
    case message: RemovePlayer => game.removePlayer(message.username)
    case message: MovePlayer => game.players(message.username).move(new PhysicsVector(message.x, message.y))
    case message: StopPlayer => game.players(message.username).stop()

    case UpdateGame =>
      game.update()
      //if (game.baseHealth <= 0) {
        //game.baseHealth = 2
        levelNumber = (levelNumber + 1) % 3
        loadLevel(levelNumber)
      //}
    case SendGameState => sender() ! GameState(game.gameState())
  }
}
