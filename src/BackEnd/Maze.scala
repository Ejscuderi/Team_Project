package BackEnd

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import java.awt.{GridLayout, Image}
import java.awt.image.BufferedImage
import javax.swing.{ImageIcon, JFrame, JLabel, JPanel}

import java.awt.Toolkit

/**
  * @author <Caroline Hart>
  * @group <Alyssa Shellman, Elijah Scuderi, Caroline Hart>
  * @version <2/18/2019>
  */

class Maze(val numRows: Int, val numCols: Int) {
  /**
    * @note <Two-dimensional grid that players will walk on during game play>
    */

  val background: Image = Toolkit.getDefaultToolkit.createImage("Resources/Maze/Background.png")
    //new file("Resources/Maze/Background.png"))
  var maze: Array[Array[Cell]] = Array.ofDim[Cell](numRows,numCols)
  for (row <- 0 until numRows) {
    for (col <- 0 until numCols) {
      maze(row)(col) = new Cell(background, false, Array(row, col))
    }
  }

}
