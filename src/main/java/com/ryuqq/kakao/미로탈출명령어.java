package com.ryuqq.kakao;


public class 미로탈출명령어 {

    private static final char[] DIRECTION = {'d', 'l', 'r', 'u'};
    private static final int[] xDirection = {1, 0, 0, -1};
    private static final int[] yDirection = {0, -1, 1, 0};

    private String answer = "impossible";
    private boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(r - x) + Math.abs(c - y);

        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        dfs(n, m, x, y, r, c, k, new StringBuilder());

        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int remainingSteps, StringBuilder path) {
        if (found) return;

        if (remainingSteps == 0) {
            if (x == r && y == c) {
                answer = path.toString();
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + xDirection[i];
            int ny = y + yDirection[i];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                int newDistance = Math.abs(r - nx) + Math.abs(c - ny);
                if (newDistance <= remainingSteps - 1) {
                    path.append(DIRECTION[i]);
                    dfs(n, m, nx, ny, r, c, remainingSteps - 1, path);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        미로탈출명령어 answer= new 미로탈출명령어();
        String solution = answer.solution(3, 4, 2, 3, 3, 1, 5);
    }
}
