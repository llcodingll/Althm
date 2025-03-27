from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
dist = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]

q = deque()
q.append((0, 0))
visited[0][0] = True


def can_go(x, y):
    return 0 <= x < n and 0 <= y < m and grid[x][y] == 1 and not visited[x][y]


while q:
    x, y = q.popleft()

    for dx, dy in zip([-1, 1, 0, 0], [0, 0, -1, 1]):
        nx, ny = x + dx, y + dy

        if can_go(nx, ny):
            dist[nx][ny] = dist[x][y] + 1
            visited[nx][ny] = True
            q.append((nx, ny))

print(-1 if dist[n-1][m-1] == 0 else dist[n-1][m-1])