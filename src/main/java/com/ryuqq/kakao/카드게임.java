package com.ryuqq.kakao;

import java.util.*;


public class 카드게임 {

    private static boolean[] visited;
    private static boolean flag = true;
    private static int remainCoin;

    public static void isNextProcess(List<Integer> cardList, int[] cards, int targetNumber){

        for(int i = 0; i < cards.length/ 3; i++){
            for(int j= i + 1; j < cards.length / 3; j++){
                if (cardList.get(i) + cardList.get(j) == targetNumber && !visited[i] && !visited[j]) {
                    visited[i] = true;
                    visited[j] = true;
                    return;
                }
            }
        }

        for(int i = 0; i < cardList.size() - 1; i++){
            for(int j= i + 1; j < cardList.size(); j++){
                if(cardList.get(i) + cardList.get(j) == targetNumber &&  !visited[i] && !visited[j]){
                    visited[i] = true;
                    visited[j] = true;

                    if(i >= cards.length / 3 ){
                        remainCoin--;
                    }

                    if(j >= cards.length / 3){
                        remainCoin--;
                    }
                    return;
                }
            }
        }


        flag = false;
    }



    public static int solution(int coin, int[] cards) {
        List<Integer> cardList = new ArrayList<>();
        visited = new boolean[cards.length];
        remainCoin = coin;
        int round = 1;

        for(int i = 0; i < cards.length / 3; i++) {
            cardList.add(cards[i]);
        }

        int targetNumber = 1 + cards.length;

        for(int i = cards.length / 3; i < cards.length; i+= 2) {
            cardList.add(cards[i]);
            cardList.add(cards[i+ 1]);

            flag = true;


            isNextProcess(cardList, cards, targetNumber);
            if(remainCoin < 0 || !flag){
                return round;
            }

            round ++;
        }


        return round;
    }

}
