import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.Scanner; 


public class jaegeun {

private static void getName(Element root){
    Element eTitle1;
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("ÀÌ¸§");
      int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
    eTitle1 = (Element) nTitles.item(i);
    Text tTitle1 = (Text) eTitle1.getFirstChild( );
          String strTitle1 = tTitle1.getData( );
          if(message.equals(strTitle1)){
          System.out.println("Á¦¸ñ [" + i + "]: " + strTitle1);
          System.out.println("»óÇ° Á¤º¸: " + eTitle1.getAttribute("id"));
          Text tTitle2 = (Text) nextSibling(root, eTitle1).getFirstChild();
          System.out.println(nextSibling(root, eTitle1).getNodeName() + " " + tTitle2.getData());
    }
  }
}

private static Element nextSibling(Element root, Element eElement){
  Element nextSibling = (Element)eElement.getNextSibling();   
  return nextSibling; 
}

private static void getChildNode(Element root, Element eElement){
  // Text tTitle1 = (Text) eElement.getFirstChild( );
  // String strTitle1 = tTitle1.getData( );
  // System.out.println("Á¦¸ñ:" + strTitle1);
}

  public static void main(String[] args) throws Exception {
    // DOM ÆÄ¼­ ÆÑÅä¸® »ý¼º
    DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance();  
    // °ø¹é Á¦°Å
    myFactory.setIgnoringElementContentWhitespace(true); 
    //DOM ÆÄ¼­ »ý¼º
    DocumentBuilder myParser = myFactory.newDocumentBuilder();
    // XML ¹®¼­ ÆÄ½Ì ÈÄ ¸®ÅÏµÈ DOM Æ®¸®¸¦ Document Å¸ÀÔÀÇ °´Ã¼ xmlDoc·Î ÂüÁ¶ÇÏ±â
    Document myDoc = myParser.parse("jaegeun.xml"); 
    System.out.println("DOM °´Ã¼ »ý¼º");
    System.out.println("");
    Element eRoot = myDoc.getDocumentElement( );
    String str1 = eRoot.getNodeName( )+" "+eRoot.getNodeValue( )+" "+eRoot.getNodeType( );
//    System.out.println(str1);
//    System.out.println(eRoot.getNodeName() + " " + eRoot.getTagName( ));
       
    Element product = (Element)eRoot.getFirstChild( );
    String str2 = product.getNodeName( )+" "+product.getNodeValue( )+" "+product.getNodeType( );
    
    getName(eRoot);
    // getChildNode(eRoot, nextSibling(eRoot, product));
    // System.out.println(nextSibling(eRoot, product).getNodeName() + " " + nextSibling(eRoot, product).getNodeValue( ));




/*
    // ¼øÂ÷Àû °Ë»ö
    NodeList nTitles = eRoot.getElementsByTagName("ÀÌ¸§");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
       Element eTitle1 = (Element) nTitles.item(i);
       Text tTitle1 = (Text) eTitle1.getFirstChild( );
       String strTitle1 = tTitle1.getData( );
       System.out.println("Á¦¸ñ [" + i + "]: " + strTitle1);
    }
    System.out.println("");
*/  

/*
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    // 
    NodeList nTitles = eRoot.getElementsByTagName("ÀÌ¸§");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
       Element eTitle1 = (Element) nTitles.item(i);
       Text tTitle1 = (Text) eTitle1.getFirstChild( );
       Element tTitle2 = (Element)eTitle1.getNextSibling();  
       Element weigh = (Element)tTitle2.getLastChild( );
       String strTitle1 = tTitle1.getData( );
       String strTitle2 = weigh.getTextContent();
       if(message.equals(strTitle1)){
        System.out.println("»óÇ° Á¤º¸: " + strTitle2);
        System.out.println("»óÇ° Á¤º¸: " + eTitle1.getAttribute("id"));
  }
    }
    System.out.println("");  
*/
   
/*
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = eRoot.getElementsByTagName("ÀÌ¸§");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
       Element eTitle1 = (Element) nTitles.item(i);
       Text tTitle1 = (Text) eTitle1.getFirstChild( );
       String strTitle1 = tTitle1.getData( );
       if(message.equals(strTitle1)){
        System.out.println("»óÇ° Á¤º¸: " + eTitle1.getAttribute("id"));
  }
    }
    System.out.println("");  
*/
   }
}