#Linux
# 리눅스
* 무료고 오픈소스라서 다양한 소프트웨어가 돌아감
* 콘솔에서 소프트웨어 설치 가능
* 코드는 오픈소스 무료이고 깃허브에서 코드 볼수 있고 파일을 커스터마이징 가능
* 아마존 서버는 리눅스 서버에서 돌아감
* 리눅스는 무료 소프트웨어 위주이기 때문에 좋은 소프트웨어가 

# [리눅스 메모리 관리](https://www.youtube.com/watch?v=OPdjLaW0flU)
# [리눅스 파일 시스템](https://www.youtube.com/watch?v=oeuVjeeoLSQ)


## 안전모드
* 싱글모드


[TOC]

---

# 쉘
* 고수준으로 쓰인 소스 코드를 기계어로 번역하는 프로그램인 컴파일러와 달리 인터프리터 방식으로 한줄씩 읽고 해석
  
## #Linux User 2018
  1. Elementary OS
  2. Linux Mint
  3. Arch Linux 
  4. Ubuntu
  5. Tails
  6. CentOS


## SSh <> Telnet <> VNC
  1. apt-get install openssh-server 
  2. systemctl restart ssh / sysstemctl enable ssh / systemctl status ssh
  3. ufw allow 22/tcp   // 22 is ssh's port
  4. ssh 사용자명@서버ip


## network
  * cat /etc/network/interfaces
  * vi /etc/sysconfig/network/ifcfg-eth0  // IPADDR, NETMASK
  * vi /etc/sysconfig/network  // GATEWAY
  * dhclient -v
  * ifcfg ens32
  * systemctl start/stop/restart/status networking = /etc/init.d/network restart
  
## DNS
  * url -> search /etc/host.conf -> /etc/hosts > get ipaddress / access .etc.resolv.conf
  * nslookup // check out the DNS server's operation
  * /etc/resolv.conf   /etc/network/interfaces
  * /etc/hosts  // hostname and FQDN
  * 127.0.0.1 // it means use DNS server in etc/NETworManager/syste-mconnections/wire_connection
  * nm-connection-editor  /etc/network/interfaces

## cdrom
  * It can't be read and written
  * cdrom = sr0

## mount
  * ubuntu can read only FAT32 file system
  * To see the file, 'ls /media/USB'

## iso
  * dkpg --get-selections genisoimage  // package
  *  genisoiamge -r -J -o file


## editor
  * gedit
  * vi
  * cat
  * vim

## File Directory
   * file type  // d: directpry, -: general, b: block divice, c: character divice, l: link
   * permission // user, group, other

## extraction
   * xz
   * bzip2
   * gzip
   * zip / unzip

## compression
   * tar

## file type
* d, -, b: block device(Hard disk, flopy disk, CD/DVD), c, l
* file filename // how to figure out the file type, filename extension doesn't decide filetype


## link
* symblolic: ln -s linktargetfilename linkfilename // like file shortcut
  # it has its own file pointer so inode and file size are different from original file.
  # if origianl file disapperas, it causes a problem
* hardlink: ln linktargetfilename linkfilename 
  # even if original file is deleted, it doesn't cause problem

## firewall 
* ufw // apt-get -y install gufw python -gi

## cron
* /etc/crontab
* systemctl status cron

##at 
* it happens once
------------
  


# Command 
 
## #man: 1~7

## #vi
   * copy: yy
   * paste: p / P
   * find: /__ + enter

## #mv 
   * move file
   * change the name

## #mkdir
    * mkdir -p  // if there is no parent directory, create it

## #head

## #tail

* tail /etc/password  or /etc/shadow

## #more

## #less

## #file

## #adduser, userdel, change

## #passwd

## #usermod

## #groups, groupadd, groupmod, groupdel, gpasswd

## #chown 
* chow root test//change owner   
* chown root.root test

## #whoami

## #ln
* ln linkfile filename // hard link
* ln -s linkfile filename // soft link
  if original file is gone, it doensn't work
  different inode value
*  ls -il // print inode 

## directory
## #etc
* /etc/passwd //account information
* /etc/shadow // password
* /etc/grooup // groupname:password:groupid:subgroupuser


## #dpkg
* dpkg has a dependency problem
* dpkg -i / -r package_name

## #apt-get
* /etc/apt/source.list // apt-get update -> install > upgrade // this directory get s the address/source.listaz
* it installs all of packages that include dependency
* apt-get remove package_name
* apg-get purge package_name //

## #find  whereis  which locate
* find /home -name "* .swp" -exec rm P {}  // 'exec' informs the end of command
  

## #cron
* reserve periodic/cyclic work
* gedic /etc/crontab
* systemcel restart cron

## #at
* Tempoary work

## #pipe 
* ls -l /etc | less

## #filter
* grep, tail, wc, sort, awk, sed
* ps -ef | grep bash

## #redirection
* ls -l > list.txt
* ls -l >> list.txt
* sort < list.txt
* sort < list.txt > out.txt

