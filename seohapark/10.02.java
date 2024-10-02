import java.util.*;

public class Solution {
    static class State {
        int red_x, red_y, blue_x, blue_y, moves;

        public State(int red_x, int red_y, int blue_x, int blue_y, int moves) {
            this.red_x = red_x;
            this.red_y = red_y;
            this.blue_x = blue_x;
            this.blue_y = blue_y;
            this.moves = moves;
        }
    }

    static int n, m;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        int red_x = 0, red_y = 0, blue_x = 0, blue_y = 0;

        // 보드 초기화
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    red_x = i;
                    red_y = j;
                } else if (board[i][j] == 'B') {
                    blue_x = i;
                    blue_y = j;
                }
            }
        }

        visited = new boolean[n][m][n][m]; // 빨간 구슬과 파란 구슬의 방문 여부
        int result = bfs(red_x, red_y, blue_x, blue_y);
        System.out.println(result);
    }

    static int bfs(int red_x, int red_y, int blue_x, int blue_y) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(red_x, red_y, blue_x, blue_y, 0));
        visited[red_x][red_y][blue_x][blue_y] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 최대 10번 움직임
            if (current.moves >= 10) {
                return -1;
            }

            for (int d = 0; d < 4; d++) {
                int next_red_x = current.red_x, next_red_y = current.red_y;
                int next_blue_x = current.blue_x, next_blue_y = current.blue_y;
                boolean red_in_hole = false, blue_in_hole = false;

                // 빨간 구슬 이동
                while (true) {
                    if (board[next_red_x + dx[d]][next_red_y + dy[d]] == '#') break;
                    if (board[next_red_x + dx[d]][next_red_y + dy[d]] == 'O') {
                        red_in_hole = true;
                        break;
                    }
                    next_red_x += dx[d];
                    next_red_y += dy[d];
                }

                // 파란 구슬 이동
                while (true) {
                    if (board[next_blue_x + dx[d]][next_blue_y + dy[d]] == '#') break;
                    if (board[next_blue_x + dx[d]][next_blue_y + dy[d]] == 'O') {
                        blue_in_hole = true;
                        break;
                    }
                    next_blue_x += dx[d];
                    next_blue_y += dy[d];
                }

                // 빨간 구슬이 구멍에 들어가면 성공
                if (red_in_hole && !blue_in_hole) {
                    return current.moves + 1;
                }

                // 파란 구슬이 구멍에 들어가면 실패
                if (blue_in_hole) {
                    continue;
                }

                // 구슬이 같은 위치에 있을 경우 처리
                if (next_red_x == next_blue_x && next_red_y == next_blue_y) {
                    // 이동 거리가 더 큰 구슬을 한 칸 뒤로 이동
                    if (Math.abs(next_red_x - current.red_x) + Math.abs(next_red_y - current.red_y) >
                        Math.abs(next_blue_x - current.blue_x) + Math.abs(next_blue_y - current.blue_y)) {
                        next_red_x -= dx[d];
                        next_red_y -= dy[d];
                    } else {
                        next_blue_x -= dx[d];
                        next_blue_y -= dy[d];
                    }
                }

                // 방문하지 않은 상태면 큐에 추가
                if (!visited[next_red_x][next_red_y][next_blue_x][next_blue_y]) {
                    visited[next_red_x][next_red_y][next_blue_x][next_blue_y] = true;
                    queue.add(new State(next_red_x, next_red_y, next_blue_x, next_blue_y, current.moves + 1));
                }
            }
        }
        return -1; // 실패
    }
}
