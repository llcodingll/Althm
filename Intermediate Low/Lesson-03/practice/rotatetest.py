
grid = [[1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
        ]

print("회전 전")
for row in grid:
    print(*row)

def rotate_90_clockwise(mat):  # 시계 방향 90도 회전
    return [list(row) for row in zip(*mat[::-1])]

print()
print("시계 방향 회전")
for row in rotate_90_clockwise(grid):
    print(*row)

def rotate_90_counterclockwise(mat):  # 반시계 방향 90도 회전
    return [list(row) for row in zip(*mat)][::-1]

print()
print("반시계 방향 회전")
for row in rotate_90_counterclockwise(grid):
    print(*row)