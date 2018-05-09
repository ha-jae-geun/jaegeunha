#!/bin/sh

echo "-------------------------------------------"
echo "-----------VERDE Server Setting------------"
echo "-------------------------------------------"
echo "network setting? (y/n)"
read -r answer

if [ "$answer" = 'y' ] || [ "$answer" = 'Y' ];  then
touch /home/onboot.txt
touch /home/onboot1.txt
touch /home/onboot2.txt
touch /home/ip.txt
touch /home/netmask.txt
touch /home/gateway.txt
touch /home/gateway1.txt

cp -r /etc/sysconfig/network-scripts/ifcfg-eth0 /home/onboot.txt

sed '/ONBOOT/d' </home/onboot.txt > /home/onboot1.txt
echo "ONBOOT=yes" >> /home/onboot1.txt

sed '/BOOTPROTO/d' < /home/onboot1.txt > /home/onboot2.txt
echo "BOOTPROTO=static" >> /home/onboot2.txt

echo "Input IP"
read -r server_IP

echo "Input Subnet Mask"
read -r server_netmask

echo "Input Gateway"
read -r server_gateway


sed '/IPADDR/d' </home/onboot2.txt > /home/ip.txt
echo 'IPADDR='"$server_IP" >> /home/ip.txt

sed '/NETMASK/d' </home/ip.txt > /home/netmask.txt
echo 'NETMASK='"$server_netmask" >> /home/netmask.txt

cp -r /home/netmask.txt /etc/sysconfig/network-scripts/ifcfg-eth0 

cp /etc/sysconfig/network /home/gateway.txt
sed '/GATEWAY/d' </home/gateway.txt > /home/gateway1.txt
echo 'GATEWAY='"$server_gateway" >> /home/gateway1.txt

cp -r /home/gateway1.txt /etc/sysconfig/network


rm -r /home/onboot*.txt
rm -r /home/ip.txt
rm -r /home/netmask.txt
rm -r /home/gateway*.txt

/etc/init.d/network restart


dhclient

fi

sleep 3

echo "--> Updating CentOS System"
yum -y update
sleep 3

yum --enablerepo=updates --enablerepo=base --assumeyes install java-1.8.0-openjdk.x86_64
yum --enablerepo=updates --enablerepo=base --assumeyes install gtk2
yum --enablerepo=updates --enablerepo=base --assumeyes install zip unzip
yum --enablerepo=updates --enablerepo=base --assumeyes install ntpdate ntp-doc
sleep 3

chkconfig ntpd on
/etc/init.d/ntpd start
sleep 3

useradd vb-verde
echo "-------input password"
passwd vb-verde 
usermod -G root vb-verde
sleep 3

echo "-proc -1" > /etc/security/limits.d/95-verde.conf
echo "-nofile 65535" >> /etc/security/limits.d/95-verde.conf
sleep 3

sudo update-alternatives --config java-1
sleep 3

/etc/init.d/iptables stop
chkconfig iptables off
sleep 3

sed 's/SELINUX=enforcing/SELINUX=disabled/' /etc/sysconfig/selinux >/home/selinux.txt
cp -r /home/selinux.txt /etc/sysconfig/selinux
rm -r /home/selinux.txt
sleep 3

echo "USB를 넣어주세요."
var1=$(fdisk -l | grep Disk | grep /dev/sd | tail -1 | awk '{print $2}')
var2=`echo $var1 | cut -c1-8`
mkdir /mnt/usb
mount $var2 /mnt/usb
find -iname VERDE-*.rpm | yum --nogpgcheck install VERDE-*.rpm
sleep 3