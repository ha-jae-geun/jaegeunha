# [JSDOC 사용법(블로그)](https://noogoonaa.tistory.com/36?category=855168)


# [JSDOC 플러그인 Document](https://www.npmjs.com/package/jsdoc)


# [JsDoc 사용 document](https://jsdoc.app/index.html)


# [JSDoc 사용 document](https://docs.w3cub.com/jsdoc/tags-class)

# JSDoc 생성 명령어
* ./node_modules/.bin/jsdoc -c ./jsdoc.config.json

# jsdoc config
```javascript
{
  "tags": {
    "allowUnknownTags": false,
    "dictionaries": ["jsdoc","closure"]
  },
  "source": {
    "include": ["target directory or file"],
    "exclude": ["ignore directory or file"],
    "includePattern": ".+\\.js(doc|x)?$",
    "excludePattern": "(^|\\/|\\\\)_"
  },
  "plugins": [
    "plugins/markdown",
    "jsdoc-route-plugin" // plugin for make api endpoint documentation
  ],
  "templates": {
    "cleverLinks": false,
    "monospaceLinks": false,
    "default": {
      "outputSourceFiles": false // view source 없앰
    }
  },
  "opts": {
    "recurse": true,
    "encoding": "utf8",
    "destination": "./docs"
  }
}
```

# jsdoc config 2
```javascript
{
  "plugins": ["node_modules/jsdoc/plugins/markdown"], // Markdown을 사용하기 위해 플러그인을 추가합니다.
  "recurseDepth": 10, // -r 명령 행 플래그로 재귀가 사용 가능한 경우 JSDoc은 10 레벨 깊이의 파일을 검색합니다.
  "source": {
    "include": ["./"], // ./ 이하 js, jsx, jsdoc을 대상으로 합니다.
    "includePattern": ".+\\.js(x|doc)?$", // js, jsx, jsdoc 이라는 확장자를 가진 것을 Docs로 변환합니다.
    "excludePattern": "(^|\\/|\\\\)_" // 밑줄로 시작하거나 밑줄로 시작하는 디렉토리에있는 모든 파일은 무시됩니다.
  },
  "sourceType": "module", // ES 2015를 지원하기 위해 적용
  "tags": {
    "allowUnknownTags": true // JSDoc이 알 수 없는 태그를 지원하도록 설정
  },
  "opts": {
    "encoding": "utf8", // Docs에서 한글을 사용할 수 있도록 설정
    "destination": "./docs", // 기존에 생성되던 out이라는 폴더를 docs라는 폴더로 생성
    "readme": "README.md", // README.md를 추가
    "template": "node_modules/better-docs"
  }
}

{
	"plugins": ["node_modules/jsdoc/plugins/markdown"],
	"recurseDepth": 10, 
	"source": {
		"include": ["./src"],
		"exclude": ["./src/index.js", "./src/jsrose_crypto.min.js"]
	},
	"sourceType": "module", 
	"tags": {
	  "allowUnknownTags": true 
	},
	"opts": {
	  "encoding": "utf8", 
	  "destination": "./doc",
	  "readme": "README.md",
	  "template": "node_modules/better-docs"
	},
	"templates": {
	  "default": {
	  	"outputSourceFiles": false
	  }
	}
  }

```
