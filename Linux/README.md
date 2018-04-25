#Linux
---

[TOC]
  


##Command 
 
  ###man: 1~7

  ###vi
   *copy: yy
   *paste: p / P
   *find: /__ + enter

  ###mv 
   *move file
   *change the name

  ###mkdir
    *mkdir -p  // if there is no parent directory, create it

  ###head

  ###tail

  ###more

  ###less

  ###file

  ###adduser, userdel, change

  ###passwd

  ###usermod

  ###groups, groupadd, groupmod, groupdel, gpasswd

  ###chown 
     *chow root test//change owner   
     *chown root.root test

  ###whoami

  ###ln
    *ln linkfile filename // hard link
    *ln -s linkfile filename // soft link
      #if original file is gone, it doensn't work
      #different inode value
    *ls -il // print inode 

##directory
  ###etc
    */etc/passwd //account information
    */etc/shadow // password
    */etc/grooup // groupname:password:groupid:subgroupuser


  ###apt-get  dpkg
    *dpkg has a dependency problem
##cdrom
  *It can't be read and written
  *cdrom = sr0

##mount
  *ubuntu can read only FAT32 file system
  *To see the file, 'ls /media/USB'

##iso
  *dkpg --get-selections genisoimage  // package
  * genisoiamge -r -J -o file


##editor
  *gedit
  *vi
  *cat
  *vim

##File Directory
   *file type  // d: directpry, -: general, b: block divice, c: character divice, l: link
   *permission // user, group, other