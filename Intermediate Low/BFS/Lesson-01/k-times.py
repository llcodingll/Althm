n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())

# Please write your code here.
from collections import deque

x, y = r-1, c-1
visited = [[False] * n for _ in range(n)]
q = deque()

def initialize_visited():
    for i in range(n):
        for j in range(n):
            visited[i][j] = False 

def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def can_go(nx, ny, target):
    return in_range(x, y) and grid[nx][ny] < target and not visited[nx][ny]


def bfs(x, y):
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()

        for dx, dy in zip([-1, 1, 0, 0], [0, 0, -1, 1]):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                q.append((nx, ny))
                visited[nx][ny]


def update(best, new):
    if best == (-1, -1):
        return True
    
    bx, by = best
    nx, ny = new

    return (grid[nx][ny], -nx, -ny) > (grid[bx][by], -bx, -by)


def move():
    initialize_visited()

    # Step 1: BFS로 갈 수 있는 모든 위치 탐색
    bfs()

    # Step 2: 도달할 수 있는 위치 중 가장 우선순위가 높은 위치 구함
    best = (-1, -1)
    for i in range(n):
        for j in range(n):
            if not visited[i][j] or (i, j) == (x, y):
                continue

            new = (i, j)
            if update(best, new):
                best = new

    # Step 3: 위치 이동
    if best == (-1, -1):
        return False
    else:
        x, y = best
        return True


for _ in range(k):
    is_moved = move()

    if not is_moved:
        break

row, col = x, y
print(row+1, col+1)