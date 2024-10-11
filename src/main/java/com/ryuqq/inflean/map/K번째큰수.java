package com.ryuqq.inflean.map;

import java.util.*;

public class K번째큰수 {

    private static Set<Integer> set = new HashSet<>();


    public static void dfs(int depth, boolean[] visited, int[] arr, int start, int sum){
        if(depth == 3){
            set.add(sum);
            return;
        }else{

            for(int i = start; i < arr.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(depth + 1, visited, arr, i + 1, sum + arr[i]);
                    visited[i] = false;
                }
            }
        }
    }


    public static int solution(int[] arr, int rank) {
        int answer = -1;
        boolean[] visited = new boolean[arr.length];

        dfs(0, visited, arr, 0, 0);

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList, Collections.reverseOrder());

        if (sortedList.size() >= rank) {
            return sortedList.get(rank - 1);  // rank는 1-based index
        } else {
            return -1;  // K번째 값이 없으면 -1 반환
        }

    }


    public static void main(String[] args){
//        Scanner in=new Scanner(System.in);
//        int length = in.nextInt();
//        int rank = in.nextInt();
//
//        int[] arr = new int[length];
//
//        for(int i=0;i<length;i++){
//            arr[i]=in.nextInt();
//        }

        int[] arr = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};
        int answer = solution(arr, 3);
        System.out.print(answer);

    }

}
