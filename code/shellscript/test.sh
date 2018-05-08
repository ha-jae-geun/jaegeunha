#!/bin/sh

echo "--> Updating CentOS System"
yum -y update
sleep 3

echo "--> "
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
passwd 
sleep 3

usermod -G root vb-verde
sleep 3

echo "-proc -1" > /etc/security/limits.d/95-verde.chkconfig
echo "-nofile 65535" > /etc/security/limits.d/95-verde.chkconfig
vi /etc/security/limits.d/95-verde.chkconfig
exit()
sleep 3

sudo update-alternatives --config java-1
/etc/init.d/iptables stop
sleep 3

chkconfig iptables off
vi /etc/sysconfig/selinux
SELINUX=disabled
sleep 3

yum --nogpgcheck install VERDE*.rpm
sleep 3

/usr/lib/verde/bin/verde-config -i

