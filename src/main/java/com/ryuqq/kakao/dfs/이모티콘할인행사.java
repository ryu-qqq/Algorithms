package com.ryuqq.kakao.dfs;

public class 이모티콘할인행사 {

    public int[] calculate(int[] arr, int[][] users, int[] emoticons){
        int membershipCnt = 0;
        int benefit =0;

        for(int[] user: users){
            int discount = user[0];
            int limit = user[1];
            int spendingMoney = 0;

            for(int i = 0; i <emoticons.length; i ++){
                if(arr[i] >= discount){
                    spendingMoney += ((100 - arr[i]) * 0.01) * emoticons[i];
                }
            }

            if(limit <= spendingMoney){
                membershipCnt++;
            }else{
                benefit += spendingMoney;
            }
        }

        return new int[]{membershipCnt, benefit};
    }



    public void dfs(int[] arr, int[] discountArr, int[][]users, int[] emoticons, int[] answer, int depth){
        if(depth == emoticons.length){
            int[] calculate = calculate(arr, users, emoticons);

            if(calculate[0] > answer[0] || calculate[0] == answer[0] && calculate[1] > answer[1]){
                answer[0] = calculate[0];
                answer[1] = calculate[1];
            }

            return;
        }


        for(int discount : discountArr){
            arr[depth] = discount;
            dfs(arr, discountArr, users, emoticons, answer, depth + 1);
        }

    }


    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] discountArr = {40, 30, 20 ,10};
        int[] arr = new int[emoticons.length];

        dfs(arr, discountArr, users, emoticons, answer, 0);
        return answer;
    }

    public static void main(String[] args) {
        이모티콘할인행사 answer = new 이모티콘할인행사();

        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        int[] solution = answer.solution(users, emoticons);
        System.out.println(solution);
    }

}
