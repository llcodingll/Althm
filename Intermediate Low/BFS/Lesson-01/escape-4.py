import sys
input = sys.stdin.readline

from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

q = deque()
q.append((0, 0))

visited = [[False] * m for _ in range(n)]
visited[0][0] = True

def in_range(x, y):
    return 0 <= x < n and 0 <= y < m


def can_go(x, y):
    return in_range(x, y) and grid[x][y] and not visited[x][y]


while q:
    x, y = q.popleft()

    dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1]
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            q.append((nx, ny))
            visited[nx][ny] = True
            
if visited[n-1][m-1]:
    print(1)
else:
    print(0)