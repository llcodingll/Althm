from collections import deque

N = int(input())
grid = [list(map(int, input().split())) for _ in range(N)]
shark_size, fish_cnt, time = 2, 0, 0  

def bfs(x, y):
    dxs, dys = [1, 0, -1, 0], [0, 1, 0, -1]

    dist, fish = [[-1] * N for _ in range(N)], []
    dist[x][y] = 0

    # bfs를 실행할 때마다 새로운 큐 사용 
    Q = deque()
    Q.append((x, y))

    while Q:
        x, y = Q.popleft()

        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            # 격자 내 & 상어 크기보다 작거나 같아야 지나갈 수 있음 
            if 0 <= nx < N and 0 <= ny < N and grid[nx][ny] <= shark_size and dist[nx][ny] == -1:
                dist[nx][ny] = dist[x][y] + 1

                # 이동 범위 내에서 먹을 수 있는 물고기 발견 시 
                if 0 < grid[nx][ny] < shark_size:
                    # 먹을 수 있는 물고기가 여러 개 있을 수 있음 
                    fish.append([dist[nx][ny], nx, ny])

                Q.append((nx, ny))

    if not fish:
        return None

    # 거리 -> 행 -> 열 순 
    fish.sort()
    return fish[0]
    

# 상어 위치 초기화
for i in range(N):
    for j in range(N):
        if grid[i][j] == 9:
            x, y = i, j 
            grid[i][j] = 0  # 상어 위치 초기화 
            break

while True:
    # 공간에서 먹을 수 있는 물고기 거리 확인 - 최단거리 구하기 bfs
    result = bfs(x, y) 

    # 공간에 상어 크기보다 작은 물고기가 없으면 SOS
    if not result:
        break

    dist, nx, ny = result
    time += dist  # 걸린 시간 추가 
    fish_cnt += 1  # 먹은 물고기 개수 증가 
    grid[nx][ny] = 0  # 이동한 곳(물고기 먹음) 0으로 변경
    x, y = nx, ny  # 상어 위치 갱신  

    # 아기 상어 크기 == 먹은 물고기일 경우, 크기 + 1 증가
    if shark_size == fish_cnt:
        shark_size += 1
        fish_cnt = 0   

# SOS 하는 데 걸린 시간 
print(time)