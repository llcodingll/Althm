n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
points = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
from collections import deque

# k개의 시작점으로부터 도달 가능한 칸의 수 

def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def can_go(x, y):
    return in_range(x, y) and not visited[x][y] and grid[x][y] == 0

visited = [[False] * n for _ in range(n)]

q = deque()
cnt = 0

for r, c in points:
    x, y = r-1, c-1

    q.append((x, y))
    if not visited[x][y]:
        visited[x][y] = True
        cnt += 1

    while q:
        x, y = q.popleft()
        dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1]
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                visited[nx][ny] = True
                q.append((nx, ny))
                cnt += 1

print(cnt)