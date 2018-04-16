f = open("C:\\Users\\jaegeun\\Desktop\\jaegeun.xml", 'r')
line = f.read()
count = list(line)
print(len(count))
print(count)

i=158

while i < len(count):
    if count[i] == '<':
      i=i+1
      while count[i] != '/' and count[i] != ' ' and count[i] != '>':
        print(count[i], end="")
        i=i+1
      tag[k] = count[i:j]
      k=k+1
      print("")
    elif(count[i] == ' '):
        i=i+1
        if count[i] != '>':
            while(count[i] != '>'):
                 print(count[i] , end="")
                 i=i+1
            print("")
    elif(count[i] == '/'):
        while(count[i] != '>'):
            i=i+1
        i=i+1
        print("")
        continue
    elif(count[i] != '<'):
        if(count[i] != '<'):
            while(count[i] != '<'):
                if(count[i] != '>'):
                    print(count[i], end="")
                    i = i+1
                else:
                    i=i+1
            print("")
        else:
            i = i+1
            continue
    else:
        i=i+1
        print("")
        continue
f.close()
