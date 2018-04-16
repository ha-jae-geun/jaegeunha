f = open("C:\\Users\\jaegeun\\Desktop\\parsertext.xml", 'r')

#def count(C:\\Users\\jaegeun\\Desktop\\parsertext.xml):
#    lines = 0
#    for line in open(filename):
#        lines += 1
#    return lines

line = f.read()
count = line.split('/>')
print(count)
#print(count[0:3]
#print(len(count[0]), len(count[1]))


j=0
k=0
x=0
while j<=100:
    i=0
    chr = count[k]
    if(chr[i] == "<"):
        while(i < len(chr)):
            print(chr[i] , end="")
            i = i+1
            j = j+1
            k = k+1
        continue
    elif(chr[i] == "<" and chr[i+1] == "/"):
        while(i < len(chr)):
            i = i+1
            j = j+1
            k = k+1
        continue
    else:
        while(i < len(chr)):
            print(chr[i])
            i = i+1
            j = j+1
            k = k+1
f.close()
