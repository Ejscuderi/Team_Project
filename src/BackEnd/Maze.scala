package BackEnd

import scalafx.scene.image.Image
//import scalafx.
//import scala.swing._

/**
  * @author <Caroline Hart>
  * @group <Elijah Scuderi, Caroline Hart>
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

  def this() {
    this(15,30)
    val maze: Array[Array[Cell]] = Array.ofDim[Cell](numRows, numCols)
    for (row <- 0 until numRows) {
      for (col <- 0 until numCols) {
        if (row == 0 || row == numRows-1 || col == 0 || col == numCols) { // Checks if along border
          maze(row)(col) = new Cell(brick, true, Array(row, col))
        }
        else maze(row)(col) = new Cell(background, false, Array(row, col))
      }
    }
    for (row <- 4 until 17) {maze(row)(5) = new Cell(brick, true, Array(row, 5))}
    for (row <- 1 until 7) {maze(row)(7) = new Cell(brick, true, Array(row, 7))}
    for (row <- 14 until 20) {maze(row)(7) = new Cell(brick, true, Array(row, 7))}
    for (row <- 2 until 9) {maze(row)(9) = new Cell(brick, true, Array(row, 9))}
    for (row <- 12 until 19) {maze(row)(9) = new Cell(brick, true, Array(row, 9))}
    for (col <- 8 until 15) {maze(10)(col) = new Cell(brick, true, Array(10, col))}
    for (col <- 9 until 13) {maze(2)(col) = new Cell(brick, true, Array(2, col))}
    for (col <- 9 until 14) {maze(8)(col) = new Cell(brick, true, Array(8, col))}
    for (col <- 9 until 14) {maze(12)(col) = new Cell(brick, true, Array(12, col))}
    for (col <- 9 until 13) {maze(18)(col) = new Cell(brick, true, Array(18, col))}

    //maze()() = new Cell(brick, true, Array(, ))


  }
}
