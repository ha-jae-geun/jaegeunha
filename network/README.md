
## NAT
* it makes it own network. Nat is a tool to make communicate with inside and outside 

## Bridge
* it gives personal IP address. So i need a lot of ip addresses

## Socket
* Rdp, Spice, UXP protocol
* when session is running, they communicate authentication to each other
* http is kind of socket

## router
* DHCP, DNS

## wifi
* DHCP, DNS, switch

## UNC Route
* [Network](http://miniyo78.tistory.com/entry/UNC-%EA%B2%BD%EB%A1%9C)

## Netbios
* Computer properties -> change name -> detail
* Only in Window OS


##Socket
* Internet Connect

### IP
* to stay the network structure
* Give ip address > set route to node that i want
* unreliability and connectionlessness

### TCP/IP
[TCP]('https://www.youtube.com/watch?v=8Ql1l048MD8&list=PLVsNizTWUw7GZy4UA9pntGRC9IIXIYiHm&index=3')
*  TCP is on IP
* physical -> internet -> transport -> application
* Ethernet Protocol <> IP Protocol <> TCp Protocol <> HTTP Protocol
* Socket is on the transport
  - Kernel - driver - network card - network card - kernel
  - BSD socket 
  - connect softwares
  - Create socket -> give port > connect ip/port
  - Socket server: socket() > bind > listen > accept > send > recv
  - Socket client: socket() >                connect > recv > send > close
* ethernet ->     ip   ->    TCP    ->    Web server
* It provides communication function between processes
* Threeway handshake, based on flow
* cons: low performance, hard to stay data continuity -> reliability is more important
* segment

### UDP
* continuity is more important than reliability -> fast(ex: starcraft)
  - don't care about loss
* High performance
* socket() -> connect() -> sentto()/recvfrom () -> close()
  - connect function can't clarify server. It doesn't perform connect phase