from collections import deque

T = int(input())

q = deque()


def in_range(x, y):
    return 0 <= x < N and 0 <= y < M


def can_go(x, y):
    return in_range(x, y) and arr[x][y] and not visited[x][y]


def bfs(i, j):
    q.append((i, j))
    visited[i][j] = True

    while q:
        x, y = q.popleft()

        for dx, dy in zip([-1, 1, 0, 0], [0, 0, -1, 1]):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                q.append((nx, ny))
                visited[nx][ny] = True


for tc in range(T):
    # 배추밭 가로, 세로, 배추 위치의 개수 
    M, N, K = map(int, input().split())
    arr = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]

    for i in range(K):
        y, x = map(int, input().split())
        arr[x][y] = 1 

    area = 0
    for i in range(N):
        for j in range(M):
            if can_go(i, j):
                bfs(i, j)
                area += 1

    print(area)
