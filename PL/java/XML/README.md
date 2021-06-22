# 문제
```java
19. 뉴스, 채용정보, 블로그 같은 웹사이트들에서 자주 갱신되는 콘텐츠 정보를 웹사이트들
간에 교환하기 위해 만들어진 XML(extensible markup language) 기반 형식으로 옳은
것은?

1 XSS(cross site scripting)
2 PICS(platform for internet content selection)
3 RSS(really simple syndication)
4 XHTML(extensible HTML)
RSS(really simple syndication)는 뉴스나 블로그에서 주로 사용하는 콘텐츠 표현 방식
입니다. 전에는 원하는 정보를 얻기 위해 해당 사이트를 직접 방문하여야 했으나, RSS
관련 프로그램(혹은 서비스)을 이용하여 자동 수집이 가능해졌기 때문에 사용자는 각각
의 사이트 방문 없이 최신 정보들만 골라 한 자리에서 볼 수 있습니다.
```

# [XML](http://tcpschool.com/xml/intro)
```java
XML 약자
'XML'은 'Extensible Markup Language'의 약자로 '확장 가능한 마크업 Language'라고 할 수 있습니다.


메타 언어
메타언어는 보통 마크업 언어를 개발하기 위한 언어라고 하는데요.

메타언어로는 SGML(Standard Generated Markup Language)﻿가 있습니다.

우리가 잘 알고있는 HTML 언어는 SGML로 개발된 언어입니다.

XML 취지
XML은 SGGML의 부분집합으로서 SGML의 장점을 취하고 불필요하고 복잡한 부분을 배제하여 SGML보다 훨씬 단순하고 이용하기 쉬운
메타언어를 개발하는 것입니다.
```

# W3C
* WWW에 관심을 가지고 있는 전 세계 맴버기관들이 모인 집단이다.
* w3C는 표준이란 용어 대신 권고안이라는 용어를 사용하여 최종 규격을 부르고 있다.

## W3C의 xmL 개발 목표
```java
1. XML은 인터넷에서 곧바로 사용할 수 있어야 한다.

2. XML은 넓은 주류의 적용(applicatoin)을 지원하여야 한다.

3. XML은 SGML과 호환성이 있어야 한다.

4. XML 문서들을 처리하는 프로그램을 쉽게 사용할 수 있어야 한다.

5. XML의 선택적 성능(feature)들이 완전히 최소되던가 가능하면 없어야 한다.

6. XML 문서들은 인간이 이해하기에 상당히 쉬워야 한다.

7. XML 디자인을 빨리 할 수 있어야 한다.

8. XML 디자인은 양식에 따르고 함축적이어야 한다.

9. XML 문서들은 생성하기 쉬어야 한다.

10. XML 작성(markup)에서의 간결성(terseness)은 별로 중요하지 않다.

​

W3C는 1994년 10월 Time Berners-Lee(web의 창시자)가 설립했다.

W3C는 미국의 MIT에 있는 컴퓨터 과학 연구소(MIT/LCS), 유럽의 INRIA, 일본의 Keio 대학 캠퍼스를 근간으로 두고 있다.
```

## HTML의 한계
* 데이터 처리용 응용 프로그램은 HTML 문서를 받고 순수 데이터를 추출해야 하는데, HTML 문서 내용에서 데이터를 추출할 수는 잇지만, 데이터의 의미까지는 알 수 없다.

## XML 장점
* XML 문서는 응용 프로그램으로 하여금 쉽고 정확하게 데이터를 처리할 수 있도록 데이터를 조직화하고 구조화 시킨다.
* XML은 일반 Text형식의 유니코드로 작성되기 때문에 유니코드를 인식하는 모든 운영 체제상의 응용 프로그램과도 호환성 있는 문서가 된다.
* XML 문서는 유니코드로 이루어져있기 때문에 이깆오 시스템에서 응용 프로그램 간에 정보를 공유할 수 있고 각종 데이터 교환이 가능해진다.


# XML을 사용하기 위해 준비해야 할 것들
1. XML 문서는 기본적으로 유니코드로 작성하는 것을 원칙으로 하기 때문에 유니코드 인코딩을 지원하는 에디터를 선택해야 한다.
2. XML 문서가 잘 작성되어있는지 검사할 수 있는 소프트웨어 및 XMl 문서를 디스플레이할 브라우저
3. XML 문서를 처리하는 응용 프로그램을 개발하기 위해서 프로그래밍 언어에서 사용할 XML 관련 라이브러리(API)가 필요하다.


# XML 문서의 종류
1. 잘 짜인 문서(Well-formed XML DOcument)
  * XML1.0 권고안에 언급되어 있는 문법을 잘 지켜서 작성된 문서
2. 유효한 문서(Valid Document)
  * 잘 짜인 문서이면서, XML로 개발된 특정 마크업 언어에 맞게 작성된 문서
  
# XML 선언 문서
* 주의할 점은 첫째로 XML 선언 이전에는 어떤 내용이든 기술되면 안된다.
* 즉 XML 선언은 XML 문서 첫 줄에 반드시 기술되어야 한다.

## Version
* 현재 XML 구너고안의 버전은 1.0이다. 반드시 이 값을 지정해야 한다.

## Encoding
* 작성하는 XML 문서를 어떤 인코딩 방식으로 저장할 것인가를 지정한다. 
* Encoding 속성은 생략 가능하다.
* 생략이 되면 디폴트로 유니코드 인코딩 방식인 UTF-8 방식으로 XML 프로세스는 XML 문서를 처리하게 된다.
* XML 권고안은 모든 XML 문서는 유니코드 인코딩 방식인 UT-8 인코딩 방식으로 저장할 것을 기본으로 하고 있다.

## Standalone
* 작성된 XML 문서를 XML 파서가 해석할 때 외부 DTD 문서를 참고해야 된다는 것을 XML 파서에게 알려주는 목적으로 사용한다.
* 속성값이 no이면 XML 파서로 하여금 외부 문서를 참고해서 XML 문서를 해석하라는 뜻이고 yes이면 xml 파서가 해당 XML 문서를 해석할 때 외부 문서를 참고할 필요가 없다는 듰이다.


# 엘리먼트
1. 내용을 가지는 엘리먼트
2 내용이 없는 엘리먼트(빈 엘리먼트)
 * 시작 태그와 끝 태그 사이에 공백이 오면 안된다.
 
## 엘리먼트로 올 수 있는 것들
* 문자 데이터
* 자식 엘리먼트
* 엔티티 또는 문자 참조
* CDATA 섹션
* 프로세싱 지시자
* 주석
* 공백 문자열

```java
# 엘리먼트 작성문법

모든 XML문서는 단 하나의 Root Element를 갖는다
엘리먼트들은 트리 형태의 계층구조를 갖는다
시작태그, 끝태그, 속성, 내용으로 이루어져 있다.
예>  <book id=“b001”> 내용입니다.</book>


# 엘리먼트의 종류

1. 내용을 가지는 엘리먼트 : 문자데이터나 자식 엘리먼트를 내용으로 갖는 엘리먼트

 <book>
      <title> 자연과 인간 </title>
 </book>

2. 내용이 없는 엘리먼트 : Empty Element 라고도 한다.

 <image src=“image1.gif”/>
 <image src=“image2.gif”></image>   (태그 사이에 공백도 안됨)


# 엘리먼트 작성시 주의사항

 1. 시작태그와 끝태그는 반드시 짝으로 이루어져야 한다. 단, 빈 엘리먼트는 시작태그 끝에 /를 붙여 표시한다.
 2. <, >는 태그를 표시하는 문자이므로 가능한 &lt; &gt로 사용한다.
 3. 시작태그, 끝태그 이름에 공백이 포함될 수 없다
 4. 중첩되어 작성할 수 없다.


# 태그의 이름 작성규칙

 1. 문자, _ 로만 시작할 수 있다.
 2. 두 번째 문자부터 문자, 숫자 및 특수문자 ‘_’ , ‘-’ , ‘.’ 도 가능하다.
 3. 태그 이름에 공백은 사용할 수 없다.
 4. 특수문자 : 는 사용가능하나 네임스페이스와 관련되어 있으므로 사용하지 않는 것이 좋다.
 5. 대소문자를 구분하여 사용한다.
 6. 태그의 시작인 <, </ 다음에 공백문자가 올 수 없다.
 7. 태그이름은 xml로 시작할 수 없다.



# 엘리먼트에 들어올 수 있는 내용

문자 데이터(Character Data)
XML 프로세서가 해석할 수 있는 내용 중에서 마크업을 제외한 부분을 말한다.
XML권고안에서 마크업은 XML선언, DOCTYPE선언, 주석, 태그, 엔티티참조, 문자참조, CDATA 구분자 등이 있다.
문자 데이터 내에는 ‘&’ 문자와 ‘<’ 문자를 사용할 수 없다. ‘&’ 문자는 엔티티 참조의 시작을 의미하며, ‘<’ 문자는 엘리먼트의 태그, CDATA 섹션의 시작을 의미하기 때문이다.
빌트인(Built-in) 엔티티 참조 또는 문자 참조로 사용이 가능하다.

 

자식 엘리먼트
엘리먼트의 내용으로 자식(Child) 엘리먼트를 포함할 수 있다.

 

엔티티 참조 (Entity Reference)
자주 쓰이는 내용을 엔티티로 정의하고, XML 문서에서 엔티티로 정의된 내용과 동일한 내용이 작성되어야 할 부분에 엔티티 참조를 사용한다

문자참조 (Character Reference)
문자 집합 코드표상에 언급되어 있는 코드 값을 직접 사용하여 문자를 표현한다

CDATA 섹션
대부분의 문자 데이터인 PCDATA(Parsed Character DATA)는 XML 파서가 해석(Parsing)하는 데이터를 말한다.  CDATA 섹션(Section) 내에 정의된 
문자 데이터는 XML 프로세서가 해석하지 않고 바로 응용프로그램(Application)에게 전달한다.


프로세싱 지시자
일반적으로는 엘리먼트의 내용(Content) 부분에 프로세싱 지시자가 오지 않는다. 프로세싱 지시자는 문서 서두(prolog) 부분에 기술되어 
응용프로그램이 XML 문서를 처리하기 위한 정보를 전달할 목적으로 사용된다.


공백문자열
공백 문자열(White Space)이란 하나 이상의 공백 문자들로 구성된 문자열을 말한다.XML 1.0 권고안에서는 스페이스(#x20), 탭(#x9),
캐리지 리턴(#xd), 라인피드(#xa) 만을 공백 문자로 분류하고 있다. XML 프로세서는 공백 문자열을 하나의 공백 문자로 취급한다.



속성
속성(Attribute)은 엘리먼트에 부가적인 정보를 줄 수 있다.
속성은 속성명=속성값으로 표기하며, ‘=’ 앞과 뒤에 공백을 둘 수 있다.
한 개의 엘리먼트는 같은 속성명을 2번 이상 기술할 수 없다.
속성명은 XML 권고안에 언급되어 있는 이름 작성 규칙을 따라야 한다.
 

주석의 사용

주석은 XML 문서를 작성하는 사람은 물론 XML 문서를 읽는 사람이 좀더 쉽게 이해할 수 있도록 덧붙인 설명이다. ‘--’를 사용하거나 XML선언 이전에 사용해서는 안 된다
```

# CDATA 섹션
* PCDATA는 XML 파서가 해석하는 문자 데이터를 말한다.

# 속성
* 엘리먼트에 부가적인 정보를ㅈ ㅜㄹ 수 있다.
* XML 권고안을 따라야 한다.

# 프로세싱 지시자
* 해당 XML 문서를 처리하는 응용 프로그램에게 XML 문서의 처리 방법을 지시하는 내용을 담고 있다.

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
