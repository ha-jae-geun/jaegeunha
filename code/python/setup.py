#cx_Freeze / pyinstaller
#https://www.youtube.com/watch?v=HosXxXE24hA
# setup.py (filename은 편할대로 하세요.)
import sys
from cx_Freeze import setup, Executable

setup(
		name="Demo",
		version="1.0",
		description = "테스트 파일",
		author = "makingfunk",
		executables = [Executable("selinium.py")])