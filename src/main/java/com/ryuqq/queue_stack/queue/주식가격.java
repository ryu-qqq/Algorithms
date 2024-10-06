package com.ryuqq.queue_stack.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 주식가격 {

    public class Stock{

        private int price;
        private int sec;

        public Stock(int price) {
            this.price = price;
            this.sec = 0;
        }

        public void plus(){
            this.sec++;
        }

        public int getPrice() {
            return price;
        }
    }

    public int[] solution(int[] prices) {

        Queue<Stock> queue = new LinkedList<>();
        List<Stock> charts = new ArrayList<>();

        for(Integer price : prices){
            queue.add(new Stock(price));
        }

        while(!queue.isEmpty()){
            Stock poll = queue.poll();

            for(Stock stock : queue){
                poll.plus();

                if(stock.getPrice() < poll.getPrice()){
                    break;
                }
            }

            charts.add(poll);

        }


        return charts.stream()
                .mapToInt(stock -> stock.sec)
                .toArray();
    }


    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};
        주식가격 answer = new 주식가격();
        int[] solution = answer.solution(prices);
        System.out.println("solution = " + solution);

    }

}
