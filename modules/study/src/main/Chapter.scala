package lila.study

import chess.Pos
import org.joda.time.DateTime

case class Chapter(
    gameId: Option[String],
    steps: List[Step],
    shapes: List[Chapter.Shape],
    ownerPath: Path,
    createdAt: DateTime) {

}

object Chapter {

  type ID = String
  type Brush = String

  sealed trait Shape
  object Shape {
    case class Circle(brush: Brush, pos: Pos) extends Shape
    case class Arrow(brush: Brush, orig: Pos, dest: Pos) extends Shape
  }

  val idSize = 4

  def makeId = scala.util.Random.alphanumeric take idSize mkString

  def make(gameId: Option[String]) = Chapter(
    gameId = gameId,
    steps = Nil,
    shapes = Nil,
    ownerPath = Path.init,
    createdAt = DateTime.now)
}
