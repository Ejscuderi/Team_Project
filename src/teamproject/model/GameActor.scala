package teamproject.model

import akka.actor.{Actor, ActorRef}
import teamproject.model.physics.PhysicsVector


class GameActor extends Actor {

  var players: Map[String, ActorRef] = Map()

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
    case SendGameState => sender() ! GameState(game.gameState())
    case levelMessage: LoadLevel =>
      val level = Level(levelMessage.levelNumber)
      game.loadLevel(level)
  }
}
