n, r, c = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
x, y = r - 1, c - 1  # 0 index 

st = []
st.append(a[x][y])  # 처음 위치 저장 

# 이동할 수 없을 때까지 반복
while True:
    can_go = False

    # 우선순위는 상하좌우
    dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1]

    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < n and st[-1] < a[nx][ny]:
            st.append(a[nx][ny])
            x, y = nx, ny
            can_go = True
            break

    if not can_go:
        break


# 방문한 격자에 있는 숫자들 공백 두고 출력 
print(*st)