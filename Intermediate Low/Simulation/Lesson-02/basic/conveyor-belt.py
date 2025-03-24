n, t = map(int, input().split())
u = list(map(int, input().split()))
d = list(map(int, input().split()))

# Write your code here!
for tc in range(t):
    u_tmp = u[n-1]
    for i in range(n-1, 0, -1):
        u[i] = u[i-1]

    d_tmp = d[n-1]
    for i in range(n-1, 0, -1):
        d[i] = d[i-1]

    d[0] = u_tmp
    u[0] = d_tmp

print(*u)
print(*d)