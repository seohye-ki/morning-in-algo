from collections import deque
n = int(input())
dq = deque((int(d), i + 1) for i, d in enumerate(input().split()))
print(dq[0][1], end=' ')
while len(dq) > 1:
    mv, idx = dq.popleft()  
    if mv > 0:
        dq.rotate(-(mv - 1))
    else:
        dq.rotate(-mv)
    print(dq[0][1], end=' ')