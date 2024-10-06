package com.ryuqq.toss;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCostCalculator {

    static class AIModel {
        int capacity;
        int cost;
        double costPerUnit;

        public AIModel(int capacity, int cost) {
            this.capacity = capacity;
            this.cost = cost;
            this.costPerUnit = (double) cost / capacity;
        }
    }

    public static int calculateMinimumCost(int[] customerRequests, int[] aiCapacities, int[] aiCosts) {
        int totalCost = 0;

        // AI 모델을 생성하고 비용 대비 처리 효율(costPerUnit)이 낮은 순으로 정렬
        AIModel[] aiModels = new AIModel[aiCapacities.length];
        for (int i = 0; i < aiCapacities.length; i++) {
            aiModels[i] = new AIModel(aiCapacities[i], aiCosts[i]);
        }
        Arrays.sort(aiModels, Comparator.comparingDouble(a -> a.costPerUnit));

        // 각 시간대별로 최소 비용 계산
        for (int requests : customerRequests) {
            int currentCost = 0;
            int remainingRequests = requests;

            // 남은 고객 요청을 처리할 때까지 가장 효율적인 AI 모델을 사용
            for (AIModel aiModel : aiModels) {
                if (remainingRequests <= 0) {
                    break;
                }
                int unitsToUse = Math.min(remainingRequests, aiModel.capacity);  // 처리할 수 있는 최대 고객 수
                int timesToUse = (remainingRequests + aiModel.capacity - 1) / aiModel.capacity;  // 올림 계산

                // 해당 AI 모델을 사용했을 때의 총 비용 계산
                currentCost += timesToUse * aiModel.cost;
                remainingRequests -= unitsToUse;
            }

            totalCost += currentCost;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        // 테스트 데이터
        int[] customerRequests = {23, 40, 15};  // 각 시간대의 고객 상담 요청 수
        int[] aiCapacities = {12, 3, 19};  // 각 AI가 처리할 수 있는 고객 수
        int[] aiCosts = {28, 10, 35};      // 각 AI를 사용하는 비용

        // 최소 비용 계산
        int minimumCost = calculateMinimumCost(customerRequests, aiCapacities, aiCosts);

        // 결과 출력
        System.out.println("최소 비용: " + minimumCost + "원");

    }
}
