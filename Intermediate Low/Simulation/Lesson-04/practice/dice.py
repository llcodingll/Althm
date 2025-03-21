OUT_OF_GRID = (-1, -1)

# 격자 크기, 굴릴 횟수, 초기 위치 
n, m, r, c = map(int, input().split())
# 주사위 방향 
directions = list(input().split())

# Please write your code here.
# 주사위가 놓여있는 상태
up, front, right = 1, 2, 3
grid = [[0] * n for _ in range(n)]

# 격자 안에 있는지 확인 
def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


# 해당 방향으로 이동했을 때의 다음 위치 구하기 
def next_pos(x, y, move_dir):
    dxs, dys = [0, 0, -1, 1], [1, -1, 0, 0]
    nx, ny = x + dxs[move_dir], y + dys[move_dir]
    return (nx, ny) if in_range(nx, ny) else OUT_OF_GRID


def simulate(move_dir):
    global x, y, up, front, right

    # move_dir 방향으로 굴렸을 때의 격자 상의 위치를 구한다. 
    nx, ny = next_pos(x, y, move_dir)
    # 굴리는 게 불가능한 경우라면 패스한다. 
    if (nx, ny) == OUT_OF_GRID:
        return 
    
    # 위치를 이동한다. 
    x, y = nx, ny 

    if move_dir == 0:  # 동쪽
        up, front, right = 7-right, front, up
    elif move_dir == 1:  # 서쪽
        up, front, right = right, front, 7-up
    elif move_dir == 2:
        up, front, right = front, 7-up, right
    else:  # 남쪽
        up, front, right = 7-front, up, right

    # 바닥에 적혀있는 숫자 변경
    bottom = 7-up
    grid[x][y] = bottom 


# main 
x, y = r-1, c-1  # 0 index

dir_mapper = {'R': 0, 'L': 1, 'U': 2, 'D':3}

# 시뮬레이션 진행
grid[x][y] = 6
for char_dir in directions:
    simulate(dir_mapper[char_dir])

ans = sum([grid[i][j] for i in range(n) for j in range(n)])

print(ans)