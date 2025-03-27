from collections import deque

n = int(input())  # 격자 크기 
r1, c1, r2, c2 = map(int, input().split())
grid = [[0] * n for _ in range(n)]
visited = [[False] * n for _ in range(n)]
dist = [[0] * n for _ in range(n)]

# (r1-1, c1-1)에서 (r2-1, c2-1)로 최소 이동 횟수 
q = deque()
q.append((r1-1, c1-1))


def can_go(x, y):
    return 0 <= x < n and 0 <= y < n and not visited[x][y]


while q:
    x, y = q.popleft()

    dxs = [-1, -2, -2, -1, 1, 2, 2, 1]
    dys = [-2, -1, 1, 2, 2, 1, -1, -2]

    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        
        if can_go(nx, ny):
            dist[nx][ny] = dist[x][y] + 1
            visited[nx][ny] = True
            q.append((nx, ny))

if r1 == r2 and c1 == c2:
    print(0)
else:
    print(dist[r2-1][c2-1] if dist[r2-1][c2-1] != 0 else -1)