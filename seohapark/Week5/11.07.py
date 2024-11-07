from itertools import permutations

N, M = map(int, input().split())
numbers = list(map(int, input().split()))

numbers.sort()

ans = sorted(set(permutations(numbers, M)))

for a in ans:
    print(" ".join(map(str, a)))
