# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-slanted-rectangle/description
'''
1. 대각선 위(우) 2. 대각선 위(좌) 3. 대각선 아래(좌) 4. 대각선 아래(우)
1 (i-1, j+1) / 2 (i-1, j-1) / 3 (i+1, j-1) / 4 (i+1, j+1)

시작점이 가능한 위치 
2 <= sx < n and 1 <= sy < n-1

2번, 4번 이동은 최대 sx 좌표만큼 이동할 수 있음
'''

def solution(x, y, k, l):
    dr = 0
    dxs, dys = [-1, -1, 1, 1], [1, -1, -1, 1]  # 1, 2, 3, 4 이동
    move = [k, l, k, l]
    total = 0
    
    for dx, dy, m in zip(dxs, dys, move):
        for _ in range(m):
            x, y = x + dx, y + dy

            if not (0 <= x < n and 0 <= y < n):
                return 0
            
            total += grid[x][y]

    return total


n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

ans = 0
for sx in range(2, n):
    for sy in range(1, n-1):
        for k in range(1, n):
            for l in range(1, n):
                ans = max(ans, solution(sx, sy, k, l))

print(ans)