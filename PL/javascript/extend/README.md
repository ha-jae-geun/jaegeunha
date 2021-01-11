# 특정 객체에 파라미터 객체를 추가하기 위한 함수이다.
```javascript
    /**
     * @memberof vest
     *
     * @param   {Object}   dst 파라미터 객체를 추가하게 될 객체명
     */
    function extend(dst) {
        for (var i = 1, ii = arguments.length; i < ii; i++) {
            var obj = arguments[i];
            if (obj) {
                var keys = Object.keys(obj);
                for (var j = 0, jj = keys.length; j < jj; j++) {
                    var key = keys[j];
                    dst[key] = obj[key];
                }
            }
        }
    }
    
    
            vest.extend(vest.util, {
            // 'certClasses': certClasses,
            'WebStorage': WebStorage,
            'file': file,
            'certVersion': certVersion,
            'setObject': setObject,
            'refactoryMsg': refactoryMsg,
            'checkComplexPassword': checkComplexPassword,
            'removeObjectElement': removeObjectElement,
            'getIEVersion': getIEVersion,
            'size': yettieFrameReSize,
            'modifyMobileFrame': modifyMobileFrame,
            'matchedDn': matchedDn,
            'serialFilterForKoscom': serialFilterForKoscom,
            'base64ToHex': base64ToHex,
            'hexToBase64': hexToBase64,
            'encode64': encode64,
            'decode64': decode64,
            'certificateSubjectDNField': certificateSubjectDNField,
            'title': viewsTitle,
            'HibiscusCertListToVestCertCertList': HibiscusCertListToVestCertCertList
        });
```
