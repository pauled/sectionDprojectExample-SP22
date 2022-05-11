

object runWebScraping {
  def main(args: Array[String]): Unit = {
    var page:ComicPage=new ComicPage("comicPage.html")
    page.addPennyArcade()
    page.writePage()
  }
}
