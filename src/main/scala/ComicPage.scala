import java.io.{File, PrintWriter}
import scala.io.Source

class ComicPage(filename:String){
  var comics:List[String]=List()

  def addPennyArcade():Unit={
    val html = Source.fromURL("https://www.penny-arcade.com/comic/2022/05/06/utmost-confidence")
    var out:String=""
    for (line <- html.getLines()){
      if (line.contains("comic-panel") && line.contains("<img")) {
        var loc=line.indexOf("<img")
        var loc2=line.indexOf("</div>")
        var img=line.substring(loc,loc2)
        out+=img+"\n"
        println(img)
      }
    }
    this.comics=out :: this.comics
  }

  def writePage():Unit={
    val pw = new PrintWriter(new File("output/"+filename ))
    pw.write("<html>\n<head>\n<title>Paul's comic page</title>\n</head>\n")
    pw.write("<body>\n")
    for (comic <- comics){
      pw.write(comic+"\n")
    }
    pw.write("</body>\n</html>")
    pw.close
  }
}