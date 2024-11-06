from collections import deque

MAX = 1500
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

r, c = 0, 0
found = False
map_data = []
visited = []
swan_queue = deque()
swan_next_queue = deque()
water_queue = deque()
next_water_queue = deque()
swan_pos = (0, 0)

def input_data():
    global r, c, swan_pos, found, map_data, visited, water_queue
    found = False
    r, c = map(int, input().split())
    map_data = []
    visited = [[False] * c for _ in range(r)]

    for i in range(r):
        line = list(input().strip())
        map_data.append(line)
        for j in range(c):
            if line[j] != 'X':
                water_queue.append((i, j))
            if line[j] == 'L':
                swan_pos = (i, j)

def swan_bfs():
    global found, swan_queue, swan_next_queue
    while swan_queue and not found:
        x, y = swan_queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < r and 0 <= ny < c and not visited[nx][ny]:
                if map_data[nx][ny] == '.':
                    visited[nx][ny] = True
                    swan_queue.append((nx, ny))
                elif map_data[nx][ny] == 'L':
                    visited[nx][ny] = True
                    found = True
                    break
                elif map_data[nx][ny] == 'X':
                    visited[nx][ny] = True
                    swan_next_queue.append((nx, ny))

def water_bfs():
    global water_queue, next_water_queue
    while water_queue:
        x, y = water_queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < r and 0 <= ny < c and map_data[nx][ny] == 'X':
                map_data[nx][ny] = '.'
                next_water_queue.append((nx, ny))

def solution():
    global found, water_queue, swan_queue, next_water_queue, swan_next_queue
    day = 0
    swan_queue.append(swan_pos)
    visited[swan_pos[0]][swan_pos[1]] = True

    while not found:
        swan_bfs()

        if not found:
            water_bfs()
            water_queue, next_water_queue = next_water_queue, deque()
            swan_queue, swan_next_queue = swan_next_queue, deque()
            day += 1

    print(day)

def solve():
    input_data()
    solution()

if __name__ == "__main__":
    solve()
