import sys

def get_area(lo, hi):
    if lo == hi:
        return histogram[lo]
    
    mid = (lo + hi) // 2
    left_area = get_area(lo, mid)
    right_area = get_area(mid + 1, hi)
    
    max_area = max(left_area, right_area)
    
    max_area = max(max_area, get_mid_area(lo, hi, mid))
    
    return max_area

def get_mid_area(lo, hi, mid):
    to_left = mid 
    to_right = mid
    height = histogram[mid] 
    
    max_area = height
    
    while lo < to_left and to_right < hi:

        if histogram[to_left - 1] < histogram[to_right + 1]:
            to_right += 1
            height = min(height, histogram[to_right])
        else:
            to_left -= 1
            height = min(height, histogram[to_left])

        max_area = max(max_area, height * (to_right - to_left + 1))
    
    while to_right < hi:
        to_right += 1
        height = min(height, histogram[to_right])
        max_area = max(max_area, height * (to_right - to_left + 1))
    
    while lo < to_left:
        to_left -= 1
        height = min(height, histogram[to_left])
        max_area = max(max_area, height * (to_right - to_left + 1))
    
    return max_area

def main():
    input = sys.stdin.read
    data = input().strip().splitlines()
    
    results = []
    for line in data:
        values = list(map(int, line.split()))
        n = values[0]
        if n == 0:
            break
        global histogram
        histogram = values[1:]
        results.append(get_area(0, n - 1))
    
    print('\n'.join(map(str, results)))

if __name__ == "__main__":
    main()
