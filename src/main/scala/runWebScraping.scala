import java.io._
import scala.io.Source

object runWebScraping {
  def main(args: Array[String]): Unit = {
    val pw = new PrintWriter(new File("output/comicPage.html" ))
    pw.write("<html>\n<head>\n<title>Paul's comic page</title>\n</head>\n")
    pw.write("<body>\nI am one SEXY! body\n</body>\n</html>")
    pw.close


    val html = Source.fromURL("https://www.penny-arcade.com/comic/2022/05/06/utmost-confidence")
    for (line <- html.getLines()){
      if (line.contains("comic-panel")) {
        println(line)
      }
    }
  }
}
