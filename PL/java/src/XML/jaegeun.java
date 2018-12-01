import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.Scanner; 


public class jaegeun {

private static void getElement(Element root){
    Element eTitle1;
    System.out.println("\n �˻��ϱ⸦ ���ϴ� ��ǰ ��Ҹ��� �Է����ּ���. \n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName(message);
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      System.out.println("�˻��� ������Ʈ");
      System.out.println(message + " " + strTitle1);
      System.out.println("----------------");
      System.out.println("��Ÿ ����");
      printName(root, i);
      System.out.println("\n \n ");
  }
}

private static void getNames(Element root){
    Element eTitle1;
    NodeList nTitles = root.getElementsByTagName("�̸�");
    int items = nTitles.getLength();
    
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      System.out.println("��ǰ�� [" + i + "]: " + strTitle1);
      System.out.println("��ǰ ����: " + eTitle1.getAttribute("id"));
      getSiblingTagName(root, eTitle1);
      getPrice(root, i);
      getSale(root, i);
      System.out.println("");
  }
}

private static void getName(Element root){
    Element eTitle1;
    System.out.println("\n �˻��ϱ⸦ ���ϴ� ��ǰ���� �Է����ּ���. \n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("�̸�");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      if(message.equals(strTitle1)){
          System.out.println("��ǰ�� [" + i + "]: " + strTitle1);
          System.out.println("��ǰ����: " + eTitle1.getAttribute("id"));
          getSiblingTagName(root, eTitle1);
          getPrice(root, i);
          getSale(root, i);
    }
  }
}

private static void printName(Element root, int i){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("�̸�");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    Text tTitle1 = (Text) eTitle1.getFirstChild( );
    String strTitle1 = tTitle1.getData( );
    System.out.println("��ǰ�� [" + i + "]: " + strTitle1);
    System.out.println("��ǰ����: " + eTitle1.getAttribute("id"));
    getSiblingTagName(root, eTitle1);
    getPrice(root, i);
    getSale(root, i);
}

private static Element returnProduct(Element root, int i){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("��ǰ");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    return eTitle1;
}

private static void getPrice(Element root, int i){
    Element eTitle1;
    NodeList nTitles = root.getElementsByTagName("����");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    System.out.println("��������");
    getChildTag(root, eTitle1);
}

private static void getSale(Element root, int i){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("������");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(i);
    Text tTitle1 = (Text) eTitle1.getFirstChild( );
    String strTitle1 = tTitle1.getData( );
    System.out.println("������: " + eTitle1.getAttribute("�Ⱓ"));
    System.out.println("���ΰ���:  " + strTitle1);
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
    System.out.println("\n �˻��ϱ⸦ ���ϴ� ��ǰ ������ �Է����ּ���. \n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("��ǰ");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      // Text tTitle1 = (Text) eTitle1.getAttribute();
      String strTitle1 = eTitle1.getAttribute("��ǰ����");
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

//��ǰ
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ���. (��ǰ)"); 
    product = createElement(mydoc);
    System.out.println("������ ��ǰ �̸��� ���� ������� �Է��ϼ��� (��ǰ����, ��ǰ�̸�)\n"); 
    createAttribute(product);
//���������
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (���������)");  
    Title = createElement(mydoc);
    System.out.println("������ �Ӽ� �̸��� ���� ������� �Է��ϼ��� (������, ��������)"); 
    createAttribute(Title);
    root.appendChild(Title);
//�̸�
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (�̸�)"); 
    eTitle = createElement(mydoc);
    System.out.println("������ �Ӽ� �̸��� ���� ������� �Է��ϼ��� (id, id��)");
    createAttribute(eTitle);
    System.out.println("��ǰ���� �Է��ϼ���");
    eText = createText(mydoc);
    appendNode(eTitle, eText);
    Title.appendChild(eTitle);
//����
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (����)"); 
    eTitle2 = createElement(mydoc);
    System.out.println("����(kg/g)�� �Է��ϼ���."); 
    eText = createText(mydoc);
    appendNode(eTitle2, eText);
    Title.appendChild(eTitle2);
//����
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (����)"); 
    eTitle = createElement(mydoc);
    Title.appendChild(eTitle);
//����
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (����)"); 
    eTitle2 = createElement(mydoc);
    eTitle.appendChild(eTitle2);
//ī��
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (ī�� or ����)"); 
    eTitle = createElement(mydoc);
    System.out.println("������ �Ӽ� �̸��� ���� ������� �Է��ϼ��� (ȸ��, ȸ���)");
    createAttribute(eTitle);
    eTitle2.appendChild(eTitle);
//������
    System.out.println("\n ������ ������Ʈ�� �̸��� �Է��ϼ��� (������)"); 
    eTitle2 = createElement(mydoc);
    System.out.println("������ �Ӽ� �̸��� ���� ������� �Է��ϼ��� (�Ⱓ, ���� �Ⱓ)"); 
    createAttribute(eTitle2);
    System.out.println("�������� �Է��ϼ���\n ");
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

    NodeList nTitles = root.getElementsByTagName("�̸�");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyAttribute(eTitle1);
}

private static void modifyIngredient(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("���������");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyAttribute(eTitle1);
}

private static void modifyCard(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("ī��");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyAttribute(eTitle1);
}
private static int modifyName(Element root){
    int j = 0;
    Element eTitle1;
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("�̸�");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      if(message.equals(strTitle1)){
    	           System.out.println("������ ��ǰ�� �̸��� �Է����ּ���");
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

    NodeList nTitles = root.getElementsByTagName("����");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyElement(eTitle1);
}

private static void modifySale(Element root, int number){
    Element eTitle1;

    NodeList nTitles = root.getElementsByTagName("������");
    int items = nTitles.getLength();
    eTitle1 = (Element) nTitles.item(number);
    modifyElement(eTitle1);
}

private static void modifyAll(Element root){
    System.out.println("������ ��ǰ�� �̸��� �Է��ϼ���");
    int number = modifyName(root);
    if(number!= 10){
  	 System.out.println("������ ��ǰ�� ������ �Է��ϼ���");
  	 modifyProduct(root, number);
   	 System.out.println("������ ����������� �Է��ϼ���.");
   	 modifyIngredient(root, number);
  	 System.out.println("������ ���Ը� �Է��ϼ���");
   	 modifyWeight(root, number);
  	 System.out.println("������ ī�� ȸ�縦 �Է��ϼ���");
   	 modifyCard(root, number);
   	 System.out.println("�������� �Է��ϼ���.");
  	 modifySale(root, number);
   }
     System.out.println("������ ��ǰ�� �������� �ʽ��ϴ�.");
}

private static void removeName(Element root){

    Element eTitle1;
    System.out.println("\n������ ��ǰ�� �̸��� �Է��ϼ���.\n");
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();

    NodeList nTitles = root.getElementsByTagName("�̸�");
    int items = nTitles.getLength();
    for(int i=0; i<items; i++) {
      eTitle1 = (Element) nTitles.item(i);
      Text tTitle1 = (Text) eTitle1.getFirstChild( );
      String strTitle1 = tTitle1.getData( );
      if(message.equals(strTitle1)){
	root.removeChild(returnProduct(root, i));
            System.out.println("������ ��ǰ�� �����մϴ�. ������ �����߽��ϴ�.");
            break;
    }
     if(i == (items-1) )
            System.out.println("������ ��ǰ�� �������� �ʽ��ϴ�.");
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
    System.out.println("DOM Ʈ�� ����");
    System.out.println("");
    Element eRoot = myDoc.getDocumentElement( );
    String str1 = eRoot.getNodeName( )+" "+eRoot.getNodeValue( )+" "+eRoot.getNodeType( );
//    System.out.println(str1);
//    System.out.println(eRoot.getNodeName() + " " + eRoot.getTagName( ));
       
    Element product = (Element)eRoot.getFirstChild( );
    String str2 = product.getNodeName( )+" "+product.getNodeValue( )+" "+product.getNodeType( );
    
    while(true){
          System.out.println("��ǰ ���� ���� ���α׷�\n");
          System.out.println("-���� �޴�-\n");
          System.out.println("1) �˻�\n");
          System.out.println("2) ����\n");
          System.out.println("3) ����\n");
          System.out.println("> �޴�����: \n");

          Scanner scan = new Scanner(System.in);
          int number = scan.nextInt();

          if(number == 1){
          System.out.println("��ǰ ���� ���� ���α׷�\n");
          System.out.println("-���� �޴�-\n");
          System.out.println("1) ���� �˻�\n");
          System.out.println("2) ��ǰ������ �˻�\n");
          System.out.println("3) ��ǰ�������� �˻�\n");
          System.out.println("4) ��ǰ ��Ҹ����� �˻�\n");
          System.out.println("> �޴�����: \n");

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
            System.out.println("��ǰ ���� ���� ���α׷�\n");
            System.out.println("-���� �޴�-\n");
            System.out.println("1) ��ǰ �߰�\n");
            System.out.println("2) ��ǰ ����\n");
            System.out.println("3) ��ǰ ���� ����\n");
            System.out.println("> �޴�����: \n");
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
            System.out.println("�ý����� �����մϴ�.");
            break;
           }
        }  
   }
}