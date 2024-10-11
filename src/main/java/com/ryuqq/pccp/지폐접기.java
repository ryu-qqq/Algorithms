package com.ryuqq.pccp;

public class 지폐접기 {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int x = wallet[0];
        int y = wallet[1];

        if(x < y){
            x = wallet[1];
            y = wallet[0];
        }

        int x1 = bill[0];
        int y1 = bill[1];

        if(x1 < y1){
            x1 = bill[1];
            y1 = bill[0];
        }

        while(x1 > x || y1 > y){

            int mid = x1 / 2;

            int temp = y1;
            y1 = mid;
            x1 = temp;

            answer++;

            if(x1 <=x && y1 <=y){
                break;
            }

            if(x1 < y1){
                x1 = y1;
                y1 = temp;
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        지폐접기 answer = new 지폐접기();
        int[] wallet = new int[]{50, 50};
        int[] bill = new int[]{100, 241};

        int solution = answer.solution(wallet, bill);
        System.out.println(solution);
    }

}
