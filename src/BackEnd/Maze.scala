package BackEnd

/**
  * @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/18/2019>
  */

class Maze(val numRows: Int, val numCols: Int) {
  /**
    * @desc <Two-dimensional grid that players will walk on during game play>
    */
  var maze: Array[Array[Cell]] = Array.ofDim[Cell](numRows,numCols)
}
