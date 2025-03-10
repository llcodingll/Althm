# NM/완전탐색 1/Lesson 1/모이자 : https://www.codetree.ai/ko/trails/complete/curated-cards/intro-gather/description

n = int(input())
arr = list(map(int, input().split()))

i, mn = 0, float('inf')
while True:
    tmp = 0
    for idx, v in enumerate(arr):
        tmp += abs(i-idx) * v

    mn = min(mn, tmp)

    if i == n-1:
        break

    i += 1

print(mn)