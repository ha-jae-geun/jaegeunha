#!/bin/sh
echo "-------------------------------------------"
echo "-----------VERDE Server Setting------------"
echo "-------------------------------------------"
echo "network setting? (y/n)"
read -r answer

# ip setting
if [ "$answer" = 'y' ] || [ "$answer" = 'Y' ];  then
touch /home/onboot.txt
touch /home/onboot1.txt
touch /home/onboot2.txt
touch /home/ip.txt
touch /home/netmask.txt
touch /home/gateway.txt
touch /home/gateway1.txt

#copy origianl network scripts to /home/onboot.txt
cp -r /etc/sysconfig/network-scripts/ifcfg-eth0 /home/onboot.txt

#delate certain row and append
sed '/ONBOOT/d' </home/onboot.txt > /home/onboot1.txt
echo "ONBOOT=yes" >> /home/onboot1.txt

sed '/BOOTPROTO/d' < /home/onboot1.txt > /home/onboot2.txt
echo "BOOTPROTO=static" >> /home/onboot2.txt

# IP 
echo "IP"
read -r server_IP

# SUBNETMASK
echo "SUBNET"
read -r server_netmask

# GATEWAY
echo "GATEWAY"
read -r server_gateway


#ip, netmask, gateway delate and append
sed '/IPADDR/d' </home/onboot2.txt > /home/ip.txt
echo 'IPADDR='"$server_IP" >> /home/ip.txt

sed '/NETMASK/d' </home/ip.txt > /home/netmask.txt
echo 'NETMASK='"$server_netmask" >> /home/netmask.txt

cp -r /home/netmask.txt /etc/sysconfig/network-scripts/ifcfg-eth0 

cp /etc/sysconfig/network /home/gateway.txt
sed '/GATEWAY/d' </home/gateway.txt > /home/gateway1.txt
echo 'GATEWAY='"$server_gateway" >> /home/gateway1.txt

cp -r /home/gateway1.txt /etc/sysconfig/network


#delate all txt
rm -r /home/onboot*.txt
rm -r /home/ip.txt
rm -r /home/netmask.txt
rm -r /home/gateway*.txt

#restart network
/etc/init.d/network restart

#allocated nameserver from DHCP
dhclient

fi

sleep 3


#yum update
yum -y update

sleep 3


#install what we need
yum --enablerepo=updates --eanblerepo=base --assumeyes install java-1.8.0-openjdk.x86_64
yum --enablerepo=updates --eanblerepo=base --assumeyes install gtk2
yum --enablerepo=updates --eanblerepo=base --assumeyes install zip unzip
yum --enablerepo=updates --eanblerepo=base --assumeyes install ntpdate ntp-doc

sleep 1

#ntpd on boot
chkconfig ntpd on

/etc/init.d/ntpd start

sleep 1

#create vb-verde Id/password
useradd vb-verde
echo "password?"
passwd vb-verde

#account "vb-verde" make below the root group
usermod -G root vb-verde

sleep 1

echo "-nproc -1" > /etc/security/limits.d/95-verde.conf
echo "-nofile 65535" >> /etc/security/limits.d/95-verde.conf

sleep 1

#confirm java version
sudo update-alternatives --config java

#stop iptable
/etc/init.d/iptable stop

sleep 1

#always off in case of its on boot
chkconfig iptables off

sleep 1

#selinux disabled
sed 's/enforcing/disabled' /etc/sysconfig/selinux > /home/selinux.txt
cp -r /home/selinux.txt /etc/sysconfig/selinux
rm -r /home/selinux.txt

#verde rpm download

echo "usb"
var1=$(fdisk -l |grep Disk | grep /dev/sd | tail -1 |awk '{print $2}')
var2=`echo $var1 | cut -c1-8`
mkdir /mnt/usb
mount $var2 /mnt/usb
find / -name 'VERDE-*' -exec yum -y install {} \;  #MV VERDE

sleep3


/usr/lib/verde/bin/verde-config -i