


/**import java.awt.Insets

import BackEnd.Maze
//import controller.keys
import FrontEnd._
import javafx.geometry.Pos
import javafx.scene.image.ImageView
import javafx.scene.input.KeyEvent
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.image.Image
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Rectangle, Shape}
import scalafx.scene.{Group, Scene}

object GUI extends JFXApp {
  //var lastUpdateTime: Long = System.nanoTime()
  val mazeGame = new Maze()
  val gridPane = new GridPane()
  gridPane.setMinSize(400,300)
  gridPane.setAlignment(Pos.CENTER)
  val background = new Image("File:Resources/Maze/Background.png")
  val picBackground = new ImageView
  picBackground.setFitWidth(20)
  picBackground.setFitHeight(20)
  picBackground.setImage(background)
  val brick = new Image("File:Resources/Maze/Brick.png")
  val picBrick = new ImageView
  picBrick.setFitWidth(20)
  picBrick.setFitHeight(20)
  picBrick.setImage(background)
  for (i <- 0 to 29) {gridPane.add(picBackground, 0 , i)}
  for (j <- 0 to 29) {gridPane.add(picBackground, 14 , j)}
  for (k <- 0 to 14) {gridPane.add(picBackground, k , 0)}
  for (l <- 0 to 14) {gridPane.add(picBackground, l , 29)}
  val scene = new Scene()
  gridPane.setVisible(true)
} */
package FrontEnd

import java.awt.Color

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.input.KeyEvent
import BackEnd._
import scalafx.scene.control.Button
import scalafx.scene.image.Image
import scalafx.scene.layout.{Background, BackgroundFill, BackgroundImage, GridPane}

object GUI extends JFXApp {
  val play = new Play()

  val background = new Image("File:Resources/Maze/Background.png")
  val brick = new Image("File:Resources/Maze/Brick.png")
  val wallButton = new Button() {
    this.setBackground(new Background(BackgroundFill(Color.black)))
  }
  val floorButton = new Button() {
    this.setBackground((new Background((BackgroundFill(Color.white)))))
  }


  this.stage = new PrimaryStage {
    title = "CSE116 Game"
    scene = new Scene() {
      content = List(
        new GridPane {
          for (i <- 0 to 29) {
            add(wallButton, 0, i)
          }
          for (j <- 0 to 29) {
            add(wallButton, 14, j)
          }
          for (k <- 0 to 14) {
            add(wallButton, k, 0)
          }
          for (l <- 0 to 14) {
            add(wallButton, l, 29)
          }
        }
      )
    }
  }

}
