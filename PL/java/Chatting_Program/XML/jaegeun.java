import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.Scanner; 


public class jaegeun {

private static void getElement(Element root){
    Element eTitle1;
    System.out.println("\n 검색하기를 원하는 상품 요소명을 입력해주세요. \n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName(message);
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      System.out.println("검색한 엘리먼트");
      System.out.println(message + " " + strTitle1);
      System.out.println("----------------");
      System.out.println("기타 정보");
      printName(root, i);
      System.out.println("\n \n ");
  }
}

private static void getNames(Element root){
    Element eTitle1;
    NodeList nTitles = root.getElementsByTagName("이름");
    int items = nTitles.getLength();
    
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      System.out.println("상품명 [" + i + "]: " + strTitle1);
      System.out.println("상품 정보: " + eTitle1.getAttribute("id"));
      getSiblingTagName(root, eTitle1);
      getPrice(root, i);
      getSale(root, i);
      System.out.println("");
  }
}

private static void getName(Element root){
    Element eTitle1;
    System.out.println("\n 검색하기를 원하는 상품명을 입력해주세요. \n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("이름");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      if(message.equals(strTitle1)){
          System.out.println("상품명 [" + i + "]: " + strTitle1);
          System.out.println("상품정보: " + eTitle1.getAttribute("id"));
          getSiblingTagName(root, eTitle1);
          getPrice(root, i);
          getSale(root, i);
    }
  }
}

private static void printName(Element root, int i){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("이름");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    Text tTitle1 = (Text) eTitle1.getFirstChild( );
    String strTitle1 = tTitle1.getData( );
    System.out.println("상품명 [" + i + "]: " + strTitle1);
    System.out.println("상품정보: " + eTitle1.getAttribute("id"));
    getSiblingTagName(root, eTitle1);
    getPrice(root, i);
    getSale(root, i);
}

private static Element returnProduct(Element root, int i){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("상품");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    return eTitle1;
}

private static void getPrice(Element root, int i){
    Element eTitle1;
    NodeList nTitles = root.getElementsByTagName("결제");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    System.out.println("결제수단");
    getChildTag(root, eTitle1);
}

private static void getSale(Element root, int i){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("할인율");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    Text tTitle1 = (Text) eTitle1.getFirstChild( );
    String strTitle1 = tTitle1.getData( );
    System.out.println("할인율: " + eTitle1.getAttribute("기간"));
    System.out.println("할인가격:  " + strTitle1);
}

private static Element nextSibling(Element root, Element eElement){
  Element nextSibling = (Element)eElement.getNextSibling();   
  return nextSibling; 
}

private static void getChildName(Element root, Element eElement){
  Element eTitle1 = (Element)eElement.getFirstChild( );
  System.out.println(nextSibling(root, eTitle1).getNodeName());
}

private static void getChildTag(Element root, Element eElement){
  Element eTitle1 = (Element)eElement.getFirstChild( );
  System.out.println("  " + eTitle1.getTagName());
}

private static void getSiblingTagName(Element root, Element eElement){
  Text tTitle1 = (Text) nextSibling(root, eElement).getFirstChild();
  String strTitle1 = tTitle1.getData( );
  System.out.println(nextSibling(root, eElement).getTagName( ) + " " + strTitle1);
}

private static void getProduct(Element root){
    Element eTitle1;
    System.out.println("\n 검색하기를 원하는 상품 유형을 입력해주세요. \n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("상품");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      // Text tTitle1 = (Text) eTitle1.getAttribute();
      String strTitle1 = eTitle1.getAttribute("상품유형");
      if(message.equals(strTitle1)){
  	   printName(root, i);
       System.out.println("");
    }
  }
}

private static Element createElement(Document mydoc){
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();
    Element eTitle1 = mydoc.createElement(message);
    return eTitle1;
}

private static Text createText(Document mydoc){
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();
    Text eText = mydoc.createTextNode(message);
    return eText;
}

private static void appendNode(Element eElement, Text eText){
    eElement.appendChild(eText);
}

private static void createAttribute(Element eElement){
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();
    Scanner scan2 = new Scanner(System.in);
    String message2 = scan2.nextLine();
    eElement.setAttribute(message, message2);
}

private static void createNode(Element root, Document mydoc){
    Element product;
    Element Title;
    Element eTitle;
    Element eTitle2;
    Text eText;

//상품
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요. (상품)"); 
    product = createElement(mydoc);
    System.out.println("생성할 상품 이름과 값을 순서대로 입력하세요 (상품유형, 상품이름)\n"); 
    createAttribute(product);
//원료원산지
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (원료원산지)");  
    Title = createElement(mydoc);
    System.out.println("생성할 속성 이름과 값을 순서대로 입력하세요 (원산지, 원산지명)"); 
    createAttribute(Title);
    root.appendChild(Title);
//이름
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (이름)"); 
    eTitle = createElement(mydoc);
    System.out.println("생성할 속성 이름과 값을 순서대로 입력하세요 (id, id명)");
    createAttribute(eTitle);
    System.out.println("상품명을 입력하세요");
    eText = createText(mydoc);
    appendNode(eTitle, eText);
    Title.appendChild(eTitle);
//무게
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (무게)"); 
    eTitle2 = createElement(mydoc);
    System.out.println("무게(kg/g)를 입력하세요."); 
    eText = createText(mydoc);
    appendNode(eTitle2, eText);
    Title.appendChild(eTitle2);
//가격
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (가격)"); 
    eTitle = createElement(mydoc);
    Title.appendChild(eTitle);
//결제
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (결제)"); 
    eTitle2 = createElement(mydoc);
    eTitle.appendChild(eTitle2);
//카드
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (카드 or 현금)"); 
    eTitle = createElement(mydoc);
    System.out.println("생성할 속성 이름과 값을 순서대로 입력하세요 (회사, 회사명)");
    createAttribute(eTitle);
    eTitle2.appendChild(eTitle);
//할인율
    System.out.println("\n 생성할 엘리먼트의 이름을 입력하세요 (할인율)"); 
    eTitle2 = createElement(mydoc);
    System.out.println("생성할 속성 이름과 값을 순서대로 입력하세요 (기간, 할인 기간)"); 
    createAttribute(eTitle2);
    System.out.println("할인율을 입력하세요\n ");
    eText = createText(mydoc);
    appendNode(eTitle2, eText);
    eTitle.appendChild(eTitle2);

    root.appendChild(product);
}

private static void modifyElement(Element eElement){
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    Text tTitle = (Text) eElement.getFirstChild( );
    tTitle.setData(message);
}

private static void modifyAttribute(Element eElement){
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();
    Scanner scan2 = new Scanner(System.in);
    String message2 = scan2.nextLine();

    eElement.setAttribute(message, message2);
}

private static void modifyProduct(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("이름");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyAttribute(eTitle1);
}

private static void modifyIngredient(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("원료원산지");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyAttribute(eTitle1);
}

private static void modifyCard(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("카드");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyAttribute(eTitle1);
}
private static int modifyName(Element root){
    int j = 0;
    Element eTitle1;
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("이름");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      if(message.equals(strTitle1)){
    	           System.out.println("수정될 상품의 이름을 입력해주세요");
	           modifyElement(eTitle1);
	           j=i;
	          break;
    }
      if(i == (items-1) )
	j=10;
  }
    return j;
}

private static void modifyWeight(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("무게");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyElement(eTitle1);
}

private static void modifySale(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("할인율");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyElement(eTitle1);
}

private static void modifyAll(Element root){
    System.out.println("수정할 상품의 이름을 입력하세요");
    int number = modifyName(root);
    if(number!= 10){
  	 System.out.println("수정될 상품의 정보를 입력하세요");
  	 modifyProduct(root, number);
   	 System.out.println("수정할 원료원산지를 입력하세요.");
   	 modifyIngredient(root, number);
  	 System.out.println("수정할 무게를 입력하세요");
   	 modifyWeight(root, number);
  	 System.out.println("수정할 카드 회사를 입력하세요");
   	 modifyCard(root, number);
   	 System.out.println("할인율을 입력하세요.");
  	 modifySale(root, number);
   }
     System.out.println("수정할 상품이 존재하지 않습니다.");
}

private static void removeName(Element root){

    Element eTitle1;
    System.out.println("\n삭제할 상품의 이름을 입력하세요.\n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("이름");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      if(message.equals(strTitle1)){
	root.removeChild(returnProduct(root, i));
            System.out.println("삭제할 상품이 존재합니다. 삭제에 성공했습니다.");
            break;
    }
     if(i == (items-1) )
            System.out.println("삭제할 상품이 존재하지 않습니다.");
  }
}


  public static void main(String[] args) throws Exception {
    // DOM 
    DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance();  
    // 
    myFactory.setIgnoringElementContentWhitespace(true); 
    //DOM 
    DocumentBuilder myParser = myFactory.newDocumentBuilder();
    // XML 
    Document myDoc = myParser.parse("jaegeun.xml"); 
    System.out.println("DOM 트리 생성");
    System.out.println("");
    Element eRoot = myDoc.getDocumentElement( );
    String str1 = eRoot.getNodeName( )+" "+eRoot.getNodeValue( )+" "+eRoot.getNodeType( );
//    System.out.println(str1);
//    System.out.println(eRoot.getNodeName() + " " + eRoot.getTagName( ));
       
    Element product = (Element)eRoot.getFirstChild( );
    String str2 = product.getNodeName( )+" "+product.getNodeValue( )+" "+product.getNodeType( );
    
    while(true){
          System.out.println("상품 정보 관리 프로그램\n");
          System.out.println("-메인 메뉴-\n");
          System.out.println("1) 검색\n");
          System.out.println("2) 갱신\n");
          System.out.println("3) 종료\n");
          System.out.println("> 메뉴선택: \n");

          Scanner scan = new Scanner(System.in);
          int number = scan.nextInt();

          if(number == 1){
          System.out.println("상품 정보 관리 프로그램\n");
          System.out.println("-메인 메뉴-\n");
          System.out.println("1) 순차 검색\n");
          System.out.println("2) 상품명으로 검색\n");
          System.out.println("3) 상품유형으로 검색\n");
          System.out.println("4) 상품 요소명으로 검색\n");
          System.out.println("> 메뉴선택: \n");

            Scanner scan2 = new Scanner(System.in);
            int number2 = scan.nextInt();            

            if(number2 == 1){
              getNames(eRoot);
              continue;
            }
            if(number2 == 2){
              getName(eRoot);
              continue;
            }
            if(number2 == 3){
              getProduct(eRoot);
              continue;
            }
            if(number2 == 4){
              getElement(eRoot);
              continue;
            }
          }

          if(number == 2){
            System.out.println("상품 정보 관리 프로그램\n");
            System.out.println("-메인 메뉴-\n");
            System.out.println("1) 상품 추가\n");
            System.out.println("2) 상품 삭제\n");
            System.out.println("3) 상품 내용 수정\n");
            System.out.println("> 메뉴선택: \n");
            Scanner scan2 = new Scanner(System.in);
            int number2 = scan.nextInt();    

            if(number2 == 1){
              createNode(eRoot, myDoc);
              continue;

            }
            if(number2 == 2){
              removeName(eRoot);
              continue;
            }
            if(number2 == 3){
              modifyAll(eRoot);
              continue;
            }
          }

          if(number == 3){
            System.out.println("시스템을 종료합니다.");
            break;
           }
        }  
   }
}