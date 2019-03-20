## terminal session
* 쪼개지 않고 직접적으로 하드웨어로 접근 가능하여 성능 차이 없음.  
  ^There is no performance difference because it can be directly accessed by hardware without splitting.


# thin client
 CPU, 메모리 등 필수적인 하드웨어 장치만 탑재해 네트워크로 연결된 중앙서버에서 모든 업무를 관리하도록 설계된 업무용 PC를 일컫는다.

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

