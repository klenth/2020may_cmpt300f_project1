package scala_code

import scala.io.Source

object Words {
  private val WORDS_FILE = "words"

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile(WORDS_FILE)
    source.getLines()
      .filter(_.length() > 16)
      .toList
      .sorted((word1: String, word2: String) => word1.length - word2.length)
      .map(word => word.length + ": " + word)
      .foreach(println(_))
  }
}
