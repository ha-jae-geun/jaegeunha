# 취약 윈도우 버젼 확인
1. 윈도우 버전
    * 실행창 - winver  혹은 설정-시스템-정보(1903, 1909, 2004 조심)
2. 업데이트 버전
    * 설정 - 업데이트 - 업데이트 기록 보기
    
# SMB3 프로토콜 보안 문제
* default로 445 포트가 Listening 하고있음
```java

□ 개요

 o MS는 SMBv3(Service Message Block) 프로토콜에서 발생하는 취약점 주의 발표 [1]

 o 공격자는 해당 취약점을 악용하여 원격코드 실행 등의 피해를 발생시킬 수 있으므로, 임시 해결방안에 따라 조치 권고

  ※ MS는 추후 해당 취약점이 해결된 패치 파일 공개 예정   

 

□ 설명

 o SMBv3 프로토콜이 조작된 패킷을 처리할 때 버퍼오버플로우로 인해 발생하는 원격코드실행 취약점(CVE-2020-0796) [1]

 

□ 영향을 받는 제품

 o Windows 10

  - 1903(32비트, 64비트, ARM64 기반 시스템)

  - 1909(32비트, 64비트, ARM64 기반 시스템)

 o Windows 서버(Server Core installation)

  - 1903, 1909

 

□ 임시 해결 방안(MS, 추후 업데이트 파일 배포 예정)

 1. 운영체제 내 SMBv3 압축 기능 해제 설정

  - 시작 -> Windows Powershell -> 우클릭 -> 관리자 권한으로 실행

Set-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\LanmanServer\Parameters" DisableCompression 

-Type DWORD -Value 1 -Force

 ※ 설정 변경 후 재부팅 불필요

 

  - SMBv3 설정 복구 방법(MS의 업데이트 공개 시, 복구 후 패치 진행)

Set-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\LanmanServer\Parameters" DisableCompression 

-Type DWORD -Value 0 -Force

 

 2. 네트워크 방화벽 및 Windows 방화벽을 이용하여 SMB 445(TCP) 포트 차단
```
