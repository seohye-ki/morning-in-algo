def main():
    n = int(input())  
    a = list(map(int, input().split())) 

    m = int(input())
    b = list(map(int, input().split()))

    ans = []  # 정답 저장할 그리드
    while a and b:  # a b 전부 털어넣어서
        max_a, max_b = max(a), max(b)  # 각각 최대값 적어줘

        if max_a == max_b:  # 최대가 같으면
            ans.append(max_a)
            a = a[a.index(max_a) + 1:]  # 첫 번째 리스트에서 max_a 이후 값들로 슬라이싱
            b = b[b.index(max_b) + 1:]  # 두 번째 리스트에서 max_b 이후 값들로 슬라이싱
        elif max_a > max_b:  # max_a가 더 크면 첫 번째 리스트에서 max_a 해고
            a.remove(max_a)
        else:  # 아니면 너가 나가
            b.remove(max_b)

    if ans:  # 공통 최댓값이 있는 경우(파이썬은 이렇게 쓰면 ans가 비었으면 false 안 비엇으면 true로 알아서 읽음
        print(len(ans))  # 공통 최댓값 개수 출력
        print(" ".join(map(str, ans)))  # 공통 최댓값 리스트 출력
    else:  # 빵
        print(0)

# 프로그램 실행
if __name__ == "__main__":
    main()
