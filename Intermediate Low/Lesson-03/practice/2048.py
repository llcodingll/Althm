# IL/Simulation/Lesson 3/단 한 번의 2048 시도 : https://www.codetree.ai/ko/trails/personalized/curated-cards/challenge-one-trial-of-2048-game/description

# Read 4x4 grid
grid = [list(map(int, input().split())) for _ in range(4)]

# Read direction
direction = input().strip()  # L, R, U, D

# 이동 및 병합 함수 (한 줄씩 처리)
def move_and_merge(line):
    st, cnt = [], 0
    for num in line:
        if num != 0:
            if not st or st[-1] != num:
                st.append(num)
                cnt = 0  # 새로운 숫자는 다시 합칠 수 있도록 초기화
            elif st[-1] == num and cnt == 0:
                st.append(st.pop() * 2)  # 같은 숫자 합치기
                cnt = 1  # 한 번 합치면 그 다음에는 합치지 않도록 제한
            else:
                st.append(num)

    return st + [0] * (4 - len(st))  # 빈 칸을 0으로 채우기

# 보드 회전 함수
def rotate_90_clockwise(mat):  # 시계 
    return [list(row) for row in zip(*mat[::-1])]

def rotate_90_counterclockwise(mat):  # 반시계 
    return [list(row) for row in zip(*mat)][::-1]

# 방향에 따라 보드 조정
if direction == 'L':
    new_grid = [move_and_merge(row) for row in grid]
elif direction == 'R':
    new_grid = [move_and_merge(row[::-1])[::-1] for row in grid]  # 오른쪽 이동 = 좌로 이동 후 반전
elif direction == 'U':
    rotated = rotate_90_counterclockwise(grid)  # 세로를 가로로 변환
    moved = [move_and_merge(row) for row in rotated]
    new_grid = rotate_90_clockwise(moved)  # 원래대로 복구
elif direction == 'D':
    rotated = rotate_90_clockwise(grid)  # 세로를 가로로 변환
    moved = [move_and_merge(row) for row in rotated]  # 오른쪽 이동 후 반전
    new_grid = rotate_90_counterclockwise(moved)  # 원래대로 복구

# 결과 출력
for row in new_grid:
    print(*row)
