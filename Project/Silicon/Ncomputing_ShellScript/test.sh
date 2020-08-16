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


