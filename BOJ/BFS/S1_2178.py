from collections import deque

n, m = map(int, input().split())
grid = [list(input()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
dist = [[0] * m for _ in range(n)]  # 최소 칸 수 저장 배열


def can_go(x, y):
    return 0 <= x < n and 0 <= y < m and grid[x][y] == '1' and not visited[x][y]


q = deque()

# 출발지점 
q.append((0, 0))
visited[0][0] = True
dist[0][0] = 1

while q:
    x, y = q.popleft()

    for dx, dy in zip([-1, 1, 0, 0], [0, 0, -1, 1]):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            dist[nx][ny] = dist[x][y] + 1
            visited[nx][ny] = True
            q.append((nx, ny))

print(dist[n-1][m-1])