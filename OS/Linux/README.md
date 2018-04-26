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


  ###dpkg
    *dpkg has a dependency problem
    *dpkg -i / -r package_name

  ###apt-get
    */etc/apt // this directory get s the address/source.listaz
    *it installs all of packages that include dependency
    *apt-get remove package_name
    *apg-get purge package_name //

  ###find  whereis  which locate
    *find /home -name "*.swp" -exec rm P {}  // 'exec' informs the end of command
  

  ###cron
     *reserve periodic/cyclic work
     *gedic /etc/crontab
     *systemcel restart cron

  ###at
     *Tempoary work

  ###pipe 
    *ls -l /etc | less

  ###filter
     *grep, tail, wc, sort, awk, sed
     *ps -ef | grep bash

  ###redirection
     *ls -l > list.txt
     *ls -l >> list.txt
     *sort < list.txt
     *sort < list.txt > out.txt

##network
  *cat /etc/network/interfaces
  *vi /etc/sysconfig/network/ifcfg-eth0  // IPADDR, NETMASK
  *vi /etc/sysconfig/network  // GATEWAY
  *dhclient -v
  *ifcfg ens32
  *systemctl start/stop/restart/status networking = /etc/init.d/network restart
  
  ###DNS
  *nslookup // check out the DNS server's operation
  */etc/resolv.conf   /etc/network/interfaces
  */etc/hosts  // hostname and FQDN
  *127.0.0.1 // /etc/NETworkManager/syste-mconnections/wire_connection

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

##extraction
   *xz
   *bzip2
   *gzip
   *zip / unzip

##compression
   *tar
