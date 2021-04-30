# base64
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
