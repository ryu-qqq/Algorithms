package com.ryuqq.programers.graph;

public class 순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] wins = new boolean[n + 1][n + 1];

        for(int[] result: results) {
            int winner = result[0];
            int loser = result[1];
            wins[winner][loser] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (wins[i][k] && wins[k][j]) {
                        wins[i][j] = true; // i 선수가 k 선수를 이기고, k 선수가 j 선수를 이겼다면, i는 j를 이긴다.
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (wins[i][j] || wins[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        순위 answer = new 순위();

        int[][] arr = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        int solution = answer.solution(5, arr);
        System.out.println("solution = " + solution);
    }

}
