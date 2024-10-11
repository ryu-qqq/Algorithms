package com.ryuqq.kakao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 가장많이받은선물 {

    public static class Friend{
        private String name;
        private int giveCount;
        private int receiveCount;
        private int giftLevel;
        private Map<Friend, Integer> giftHistory;

        public Friend(String name) {
            this.name = name;
            this.giftHistory = new HashMap<>();
        }

        public void addGiveCount(Friend friend) {
            giveCount++;
            giftHistory.put(friend, giftHistory.getOrDefault(friend, 0) + 1);
            setGiftLevel();
        }

        public void addReceiveCount() {
            receiveCount++;
            setGiftLevel();
        }

        private void setGiftLevel() {
            giftLevel = giveCount - receiveCount;
        }

        public int getGiftLevel() {
            return giftLevel;
        }

        public int getGiftHistoryCount(Friend friend) {
            return giftHistory.getOrDefault(friend, 0);
        }
    }


    public int solution(String[] friends, String[] gifts) {
        Map<String, Friend> friendsMap = new HashMap<>();

        for(String friend : friends) {
            friendsMap.put(friend, new Friend(friend));
        }

        for(String gift : gifts) {
            String[] split = gift.split(" ");
            Friend giver = friendsMap.get(split[0]);
            Friend receiver = friendsMap.get(split[1]);

            giver.addGiveCount(receiver);
            receiver.addReceiveCount();
        }

        List<Friend> list = friendsMap.values().stream().toList();

        int maxGiftCount = Integer.MIN_VALUE;

        for(int i =0; i < list.size(); i++) {
            Friend giver = list.get(i);

            int giftCount = 0;

            for(int j =0; j < list.size(); j++) {
                if(i != j){
                    Friend receiver = list.get(j);

                    int giverGiftHistoryCount = giver.getGiftHistoryCount(receiver);
                    int receiverGiftHistoryCount = receiver.getGiftHistoryCount(giver);

                    if(giverGiftHistoryCount > receiverGiftHistoryCount) {
                        giftCount++;
                    }

                    if(giverGiftHistoryCount == receiverGiftHistoryCount) {
                        int giverGiftLevel = giver.getGiftLevel();
                        int receiverGiftLevel = receiver.getGiftLevel();

                        if(giverGiftLevel > receiverGiftLevel) {
                            giftCount++;
                        }

                    }
                }
            }
            maxGiftCount = Math.max(maxGiftCount, giftCount);
        }


        return maxGiftCount;
    }

}
