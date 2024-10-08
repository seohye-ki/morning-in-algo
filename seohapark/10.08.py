from sys import stdin
from math import ceil, log

input = stdin.readline
MOD = 10**9 + 7


def get_len():#length of semgent
    return 2 * N if N & (N - 1) == 0 else pow(2, ceil(log(N, 2)) + 1)


def prop(idx, start, end):#시간초과 크아악 바로 세그먼트 정상화
    if not (lazy1[idx] == 1 and lazy2[idx] == 0):
        seg[idx] = seg[idx] * lazy1[idx] + (end - start + 1) * lazy2[idx]

        if start != end:
            lazy1[idx * 2] = (lazy1[idx * 2] * lazy1[idx]) % MOD
            lazy1[idx * 2 + 1] = (lazy1[idx * 2 + 1] * lazy1[idx]) % MOD
            lazy2[idx * 2] = (lazy2[idx * 2] * lazy1[idx] + lazy2[idx]) % MOD
            lazy2[idx * 2 + 1] = (lazy2[idx * 2 + 1] * lazy1[idx] + lazy2[idx]) % MOD

        lazy1[idx] = 1
        lazy2[idx] = 0


def init(idx, start, end):
    if start == end:
        seg[idx] = nums[start]
        return

    mid = (start + end) // 2
    init(idx * 2, start, mid)
    init(idx * 2 + 1, mid + 1, end)
    seg[idx] = (seg[idx * 2] + seg[idx * 2 + 1]) % MOD


def jeongsanghwa(idx, start, end, left, right, order, value):
    prop(idx, start, end)

    if right < start or end < left:
        return

    if left <= start and end <= right:
        if order == 1:
            lazy1[idx] = 1
            lazy2[idx] = value
        elif order == 2:
            lazy1[idx] = value
            lazy2[idx] = 0
        else:
            lazy1[idx] = 0
            lazy2[idx] = value

        prop(idx, start, end)
        return

    mid = (start + end) // 2
    jeongsanghwa(idx * 2, start, mid, left, right, order, value)#왼
    jeongsanghwa(idx * 2 + 1, mid + 1, end, left, right, order, value)#오
    seg[idx] = (seg[idx * 2] + seg[idx * 2 + 1]) % MOD#부모


def qry(idx, start, end, left, right):
    prop(idx, start, end)

    if right < start or end < left:
        return 0#범위 아웃

    if left <= start and end <= right:
        return seg[idx]

    mid = (start + end) // 2
    return (qry(idx * 2, start, mid, left, right) + qry(idx * 2 + 1, mid + 1, end, left, right)) % MOD


if __name__ == '__main__':
    N = int(input())
    nums = [-1] + list(map(int, input().split()))

    slen = get_len()
    seg = [0] * slen
    lazy1 = [1] * slen
    lazy2 = [0] * slen
    init(1, 1, N)

    M = int(input())
    for _ in range(M):
        cmd = list(map(int, input().split()))
        if cmd[0] in {1, 2, 3}:
            jeongsanghwa(1, 1, N, cmd[1], cmd[2], cmd[0], cmd[3])
        else:
            print(qry(1, 1, N, cmd[1], cmd[2]))
