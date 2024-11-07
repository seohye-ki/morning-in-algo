n = int(input())

ret = 0

for _ in range(n):
    s = input()
    a = [0] * 26 
    k = 1
    pass_check = True

    while k < len(s):
        if a[ord(s[k]) - ord('a')]:
            pass_check = False
            break

        if s[k] != s[k - 1]:
            a[ord(s[k - 1]) - ord('a')] += 1
        k += 1

    ret += pass_check

print(ret)
