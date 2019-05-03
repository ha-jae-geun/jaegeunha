# 윈도우

# 아나콘다; 3.5.2.0
- https://repo.anaconda.com/archive/
- 3.5.1.0 은 아나콘다 1.5을 의미
- conda --version으로 버전 확인

## 우분투 아나콘다
## 우분투 아나콘다 다운로드
- wget https://repo.continuum.io/archive/Anaconda3-5.2.0-Linux-x86_64.sh

## 우분투 아나콘다 설치
- bash Anaconda3-5.2.0-Linux-x86_64.sh
- 중간에 bashrc 경로 yes
- 버전 확인: source .bashrc  이후 conda --version

# 파이썬 설치 (콘다 혹은 윈도우 파워쉘에서)
- conda install python=3.6.8

## 파이썬 버전
- 2.7 사사오입, 3.0이상 

# 우분투 파이썬 설치
- 가상환경 만들기: conda create -n 가상환경 이름 python=3.6.8
- 가상환경 실행: source activate 가상환경이름; deactivate
- 파이썬 실행: python 입력

# 주피터 윈도우
- 경로 맨 뒤를 폴더를 하나 만들어서 "" 사이에 넣기; "C:\noteju"


# 파이참
- https://www.jetbrains.com/pycharm/?fromMenu 에서 community 다운받기\

## 파이참 설정
- C:\JetBrains\PyCharm Community Edition 2019.1.1\bin 의 pycharm64.exe 워드 패드로 열기
- -Xms512m  -Xmx1024m  수정
- Dfile.encoding=UTF-8 설정
  - 파이참 setting에서 encoding에 project setting의 인코딩 확인
