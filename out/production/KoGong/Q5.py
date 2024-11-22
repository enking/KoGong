# 문제 5
# 시간을 빼는 문제 아까 판다는 더하고 이건 빼는것
# 이 문제의 포인트는 45분을 빼는데 분이 45분보다 작으면 1시간을 빼서 분에 15분을 더해주는 것


import sys

firstButtonPush_H, firstButtonPush_M = map(int,sys.stdin.readline().split())# 최초 시간을 입력을 받음 

if firstButtonPush_M >= 45: # 분이 45분보다 적은 경우 시를 뺄 필요가 없음 
    timeAns_M = firstButtonPush_M - 45
    print(firstButtonPush_H, timeAns_M)
elif firstButtonPush_H == 0 & firstButtonPush_M >= 45:
    timeAns_M = firstButtonPush_M - 45
    timeAns_H = firstButtonPush_H
    print(timeAns_H, timeAns_M)
elif firstButtonPush_H == 0 & firstButtonPush_M <= 45:
    timeAns_H = 23
    timeAns_M = firstButtonPush_M + 15
    print(timeAns_H, timeAns_M)
else : 
    timeAns_H = firstButtonPush_H - 1
    timeAns_M = firstButtonPush_M + 15
    print (timeAns_H, timeAns_M)

