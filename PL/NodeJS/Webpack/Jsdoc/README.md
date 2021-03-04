# [JSDOC 사용법(블로그)](https://noogoonaa.tistory.com/36?category=855168)


# [JSDOC 플러그인 Document](https://www.npmjs.com/package/jsdoc)


# [JsDoc 사용 document](https://jsdoc.app/index.html)


# [JSDoc 사용 document](https://docs.w3cub.com/jsdoc/tags-class)



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
      "outputSourceFiles": false
    }
  },
  "opts": {
    "recurse": true,
    "encoding": "utf8",
    "destination": "./docs"
  }
}
```
