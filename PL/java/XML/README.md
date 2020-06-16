# XML, JSon 공통점
```java
JSON과 XML의 공통점
JSON과 XML은 다음과 같은 공통점을 가지고 있습니다.

1. 둘 다 데이터를 저장하고 전달하기 위해 고안되었습니다.

2. 둘 다 기계뿐만 아니라 사람도 쉽게 읽을 수 있습니다.

3. 둘 다 계층적인 데이터 구조를 가집니다.

4. 둘 다 다양한 프로그래밍 언어에 의해 파싱될 수 있습니다.

5. 둘 다 XMLHttpRequest 객체를 이용하여 서버로부터 데이터를 전송받을 수 있습니다.
```

# JSON과 XML의 차이점
```java
하지만 JSON과 XML은 다음과 같은 차이점도 가지고 있습니다.


1. JSON은 종료 태그를 사용하지 않습니다.

2. JSON의 구문이 XML의 구문보다 더 짧습니다.

3. JSON 데이터가 XML 데이터보다 더 빨리 읽고 쓸 수 있습니다.

4. XML은 배열을 사용할 수 없지만, JSON은 배열을 사용할 수 있습니다.

5. XML은 XML 파서로 파싱되며, JSON은 자바스크립트 표준 함수인 eval() 함수로 파싱됩니다.


```

# JSON의 사용 범위
```java
XML 문서는 XML DOM(Document Object Model)을 이용하여 해당 문서에 접근합니다.

하지만 JSON은 문자열을 전송받은 후에 해당 문자열을 바로 파싱하므로, XML보다 더욱 빠른 처리 속도를 보여줍니다.

따라서 HTML과 자바스크립트가 연동되어 빠른 응답이 필요한 웹 환경에서 많이 사용되고 있습니다.

하지만 JSON은 전송받은 데이터의 무결성을 사용자가 직접 검증해야 합니다.

따라서 데이터의 검증이 필요한 곳에서는 스키마를 사용하여 데이터의 무결성을 검증할 수 있는 XML이 아직도 많이 사용되고 있습니다.
```


# XML
```java
Java XML parse Library (=XPath)

XPath : 자바에서 내장 패키지(javax.xml.xpath)로 제공하는 라이브러리로 XML형식의 웹문서, 파일, 문자열을 파싱하는데 사용한다.

요즘 누가 XML쓰나? JSON이랑 비교했을 때 태그같은 군더더기도 많고 파싱 속도, 전송 속도도 딸리는데? (* JSON이 무조건 좋은 것은 아님.)

하면서 별로 선호하지 않는 것은 사실이다.

하지만 의외로 아직까지 현업에서 사용되는 곳이 많이 있고 XML만의 장점도 있다.

따라서 데이터를 XML로 만드는 것과 XML을 파싱해서 데이터를 이용하는 것 둘다 할 줄 알아야하기 때문에 가장 먼저 XML 

파싱 라이브러리인 XPath에 대해 알아보았다.

OpenAPI로 받은 XML 데이터 파싱하기

OpenAPI로부터 받은 즉, URL로 받은 XML을 파싱하는 방법으로 자바 소스를 작성했다.



[XML 데이터]


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
 
public class OpenApi {
    public static void main(String[] args) {
        BufferedReader br = null;
        //DocumentBuilderFactory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            //OpenApi호출
            String urlstr = "http://openapi.airkorea.or.kr/"
                    + "openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"
                    + "?stationName=수내동&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey=서비스키&ver=1.3";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            
            //응답 읽기
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                result = result + line.trim();// result = URL로 XML을 읽은 값
            }
            
            // xml 파싱하기
            InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            // XPathExpression expr = xpath.compile("/response/body/items/item");
            XPathExpression expr = xpath.compile("//items/item");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    System.out.println("현재 노드 이름 : " + node.getNodeName());
                    System.out.println("현재 노드 타입 : " + node.getNodeType());
                    System.out.println("현재 노드 값 : " + node.getTextContent());
                    System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
                    System.out.println("현재 노드의 다음 노드 : " + node.getNextSibling());
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
Colored by Color Scripter
cs


1. XML이 제공되는 URL로 접속해서 데이터를 받아온다.

2. DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance()로 factory를 생성한다.

3. DocumentBuilder builder = factory.newDocumentBuilder();로 builder를 생성한다.

4. InputSource is = new InputSource(new StringReader( 1.에서 받은 xml문자열 )); 로 InputSource를 생성한다.

  - XML파일에서 받는거면 InputSource is = new InputSource(new FileReader( File객체 ));로 생성한다.

5. Document doc = builder.parse(is); 로 XML을 파싱한다.

6. XPath xpath = XPathFactory.newInstance().newXPath(); 로 XPath 객체를 생성하고

7. XpathExpression expr = xpath.complie( 선택하는 문법 ); 으로 가져올 element를 선택한다.

8. 해당 노드(Element)에 접근해서 필요한 데이터를 추출한다.



대략적으로 위와 같은 과정으로 XML데이터 파싱이 이루어진다.

 DocumentBuilderFactory로부터 builder를 만들어내고 InputSource에 XML을 넣어서 document를 만드는 것까지는 일반적이다.

여기서 XML을 파싱해서 새롭게 만들어진 DOM객체를 접근하는데에 XPath가 쓰인다.

중점적으로 봐야할 부분은 역시 XPath의 문법이다. XPath는 노드에 접근하는데에 표현식(XPathExpression)이 사용된다.

다른 블로그에서 Xpath 표현식 문법(?)에 대해 잘 정리한 곳이 많으므로 여기서는 자주 쓰이고 중요한 부분만 정리한다.

 XPathExpression

표현식까지 익혀야 한다고 번거로운 라이브러리라고 판단할 수도 있겠지만 한 번 익혀두거나 나중에 찾아보면서 사용해도 

훌륭한 것 같은 라이브러리니 간단하게 배운다.


item : <item>요소를 모두 선택함
/item : "/" 루트 노드의 자식 노드중에서 <item>엘리먼트를 선택함 (앞에 "/"가 들어가면 절대 경로)
item/jeongpro : <item>엘리먼트의 자식 노드중에서 <jeongpro>엘리먼트를 선택 (상대 경로)
// : 현재 노드의 위치와 상관없이 지정된 노드부터 탐색
//item : 위치와 상관없이 엘리먼트 이름이 <item>인 모든 엘리먼트
item/@id : 모든 <item>엘리먼트의 id속성 노드를 모두 선택함
item[k] : <item>엘리먼트 중에서 k번 째 <item>엘리먼트
item[@attr = val] : attr이라는 속성이 val값을 가지는 모든 <item>엘리먼트
cs
이런 표현식들이 있으니 잘 사용하면된다. 위의 예제에서는 //items/item 이라는 표현식을 적었으므로 "위치와 상관없이 

<items>라는 노드들 중에서 자식 노드가 <item>인 노드(element)들을 NodeList로 받았다.

결과적으로 파싱을 마친 후 노드에서 원하는 데이터를 정확하게 추출하는 것이 중요하다.

node.getNodeName() 으로 "element 이름"을 받았고

node.getTextContent() 로 "값"을 받았다. (* 참고로 getNodeValue()가 있는데 혼란을 겪지 않길 바란다.)

또한 node.getPrefix() 로 "네임스페이스 값"을 받을 수도 있고

node.getNextSibling으로 "다음 노드"를 선택할 수도 있다.

속성은 node.getAttributes().item(0) 이런식으로 받을 수 있다.

끝으로 문자열에서 xml 파싱하는 소스도 첨부한다.


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
 
public class OpenApi {
    public static void main(String[] args) {
        //DocumentBuilderFactory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            // xml 파싱하기
            String result = "<response xmlns:s='http://www.example.net/'><items><item><s:best>hello</s:best></item></items></response>";
            InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            // XPathExpression expr = xpath.compile("/response/body/items/item");
            XPathExpression expr = xpath.compile("//items/item");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    System.out.println("현재 노드 이름 : " + node.getNodeName());
                    System.out.println("현재 노드 이름 : " + node.getLocalName());
                    System.out.println("현재 노드 타입 : " + node.getNodeType());
                    System.out.println("현재 노드 값 : " + node.getTextContent());
                    System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
                    System.out.println("현재 노드의 다음 노드 : " + node.getAttributes().item(0));
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

```
