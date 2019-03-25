package BackEnd

import scalafx.scene.image.Image
//import scalafx.
//import scala.swing._

/**
  * @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/18/2019>
  */

class Maze(var numRows: Int, var numCols: Int) {
  /**
    * @note <Two-dimensional grid that players will walk on during game play>
    */
  val background: Image = new Image("Resources/Maze/Background.png")
  val brick: Image = new Image("Resources/Maze/Brick.png")
  val weaponItem: Image = new Image("Resources/Maze/Weapons.png")

  def makeEmptyMaze(): Unit = {
    val maze: Array[Array[Cell]] = Array.ofDim[Cell](numRows, numCols)
    for (row <- 0 until numRows) {
      for (col <- 0 until numCols) {
        maze(row)(col) = new Cell(background, false, Array(row, col))
      }
    }
  }

  def makeMaze1(): Unit = {
    this.numRows = 15
    this.numCols = 30
    val maze: Array[Array[Cell]] = Array.ofDim[Cell](numRows, numCols)
    for (row <- 0 until numRows) {
      for (col <- 0 until numCols) {
        if (row == 0 || row == numRows-1 || col == 0 || col == numCols) { // Checks if along border
          maze(row)(col) = new Cell(brick, true, Array(row, col))
        }
        else maze(row)(col) = new Cell(background, false, Array(row, col))
      }
    }
    maze(7)(8) = new Cell(brick, true, Array(7, 8))
  }
}
