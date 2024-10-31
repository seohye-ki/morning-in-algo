import sys

input = sys.stdin.read
data = input().split()

N = int(data[0])
K = int(data[1])

arr = [int(data[i + 2]) for i in range(N)]

arr.sort()

l, h = arr[0], arr[0] + K
ans = arr[0]

while l <= h:
    mid = (l + h) // 2

    sum_needed = sum(max(0, mid - level) for level in arr)

    if sum_needed <= K:
        ans = max(ans, mid)
        l = mid + 1
    else:
        h = mid - 1

print(ans)
