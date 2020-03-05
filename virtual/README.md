
# 순서
0. 클러스터링
1. CPU, 램, C드라이브
2. 네트워크 NAT, 브릿지
3. 액티브 디렉터리
4. 운영체제 종류
5. 세션(자동 종료)
6. 커넥션 풀
7. 쉘 스크립트

# 쉘 스크립트
```java
#!/bin/sh

#Network Configuration
echo "-------------------------------------------"
echo "-----------VERDE Server Setting------------"
echo "-------------------------------------------"
echo "network setting? (y/n)"
read -r answer

# ip setting 유무 파악
if [ "$answer" = 'y' ] || [ "$answer" = 'Y' ];  then
touch /home/onboot.txt
touch /home/onboot1.txt
touch /home/onboot2.txt
touch /home/ip.txt
touch /home/netmask.txt
touch /home/gateway.txt
touch /home/gateway1.txt

#/home/onboot.txt에 기존의 네트워크 스크립트 복사
cp -r /etc/sysconfig/network-scripts/ifcfg-eth0 /home/onboot.txt

#해당 행을 삭제한 후 새로운 행을 추가한다.
sed '/ONBOOT/d' </home/onboot.txt > /home/onboot1.txt
echo "ONBOOT=yes" >> /home/onboot1.txt

sed '/BOOTPROTO/d' < /home/onboot1.txt > /home/onboot2.txt
echo "BOOTPROTO=static" >> /home/onboot2.txt

#ip를 입력받음
echo "ip를 입력하세요"
read -r server_IP

#서브넷마스크 입력받음
echo "서브넷마스크를 입력하세요"
read -r server_netmask

#게이트웨이 입력받음
echo "게이트웨이 주소를 입력하세요"
read -r server_gateway


#ip, netmask, gateway 행 삭제 후 다시 추가.
sed '/IPADDR/d' </home/onboot2.txt > /home/ip.txt
echo 'IPADDR='"$server_IP" >> /home/ip.txt

sed '/NETMASK/d' </home/ip.txt > /home/netmask.txt
echo 'NETMASK='"$server_netmask" >> /home/netmask.txt

cp -r /home/netmask.txt /etc/sysconfig/network-scripts/ifcfg-eth0 

cp /etc/sysconfig/network /home/gateway.txt
sed '/GATEWAY/d' </home/gateway.txt > /home/gateway1.txt
echo 'GATEWAY='"$server_gateway" >> /home/gateway1.txt

cp -r /home/gateway1.txt /etc/sysconfig/network


#쓰였던 txt 파일 모두 삭제
rm -r /home/onboot*.txt
rm -r /home/ip.txt
rm -r /home/netmask.txt
rm -r /home/gateway*.txt

#네트워크 재시작
/etc/init.d/network restart

#dhcp 서버로부터 동적으로 nameserver 할당받음

dhclient

fi

sleep 3

#Yum update
echo "--> Updating CentOS System"
yum -y update
sleep 3

#yum install
yum --enablerepo=updates --enablerepo=base --assumeyes install java-1.8.0-openjdk.x86_64
yum --enablerepo=updates --enablerepo=base --assumeyes install gtk2
yum --enablerepo=updates --enablerepo=base --assumeyes install zip unzip
yum --enablerepo=updates --enablerepo=base --assumeyes install ntpdate ntp-doc
sleep 3

#ntpd
chkconfig ntpd on
/etc/init.d/ntpd start
sleep 3

#user
useradd vb-verde
echo "-------input password"
passwd vb-verde 
usermod -G root vb-verde
sleep 3

#create /etc/security/limits.d/95-verde.conf
echo "-proc -1" > /etc/security/limits.d/95-verde.conf
echo "-nofile 65535" >> /etc/security/limits.d/95-verde.conf
sleep 3

#change java version
sudo update-alternatives --config java-1
sleep 3

#iptables
/etc/init.d/iptables stop
chkconfig iptables off
sleep 3

#modify selinux state
sed 's/SELINUX=enforcing/SELINUX=disabled/' /etc/sysconfig/selinux >/home/selinux.txt
cp -r /home/selinux.txt /etc/sysconfig/selinux
rm -r /home/selinux.txt
sleep 3

#install VERDE rpm
echo "USB를 넣어주세요."
var1=$(fdisk -l | grep Disk | grep /dev/sd | tail -1 | awk '{print $2}')
var2=`echo $var1 | cut -c1-8`
mkdir /mnt/usb
mount $var2 /mnt/usb
find -iname VERDE-*.rpm | yum --nogpgcheck install VERDE-*.rpm
sleep 3
#yum --nogpgcheck install /mnt/usb/VERDE*.rpm


#VERDE configuration
/usr/lib/verde/bin/verde-config -i


#if [ grep -i ONBOOT='no' /etc/sysconfig/network-scripts/ifcfg-eth0 ];
#value1=$(grep -i ONBOOT= /etc/sysconfig/network-scripts/ifcfg-eth0)
#then sed "s/ONBOOT='yes'/ONBOOT='no'/" /etc/sysconfig/network-scripts/ifcfg-eth0 > /home/onboot.txt
#cp -r /home/onboot.txt /etc/sysconfig/network-scripts/ifcfg-eth0

#-------------------
# #!/bin/sh
# value1=$(grep -i ONBOOT /etc/sysconfig/network-scripts/ifcfg-eth0)
# value2=$(grep -i BOOTPROTO /etc/sysconfig/network-scrpits/ifcfg-eth0)
# if [ "$value1 = ONBOOT='no'" ];
# then sed "s/ONBOOT='no'/ONBOOT='yes'/" /etc/sysconfig/network-scripts/ifcfg-eth0 > /home/onboot.txt
# if [ "$value1 = ONBOOT=no" ];
# then sed "s/ONBOOT=no/ONBOOT=yes/" /etc/sysconfig/network-scripts/ifcfg-eth0 > /home/onboot.txt
# fi

#------------------
#!/bin/sh
# value1=$(grep -i ONBOOT /etc/sysconfig/network-scripts/ifcfg-eth0)
# value2=$(grep -i BOOTPROTO /etc/sysconfig/network-scripts/ifcfg-eth0)
# if [ "$value1 = ONBOOT='[Nn][Oo]'" ];
# then sed "s/ONBOOT='no'/ONBOOT='yes'/" /etc/sysconfig/network-scripts/ifcfg-eth0 > /home/onboot.txt
# fi
# if [ "$value1 = ONBOOT=[Nn][Oo]" ];
# then sed "s/ONBOOT=no/ONBOOT=yes/" /etc/sysconfig/network-scripts/ifcfg-eth0 > /home/onboot.txt
# fi

# if [ "$value2 = BOOTPROTO='[Dd][Hh][Cc][Pp]'" ];
# then sed "s/BOOTPROTO='DHCP'/BOOTPROTO='static'/" /home/onboot.txt > /home/onboot2.txt
# fi
# if [ "$value2 = BOOTPROTO=[Dd][Hh][Cc][Pp]" ];
# then sed "s/BOOTPROTO=DHCP/BOOTPROTO=static/" /home/onboot.txt > /home/onboot2.txt
# fi
#------------------
#!/bin/sh

# touch /home/onboot.txt
# touch /home/onboot1.txt
# touch /home/onboot2.txt
# cp -r /etc/sysconfig/network-scripts/ifcfg-eth0 /home/onboot.txt

# sed '/ONBOOT/d' </home/onboot.txt > /home/onboot1.txt
# echo "ONBOOT=yes" >> /home/onboot1.txt

# sed '/BOOTPROTO/d' < /home/onboot1.txt > /home/onboot2.txt
# echo "BOOTPROTO=static" >> /home/onboot2.txt


# echo "ip를 입력하세요"
# read -r user_IP

# echo "서브넷마스크를 입력하세요"
# read -r user_netmask


# echo 'IPADDR='"$user_IP" >>/home/onboot2.txt
# echo 'NETMASK='"$user_netmask" >>/home/onboot2.txt

# cp -r /home/onboot2.txt /etc/sysconfig/network-scripts/ifcfg-eth0 
#------------------
```

# Active Directory
*  마이크로소프트가 윈도우용 환경에서 사용하기 위해 개발한 LDAP 디렉터리 서비스의 기능이다. 주 목적은 윈도우 기반의 컴퓨터들을 위한 인증 서비스를 제공하는 것이다. 주로 윈도우 환경에서 동일한 데이터베이스를 사용하여 다음을 비롯한 다양한 네트워크 서비스를 제공한다.

```java
User Service

Active Directory에 사용자에 대한 각종 프로필(계정, 패스워드, 메일주소, 전화번호, 부서, 직급, 등)을 
등록하여 주소록 서비스, 계정기반 서비스를 제공합니다.

•내 PC에서 로그인 하던 계정을 타 PC에서 계정 생성 없이 로그인이 가능합니다. 로그인할 경우 기존에 사용하던
PC와 동일한 바탕화면을 제공합니다.

•Windows 기반 Service와 관련된 계정 기반 로그인을 통합하여 사용하고 주소록을 제공합니다.


Policy Service
•Active Directory에 등록된 Windows Server, Client에 대해 각종 정책을 적용할 수 있습니다.

•5분동안 Computer를 사용하지 않을 시 화면보호기를 실행

•Windows Time server를 강제로 지정

•각종 프로그램 자동배포 및 설치

•Windows Server와 Client간의 방화벽 정책 할당



Connection Service
•Windows Service에 따른 Replication 설정 시 Server와 Server간의 연결

•Exchange Server 구축 시 Active Directory와 연결하여 사용자 정보 및 사용자 권한 연동


 


위와 같이 Active Directory는 Windows 기반 Service에 대하여 다양하게 중앙집중관리를 할 수 있습니다.


Active Directory 도입 시 고려사항

Active Directory의 중앙집중관리는 먼저 Windows Server, Client, 각종 Device 들이
Active Directory Domain에 가입(Join)되어야 할 수 있습니다.

즉, "내 PC"에서 로그인 하던 계정을 "다른 PC"에서 계정생성 없이 기존 사용하던 그대로의 
환경을 가지고 로그인하고 싶다면 "내 PC"와 "다른 PC" 모두 Active Directory Domain에 가입되어 있어야 합니다.



Active Directory Domain에 가입하려면 Window Server, Client, 각종 Device들의 DNS 서버를 
Active Directory 서버로 변경해야합니다.

Active Directory에는 DNS 기능도 같이 포함하고 있습니다. (물론 별도의 DNS 서버도 구축 가능합니다.)



Device들의 DNS를 변경해야 되는 이유는 Active Directory Server를 찾아 Domain에 가입해야되는 
부분과 향후 Windows Server들이 가입(Join)되어 Service를 운영할 때 Deivce들이 원활히 Domain내에서 
제공하는 Windows Service를 찾을 수 있도록 하기 위함입니다.


Active Directory에는 무수히 많은 Service가 연결되기 때문에 Active Directory에 장애가 생길 경우 
그만큼 많은 Service에 대해서 영향을 줄 수 있습니다.

따라서 여러 Active Directory Domain을 구성하여 Service와 역할을 나누어 관리하는 등 다양한 고민과 
효율적인 사용전략이 필요합니다.



그 이외에도 생각지 못한 고려사항이 많겠지만 환경과 상황에 따라 달라지므로 여기서 마치겠습니다.
```

## LDAP
* 경량 디렉터리 액세스 프로토콜(영어: Lightweight Directory Access Protocol; LDAP)은 TCP/IP 위에서 디렉터리 서비스를 조회하고 수정하는 응용 프로토콜이다.
* 터리는 논리, 계급 방식 속에서 조직화된, 비슷한 특성을 가진 객체들의 모임이다. 가장 일반적인 예로는 전화 번호부(telephone directory)가 있는데 가나다 순의 일련의 이름을 가지고 있고, 이름마다 전화 번호와 주소가 포함되어 있다. 이러한 기본 설계 때문에 LDAP는 인증을 위한 다른 서비스에 의해 자주 사용된다.
* LDAP 디렉터리 트리는 선택된 모델에 따라 다양한 정치적, 지질학적, 조직적 경계를 반영하기도 한다. 오늘날 LDAP의 배치는 최상위 수준의 계급을 구조화하기 위해 도메인 이름 서비스의 이름을 사용하는 경향이 있다. 디렉터리 안에 들어가면 들어갈수록 사람들, 조직, 프린터, 문서, 그룹 등을 대표하는 항목들이 나타난다.

## NAT
* [NAT]('https://sksstar.tistory.com/m/5')
```java
이 방식은 A가 VM에게 IP를 주는 방식으로써
A와 VM끼리 통신이 가능하고 A가 인터넷이 된다면 자동으로 VM도 무리없이 인터넷이 가능하다.
그러나 B와 C는 VM에게 접속이 불가능하다.
개인용 노트북에 테스트용으로 설치를 할 때는 이 방식으로 해도 무난하다. (DHCP)
단, 다른 컴퓨터에서는 해당 VM에 접속을 하지 못한다는 것을 알아두자.
```

## 브릿지
* 이 방식은 공유기가 VM에게 IP를 주는 방식으로써
* VM에게 있어 A는 단지 다리역할 뿐 공유기는 VM도 하나의 딸린 PC로 보기 때문에 개별적으로 IP를 할당 받는다.
* 따라서 A뿐만 아니라 B, C도 또한 VM과 통신이 가능하다.

# 소켓 채팅 프로그램

# NComputing
## Ncomputing 제품 장점
```java
1. 구매
초기 도입비용 절감효과
기존의 보통 PC를 대체하여 도입하는 경우 약 70% 정도의 비용 절감효과를 누릴 수 있습니다.


IT 예산의 효율적인 가성비 제공
서버기반의 SBC 데스크톱 솔루션은 H/W 업그레이드 및 S/W 라이선스 예산에 대한 가성비를 높여 줍니다.


사용자 예산 맞춤형

- 완전한 가상화 데스크탑 솔루션을 PC 가격의 절반도 안 되는 비용으로 도입할
수 있으며 지속적인 관리 비용의 75% 및 사용 전력의 90% 를 절약

2. 설치
간편한 설치

- 원거리 지사에서 4대의 워크스테이션이 필요하든, 본사에서 4천대의
워크스테이션이 필요하든, L300은 vSpace 관리 콘솔을 이용하여 손쉽게 설치할
수 있습니다.


3. 로그인 화면
용이한 관리

- 한번 설치하고 나면 장치 상에서 관리해야 하는 어플리케이션, 소프트웨어
또는 드라이버가 따로 필요 없습니다. vSpace 소프트웨어가 모든 펌웨어 변경을
중앙에서 관리 및 처리해주기 때문에 사용자의 추가 관리가 전혀 필요 없습니다.


4. 게임
전기료의 대폭 절감
100W 이상을 사용하는 일반 PC와 비교할 때 제로 클라이언트는 겨우 5W만 사용하므로 발열량이 적음은 물론, 최
대 1/20 이상의 전력 절감과 실내 공기의 상태를 좋게 합니다.


5. 고장
클라이언트 유지보수 최소화
일반 PC와 달리, 고정된 단일 하드웨어로 된 제로클라이언트는 잔 고장이 거의 없으며 유지관리비용이 현저히 줄
어듭니다.


6. 업체
시스템 도입주기 연장
간단한 하드웨어로 구성된 제로클라이언트는 공공장소나 공장 또는 실습실 등 불특정 다수가 사용하는 컴퓨팅 장
소에서 사용할 때 더 많은 사용기간을 제공할 수 있습니다. 노후화가 더디게 진행되므로 PC교체 주기를 길게 해주
는 효과는 물론, 시스템 재구축 및 재설정 시 그 기간을 몇 주에서 몇 시간으로 단축시켜 드립니다


안정적인 시스템 작동– PC와 같은 고장이 쉬운 부품들을 사용하지 않는 제로 클라이언트 기기를 이용하므로 시스템
다운타임이 거의 없습니다. 또한, 고장이 있는 경우에도 바로 교체 후 연결하여 사용할 수 있습니다.


7. 설명
바이러스 감염 차단– 제로클라이언트에는 OS가 없기 때문에 항상 엔드포인트 보안을 제공합니다.


보안 정책 및 모니터링– IT 관리자의 엔드유저 보안정책, 사용자 모니터링 그리고 원격 사용자의 로그인을 차단하
거나 로컬 PC에 연결된 USB 주변기기를 차단하여 데이터를 복사, 이동하는 것을 차단할 수 있습니다.


데이터 유출 차단– 제로클라이언트에는 데이터가 저장되지 않으므로 사용자는 제로클라이언트 고장, 분실에 따
른 데이터 유출이 없습니다

```

## 제로 클라이언트
```java
제로 클라이언트는 중앙처리장치(CPU), 메모리, 하드디스크 등과 같이 PC의 구동부가 없으며, 
이더넷 연결단자, 키보드 단자, 마우스 연결단자, 파워단자, VGA 연결단자로만 구성되어 순전히 서버 자원만 활용하는 
일명 '깡통 PC'의 클라이언트 단말기를 지칭합니다.

따라서, 제로 클라이언트 자체만으로는 작업이 불가능하며, 데스크톱 가상화(VDI) 기술을 이용해 중앙 서버에 접속하여 
입출력을 처리하고 여러 작업을 할 수 있습니다.
```

## thin client
 CPU, 메모리 등 필수적인 하드웨어 장치만 탑재해 네트워크로 연결된 중앙서버에서 모든 업무를 관리하도록 설계된 업무용 PC를 일컫는다.

# 가상화 종류
```java
• Virtual Desktop Infrastructure (VDI)
 보통 알고 있는 데스크톱 가상화. 하나 또는 둘 이상의 서버에 “Virtual OS + Application”을 올려 사용자와 1:1로 서비스 하는 형태
특징으로는 OS와 사용자의 관계가 1:1로 Thin Client 또는 Zero Client 단말기로 접속하거나 별도의 Software로 접속하는 형태

• Server-based Computing (SBC)
하나의 OS에 다수의 응용프로그램을 운용, 서버와 사용자의 연결 관계는 1:N 형태, Thin Client 또는 Zero Client 단말기로 접속하거나
별도의 Software로 접속하여 사용하는 환경

• Client Based Computing (CBC)
 사용하고 있는 Desktop 위에 별도의 Virtual Desktop을 운영하거나 Desktop 자체를 Virtual OS로 부팅하여 사용하는 환경으로 Server
Based Computing과 Virtual Desktop 환경을 혼합 운영할 수 있는 서비스 환경
```

# Active Directory

# terminal session
* 쪼개지 않고 직접적으로 하드웨어로 접근 가능하여 성능 차이 없음.  
  ^There is no performance difference because it can be directly accessed by hardware without splitting.




# 로드밸런싱(Load Balancing)
```java
로드밸런싱은 부하 분산을 위해서 가상IP를 통해 여러 서버에 접속하도록 분배하는 기능
하나의 서비스에 발생하는 트래픽이 많을 때, 여러 대의 서버가 분산처리하여 서버의 로드율 
증가/부하량/속도저하를 고려해서 적절히 요청을 분산시켜주는 서비스
동시에 오는 수많은 커넥션을 처리하고, 해당 커넥션이 요청 노드 중의 하나로 분산되어 전달하는 것
대용량 서비스를 운영하기위해서 로드밸런싱은 필수

NAT : 
priavate IP를 public IP로 변환하는 주소 변조기

DSR : 
로드밸런서 사용 시 서버에서 클라이언트로 되돌아 갈때, 목적지 주소를 스위치 IP가 
아닌 클라이언트 IP로 전달해 네트워크 스위치를 거치지 않고 바로 클라이언트로 찾아가는 개념


Tunneling : 
네트워크 상에 눈에 보이지 않는 통로를 만들어 통신할 수 있게하는 개념,
로드밸런서를 사용하면 세션 데이터 관리하는게 쉽지 않다
매 요청마다, 다른 서버로 접근하기 때문에, 정보 일관성 유지가 힘듬
세션 고정이 필요하다, 특정 사용자의 요청이 전달될 노드를 고정시키는 방법이 존재하지만, 
해당 노드에서 장애가 발생하면 고정이 의미가 없다.
```

# 클러스터링
```java
여러 개의 컴퓨터를 연결한 병렬 시스템으로 마치 하나의 컴퓨터처럼 사용하는것을 클러스터라고 한다
클러스터링 환경에서는 특정 장비에 문제가 생기거나 특정 장비에서 실행중인 applicaiton에 문제가 발생해도 전체 서비스에 영향 x
Virtual IP를 기반으로 구현된다.
서비스를 제공하는 실제 장비만 ip를 갖고, 데이터 처리는 virtual ip를 통해서 이루어진다.
내부 시스템은 철저히 숨긴다.
최근에 등장한, 컨테이너 오케스트레이션 도구인 'kubernetes'또한 클러스터링을 통해서 컨테이너를 관리해준다.

결론
로드밸런싱,클러스터링 모두 Scale-Out 방식으로 성능을 향상시킨다. 
Scale-up방식에 비해서 저렴하게 성능을 업그레이드할 수 있고 서버장애가 발생하더라도 
중단 없이 다른 서버로 적절히 요청을 분산시켜서 무중단 운영이 가능하다.
```

## Scale-up, out
1. 스케일 아웃(Scale out)
```java
(1) 정의
접속된 서버의 대수를 늘려 처리 능력을 향상시키는 것이다. 수평 스케일로 불리기도 한다. 
전형적으로는 웹 서버 펌으로서 사용되고 있는 랙 마운트 서버군에 서버를 추가하는 것이나 브레이드 서버에 
브레이드를 추가하는 것 등이다. 서버의 가상화 기능을 사용하고 하나의 케이스 내에서 가상적으로 
복수 서버를 구축해 스케일 아웃과 동등의 효과를 제공할 수도 있다. 
이러한 방식을 특히 스케일 위드인 또는 가상 스케일 아웃 등으로 부르기도 한다. 


(2) 적용
개개의 처리는 비교적 단순하지만 다수의 처리를 동시 병행적으로 실시하지 않으면 안 되는 경우에 적합한데 
갱신 데이터의 정합성(데이터가 서로 모순 없이 일관되게 일치해야 하는 경우) 유지에 대한 요건이 별로 어렵지 않은 경우에 적절하다. 
즉 높은 병렬성을 실현하기 쉬운 경우이다. 웹 서버 펌, 데이터가 읽기 전용인 검색엔진 데이터 분석 처리 VOD(주문형 비디오) 
일부의 과학기술 계산, 메일 서버나 게시판 등의 어플리케이션 등에 적용할 수 있다. 

```

## Scale-out 특징
```java
 
확장성 

* 하나의 장비에서 처리하던 일을 여러 장비에 나눠서 처리할 수 있도록 설계를 변경하는 것. 수평 확장. 지속적 확장이 가능 
* 더 빠른 속도의 CPU로 변경하거나, 더 많은 RAM을 추가하는 등의 하드웨어 장비의 성능을 높이는 것. 
수직 확장. 성능 확장에 한계가 있음 

서버 비용 
* 비교적 저렴한 서버를 사용하므로 일반적으로 비용 부담이 적음 
* 성능 증가에 따른 비용 증가폭이 크며, 일반적으로 비용 부담이 큼 


운영 비용 

* 대수가 늘어날수록 관리 편의성이 떨어지며, 서버의 상면 비용을 포함한 운영 비용이 증가함 
* 관리 편의성이나 운영 비용은 스케일 업에 따라 큰 변화 없음 


장애 
* 읽기/쓰기가 여러대의 서버에 분산되어 처리됨으로 장애 시 전면 장애의 가능성이 적음 
* 한대의 서버에 부하가 집중되므로 장애 시 장애 영향도가 큼 

주요 기술
(App 관점)

* Sharding, Query-off Loading, Queue, In Memory Cache,
* NoSQL, Object Storage, Distributed Storage
* 고성능 CPU, Memory 확장, SSD

주요 용도
장/단점
* 분산처리 시스템/Global 웹 어플리케이션, 점진적 증가 가능, 보통 스케일 업보다 저렴, 설계/구축/관리 비용 증가 
```

2. 스케일 업(Scale up)
```java
(1) 정의
서버 그 자체를 증강하는 것에 의해서 처리 능력을 향상시키는 것이다. 수직 스케일로 불리기도 한다. 
전형적으로는 SMP(대칭형 멀티 프로세서)에 대해 프로세서를 추가하는 것이나 프로세서 그 자체를 고성능 모델로 옮겨놓는 것을 가리킨다.


(2) 적용
어플리케이션 서버에서는 스케일 아웃이 가능해도 빈번히 갱신이 발생하여 정합성(데이터가 서로 모순 없이 일관되게 일치해야 하는 경우) 
유지가 어려운 데이터베이스 서버에서는 스케일 업이 필요하다. 즉 하나의 이미지 데이타베이스에 대해서 빈번히 갱신이 발생하는, 
이른바 OLTP(온라인 트랜잭션 처리)에는 스케일 업이 적합하다. 
```


## vm


## RDP

## Spice

# 가상화 업체 VDI 개발 현황
 
## 가. Citrix
- Citrix의 XenDesktop은 XenServer를 이용하여 공용 또는 전용 VM(Virtual Machine)을 제공하며, 사용자 단말에서 구동되는 XenClient나 스트리밍 VHD(Virtual Hard Disk) 방식을 지원하는 XenApp을 이용한 원격 또는 스트리밍 방식을 지원한다.
 
## 나. VMware
- VMware의 VMware View는 서버 가상화 기술인 vSphere와 통합되어 RDP과 PCoIP 원격 디스플레이 프로토콜을 지원한다. 또한 오프라인으로 가상 데스크톱을 사용할 수 있는 로컬 모드 View는 온라인 가상 데스크톱과 동기화시키는 방식을 사용한다.
 
## 다. Microsoft
- Microsoft는 가상화 플랫폼인 Hyper-V에 RDS(Remote Desktop Services)와 RDVH(Remote Desktop Virtualization Host)를 통합하고 원격 디스플레이 프로토콜로는 RDP를 지원해 가상 데스크톱 인프라 기술을 제공한다.
 
## 라. Oracle
- Oracle에서는 가상 데스크톱 인프라 기술로 Sun Ray 가상 데스크톱 세션 관리 기술과 가상화 플랫폼인 Oracle VDI 하이퍼바이저 기술을 개발하였다. Oracle의 기술은 VMware vCenter, Microsoft Hyper-V, Microsoft RDS를 지원한다.
 
## 마. 공개 SW
- 공개 SW 커뮤니티 중심의 개발 사례로는 RedHat이 오픈 소스 원격 디스플레이 프로토콜인 SPICE(Simple Protocol for Independent Computing Environments)를 데스크톱 가상화에 적용하였으며, Ulteo에서는 Debian과 Ubuntu 기반의 오픈 소스 VDI 솔루션을 제공한다. 
CloudStack.com은 클라우드 IaaS(Infrastructure as a Service) 플랫폼 솔루션을 통한 VDI 클라우드 인프라 구축을 지원하고 있다.

