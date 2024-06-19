# 코알라 마릿수를 입력을 받고 
# 입력 받은 코알라의 수에서 비율을 입력을 받음 그게 두번째 정수가 됨 
# 세번째 정수에서는 그 비율에 맞춰서 몸무게를 입력을 받음
# 그러면 출력에서는 필요한 먹이의 수를 출력을 하고 
# 그 아랫줄에서는 두 개의 숫자를 더한 값을 출력 하면 됨 

# 정수 하나를 입력을 받고 그 만큼 for문을 돌림 
# 돌리면서 3개를 입력 받아야 되고 정답은 마지막 입력한 숫자 * 두번째 입력한 숫자 / 첫번째 입력한 숫자 
# 를 print(n1,n2)
# 줄바꿈 해서 print(n1 + n2)로 슈웃


count = int(input())
result = []
for i in range(count):
    a,b,c= map(int, input().split())
    a1 = int((c / a) * b)
    result.append(a1)
a2 = sum(result)

print(" ".join(map(str, result)))
print(a2)
