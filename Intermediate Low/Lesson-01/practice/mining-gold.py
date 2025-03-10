# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-gold-mining/description

n, m = map(int, input().split())  # 격자 크기, 금 가격
grid = [list(map(int, input().split())) for _ in range(n)]


# Write your code here!
def chk(x, y, k):
    cnt = 0

    # 마름모 영역 전체 탐색
    for i in range(-k, k + 1):
        # k-|i|: 현재 행에서 탐색해야 할 열의 범위
        for j in range(-(k - abs(i)), k - abs(i) + 1):
            nx, ny = x + i, y + j
            if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 1:
                cnt += 1

    return cnt


# main
K, max_gold = 0, 0

while True:
    cost = K * K + (K + 1) * (K + 1)
    if cost > m * (n * n):
        break

    for i in range(n):
        for j in range(n):
            # 범위 안이면, 금 개수 세기 & 마름모 넓이 계산
            gold = chk(i, j, K)
            profit = m * gold - cost

            if profit >= 0:
                max_gold = max(max_gold, gold)

    K += 1

print(max_gold)