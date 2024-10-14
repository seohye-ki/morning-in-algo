from collections import deque

MAX = 105
INF = int(1e9)

Line = [[] for _ in range(MAX)]
Capacity = [[0] * MAX for _ in range(MAX)]
Flow = [[0] * MAX for _ in range(MAX)]


def add_edge(From, To, Amount):
    Line[From].append(To)
    Line[To].append(From)
    Capacity[From][To] = Amount


def max_flow(Sour, Sink):
    FlowSum = 0
    while True:
        Parent = [-1] * MAX
        Queue = deque([Sour])

        while Queue and Parent[Sink] == -1:
            Curr = Queue.popleft()
            for Next in Line[Curr]:
                if Capacity[Curr][Next] - Flow[Curr][Next] > 0 and Parent[Next] == -1:
                    Queue.append(Next)
                    Parent[Next] = Curr

        if Parent[Sink] == -1:
            break

        i = Sink
        while i != Sour:
            Flow[Parent[i]][i] += 1
            Flow[i][Parent[i]] -= 1
            i = Parent[i]

        FlowSum += 1

    return FlowSum


def change_flow(Sour, Sink):
    Parent = [-1] * MAX
    Queue = deque([Sour])

    while Queue and Parent[Sink] == -1:
        Curr = Queue.popleft()
        for Next in Line[Curr]:
            if Curr < Sour or (Curr == Sour and Next < Sink):
                continue
            if Capacity[Curr][Next] - Flow[Curr][Next] > 0 and Parent[Next] == -1:
                Queue.append(Next)
                Parent[Next] = Curr

    if Parent[Sink] == -1:
        return

    Flow[Sour][Sink] = Flow[Sink][Sour] = 0
    i = Sink
    while i != Sour:
        Flow[Parent[i]][i] += 1
        Flow[i][Parent[i]] -= 1
        i = Parent[i]


def main():
    import sys
    input = sys.stdin.read
    data = input().split()

    N = int(data[0])
    M = int(data[1])
    index = 2

    Sour = 101
    Sink = 102
    FlowSum = 0

    for i in range(1, N + 1):
        Amount = int(data[index])
        add_edge(Sour, i, Amount)
        index += 1

    for i in range(1, M + 1):
        Amount = int(data[index])
        FlowSum += Amount
        add_edge(50 + i, Sink, Amount)
        index += 1

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            add_edge(i, 50 + j, 1)

    if max_flow(Sour, Sink) != FlowSum:
        print("-1")
        return

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if Flow[i][50 + j] != 1:
                continue
            change_flow(i, 50 + j)

    for i in range(1, N + 1):
        print("".join(str(Flow[i][50 + j]) for j in range(1, M + 1)))


if __name__ == "__main__":
    main()
