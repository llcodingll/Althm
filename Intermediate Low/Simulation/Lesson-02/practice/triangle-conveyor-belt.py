# 문제 URL: https://www.codetree.ai/trails/complete/curated-cards/challenge-conveyor-belt-triangle/description

n, t = map(int, input().split())

l = list(map(int, input().split()))
r = list(map(int, input().split()))
d = list(map(int, input().split()))

# Write your code here!
for tc in range(t):
    l_tmp, r_tmp, d_tmp = l[n-1], r[n-1], d[n-1]
    for i in range(n-1, 0, -1):
        l[i] = l[i-1]
        r[i] = r[i-1]
        d[i] = d[i-1]

    l[0], r[0], d[0] = d_tmp, l_tmp, r_tmp

print(*l)
print(*r)
print(*d)