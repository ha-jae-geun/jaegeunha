# buildpath
```shell
mkdir temp

cmd="find jaegeun/ -name *.html"
# cmd="find test/ -name *.html"
$cmd > ./resultFile.txt

while read line;
do
    path="$line"
    echo $path
    fileName=`basename $path`
    filePath=`dirname $path`
    # echo $fileName
    # echo $filePath
    sed -e 's/..\/..\/library/library/g' ./$filePath/$fileName > ./temp/$fileName
    mv ./temp/$fileName ./$filePath/$fileName
done < resultFile.txt


while read line;
do
    path="$line"
    echo $path
    fileName=`basename $path`
    filePath=`dirname $path`
    # echo $fileName
    # echo $filePath
    sed -e 's/\/VestSign\/app\/templates\/wide\/vestsign.js/..\/vestsign.js/g' ./$filePath/$fileName > ./temp/$fileName
    mv ./temp/$fileName ./$filePath/$fileName
done < resultFile.txt

while read line;
do
    path="$line"
    echo $path
    fileName=`basename $path`
    filePath=`dirname $path`
    # echo $fileName
    # echo $filePath
    sed '/..\/vestsign.api.js/d' ./$filePath/$fileName > ./temp/$fileName
    mv ./temp/$fileName ./$filePath/$fileName
done < resultFile.txt

rm -rf resultFile.txt
rm -rf ./temp

```
