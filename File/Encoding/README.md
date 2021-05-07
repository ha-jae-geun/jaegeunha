
# base64 url
```java
	encode64url = function(bytes) {
		var v = encode64(bytes);
		v = v.split('=')[0];
		v = v.replace(/\+/g, '-');
		v = v.replace(/\//g, '_');
		return v;
	}
	
	/**
	 * RFC4648 Base64url decode
	 */
	decode64url = function(v) {
		v = v.replace(/\-/g, '+');
		v = v.replace(/\_/g, '/');
	
		switch (v.length % 4) {
			case 0:
				break;
			case 2:
				v += '==';
				break;
			case 3:
				v += '=';
				break;
			default:
				throw new error('illegal base64url string');
		}
	
		v = decode64(v);
	
		return v;
	}
```


## base64url 주의
```java
일반데이터
		
“=“ 으로 패딩 처리 (우리가 흔히 쓰는 상황)
URL과 파일이름을 인코딩하는 패딩정보인 “=“를 “~” 로 대체
	패딩정보인 “=“를 “.“ 로 대체
	패딩정보인 “=“를 날려버리고, 사용하는 측에서 데이터 길이를 계산에서 역으로 “=“ 개수를 역산
	세가지 패딩 처리의 대안을 이야기하지만, 규격화 되지 않음 (RFC-4648 #section 5)
```
