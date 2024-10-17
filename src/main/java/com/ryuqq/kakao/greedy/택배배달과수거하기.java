package com.ryuqq.kakao.greedy;

/**
 * 2023 kakao blind
 */

public class 택배배달과수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long dist = 0;
        int deliveryCnt =0;
        int pickupCnt =0;

        for(int i = n-1; i >= 0; i--) {
            deliveryCnt += deliveries[i];
            pickupCnt += pickups[i];

            while(deliveryCnt > 0 || pickupCnt > 0) {
                deliveryCnt -= cap;
                pickupCnt -= cap;
                dist += (i+1) * 2L;
            }
        }

        return dist;
    }

    public long solution2(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;

        int idx = n - 1;  // 마지막 집부터 시작

        while (idx >= 0) {
            // 배달 및 수거할 물량이 남아있는 가장 멀리 있는 집을 찾음
            while (idx >= 0 && deliveries[idx] == 0 && pickups[idx] == 0) {
                idx--; // 배달할 물건과 수거할 물건이 모두 없는 집은 패스
            }

            if (idx < 0) break;  // 더 이상 배달/수거할 물건이 없다면 종료

            // 이번 배달에서 가장 멀리 있는 집까지의 거리
            int furthestHouse = idx + 1;  // 1-based 인덱스이므로 +1

            // 트럭의 남은 용량
            int deliveryCapacity = cap;
            int pickupCapacity = cap;

            // 이번 배달로 가능한 만큼 배달/수거 진행
            for (int i = idx; i >= 0; i--) {
                // 현재 집에 배달할 수 있는 양
                if (deliveries[i] > 0) {
                    int deliverAmount = Math.min(deliveryCapacity, deliveries[i]);
                    deliveries[i] -= deliverAmount;
                    deliveryCapacity -= deliverAmount;
                }

                // 현재 집에서 수거할 수 있는 양
                if (pickups[i] > 0) {
                    int pickupAmount = Math.min(pickupCapacity, pickups[i]);
                    pickups[i] -= pickupAmount;
                    pickupCapacity -= pickupAmount;
                }

                // 트럭 용량이 모두 찼다면 이번 배달은 여기까지
                if (deliveryCapacity == 0 && pickupCapacity == 0) {
                    break;
                }
            }

            // 가장 멀리 있는 집까지 왕복한 거리를 추가
            totalDistance += furthestHouse * 2L;
        }

        return totalDistance;
    }
}
