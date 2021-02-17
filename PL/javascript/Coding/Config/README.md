# addConfig
```javascript
        _this.addConfig = function (config) {
            for (var i in config) {
                if (config.hasOwnProperty(i)) {
                    _config[i] = config[i];
                }
            }
        };

```
