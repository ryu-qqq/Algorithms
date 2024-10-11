package com.ryuqq.pccp;


import java.util.*;

public class 충돌위험 {

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        Map<Integer, List<Point>> result = new HashMap<>();

        for (int[] route : routes) {

            int currentTime = 0;
            for (int j = 0; j < route.length - 1; j++) {
                int startTarget = route[j];
                int endTarget = route[j + 1];

                int[] startPos = points[startTarget - 1];
                int[] endPos = points[endTarget - 1];

                int startXPos = startPos[0];
                int startYPos = startPos[1];

                int endXPos = endPos[0];
                int endYPos = endPos[1];


                while (startXPos != endXPos) {
                    result.computeIfAbsent(currentTime, k -> new ArrayList<>()).add(new Point(startXPos, startYPos));

                    if (startXPos < endXPos) {
                        startXPos++;
                    } else {
                        startXPos--;
                    }

                    currentTime++;
                }

                while (startYPos != endYPos) {
                    result.computeIfAbsent(currentTime, k -> new ArrayList<>()).add(new Point(startXPos, startYPos));

                    if (startYPos < endYPos) {
                        startYPos++;
                    } else {
                        startYPos--;
                    }

                    currentTime++;
                }
            }

            int lastIdx = route[route.length - 1];
            int[] lastPost = points[lastIdx - 1];
            result.computeIfAbsent(currentTime, k -> new ArrayList<>()).add(new Point(lastPost[0], lastPost[1]));

        }

        for (Integer sec : result.keySet()) {
            List<Point> pointList = result.getOrDefault(sec, new ArrayList<>());

            Map<String, Integer> pointFrequency = new HashMap<>();

            for (Point p : pointList) {
                String pointKey = p.x + "," + p.y;
                pointFrequency.put(pointKey, pointFrequency.getOrDefault(pointKey, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : pointFrequency.entrySet()) {
                int count = entry.getValue();
                if (count > 1) {
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}};

        충돌위험 answer = new 충돌위험();

        int z = answer.solution(points, routes);
        System.out.println("solution = " + z);
    }

}
