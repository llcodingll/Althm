N = int(input())
x, y = map(int, input().split())

grid = [["."] * (N + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    row = input()
    for j in range(1, N + 1):
        grid[i][j] = row[j - 1]

# Please write your code here.

dir_num = 4
# 방문 확인 배열 초기화 3중 배열(동일한 위치, 동일한 방향 체크)
visited = [[[False for _ in range(dir_num)]
            for _ in range(N+1)]
            for _ in range(N+1)]

dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]  # 우 하 좌 상 
time, dr = 0, 0

while True:
    if visited[x][y][dr]:
        time = -1
        break

    visited[x][y][dr] = True 

    nx, ny = x + dxs[dr], y + dys[dr]

    # 앞으로 이동할 수 있는 곳이 격자 밖 -> 탈출 
    if 1 > nx or nx > N or 1 > ny or ny > N:
        time += 1
        break 

    if grid[nx][ny] == '#':  # 벽이 있을 경우
        # 반시계 방향으로 90도 회전
        dr = (dr + 3) % 4 
        continue
                
    # 오른쪽에 벽이 있다면, 그냥 한 칸 이동
    tmp = (dr + 1) % 4
    cx, cy = nx + dxs[tmp], ny + dys[tmp]

    if grid[cx][cy] == '#':
        x, y = nx, ny

    # 오른쪽에 벽이 없다면, 한 칸 이동 후 시계 방향으로 방향 전환 
    else:
        dr = (dr + 1) % 4  # 시계 방향 전환 
        x, y = nx, ny

    time += 1
    # print("time:", time, "dr:", dr, "x,y:", x, y)

print(time)