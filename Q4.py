# 문제 4번 
# 최초 기상 시간 H시 M분을 입력 받고 
# 추가로 더해지는 시간을 출력 100분이면 시간 단위로 쪼개서 더해주는 과정이 필요

import sys

First_Wake_H,First_Wake_M= map(int,sys.stdin.readline().split())# 최초 기상 시간을 입력을 받음 
More_Sleep =  int(sys.stdin.readline()) # 추가로 더 자고 싶은 시간을 입력

More_Sleep_H = int(More_Sleep / 60) #  추가로 자고 싶은 시간의 시간
More_Sleep_M = int(More_Sleep % 60) # 추가로 자고 싶은 시간의 분

ans_H = First_Wake_H + More_Sleep_H
ans_M = First_Wake_M + More_Sleep_M

print(ans_H, ans_M)
