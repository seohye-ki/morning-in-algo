import sys
from bisect import bisect_left

def main():
    n = int(input().strip())
    arr = list(map(int, input().strip().split()))
    
    check = [0] * n
    v = [arr[0]]
    length = 1
    
    for i in range(1, n):
        index = bisect_left(v, arr[i])
        check[i] = index
        if index == len(v):
            v.append(arr[i])
            length += 1
        else:
            v[index] = arr[i]
    
    print(length)
    
    ans = []
    for i in range(n - 1, -1, -1):
        if length < 1:
            break
        if check[i] == length - 1:
            ans.append(arr[i])
            length -= 1

    print(" ".join(map(str, ans[::-1])))

if __name__ == "__main__":
    main()
