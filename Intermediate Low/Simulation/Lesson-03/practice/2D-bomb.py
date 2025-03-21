BLANK = -1
WILL_EXPLODE = 0

# 변수 선언 및 입력
n, m, k = tuple(map(int, input().split()))
numbers_2d = [list(map(int, input().split()))for _ in range(n)]
numbers_1d = [0 for _ in range(n)]


def print_grid():
    for row in numbers_2d:
        print(" ".join(str(x) if x != BLANK else "." for x in row))  # BLANK는 "."로 표시


# 주어진 시작점에 대하여 부분 수열의 끝 위치를 반환
def get_end_idx_of_explosion(start_idx, curr_num):
    for end_idx in range(start_idx + 1, len(numbers_1d)):
        if numbers_1d[end_idx] != curr_num:
            return end_idx - 1
        
    return len(numbers_1d) - 1


def explode():
    while True:
        did_explode = False
        curr_idx = 0
    
        while curr_idx < len(numbers_1d):
            end_idx = get_end_idx_of_explosion(curr_idx, numbers_1d[curr_idx])
        
            if end_idx - curr_idx + 1 >= m:
                print(f"\nExplosion at indices {curr_idx} to {end_idx} in 1D column: {numbers_1d[curr_idx:end_idx + 1]}")

                # 연속한 숫자의 개수가 m개 이상이면
                # 폭탄이 터질 수 있는 경우 해당 부분 수열을 잘라내고
                # 폭탄이 터졌음을 기록해줍니다.
                del numbers_1d[curr_idx:end_idx + 1]
                did_explode = True
            else:
                # 주어진 시작 원소에 대하여 폭탄이 터질 수 없는 경우
                # 다음 원소에 대하여 탐색하여 줍니다.
                curr_idx = end_idx + 1

        if not did_explode:
            break

        
# 격자의 특정 열을 일차원 배열에 복사해줍니다.
def copy_column(col):
    global numbers_1d
    
    numbers_1d = [
        numbers_2d[row][col]
        for row in range(n)
        if numbers_2d[row][col] != BLANK
    ]


# 폭탄이 터진 결과를 격자의 해당 열에 복사해줍니다.
def copy_result(col):
    for row in range(n - 1, -1, -1):
        numbers_2d[row][col] = numbers_1d.pop() if numbers_1d \
                                                else BLANK


# 폭탄이 터지는 과정을 시뮬레이션 합니다.
def simulate():
    print("\n=== Before Explosion ===")
    print_grid()
    
    for col in range(n):
        copy_column(col)
        print(f"\nColumn {col} copied to 1D: {numbers_1d}")

        explode()
        print(f"Column {col} after explosion: {numbers_1d}")

        copy_result(col)

    print("\n=== After Explosion ===")
    print_grid()


        
# 시계 방향으로 90도 회전해줍니다.
def rotate():
    global numbers_2d
    
    temp_2d = [[BLANK for _ in range(n)] for _ in range(n)]
    
    for i in range(n - 1, -1, -1):
        curr_idx = n - 1
        for j in range(n - 1, -1, -1):
            if numbers_2d[i][j] != BLANK:
                temp_2d[curr_idx][n - i - 1] = numbers_2d[i][j]
                curr_idx -= 1
    
    numbers_2d = temp_2d

    print("\n=== After Rotation ===")
    print_grid()


        
# 주어진 입력에 따라 폭탄이 터지는 것을 시뮬레이션 합니다.
simulate()
for _ in range(k):
    rotate()
    simulate()

        
# 격자를 순회하며 남아 있는 폭탄의 개수를 세줍니다.
answer = sum([
    numbers_2d[i][j] != BLANK
    for i in range(n)
    for j in range(n)
])
print(answer)
