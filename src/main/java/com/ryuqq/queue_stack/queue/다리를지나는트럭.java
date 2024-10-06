package com.ryuqq.queue_stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public class Bridge{
        private final int length;
        private final int weight;
        private int currentWeight;
        private Queue<Truck> trucks;


        public Bridge(int length, int weight) {
            this.length = length;
            this.weight = weight;
            this.currentWeight= 0;
            this.trucks = new LinkedList<>();
        }

        public int getLength() {
            return length;
        }

        public void addTruck(Truck truck) {
            truck.setPosition(1);
            trucks.add(truck);
            currentWeight += truck.getWeight();
        }

        public void moveTrucks() {
            for (Truck truck : trucks) {
                truck.move();
            }
        }

        public void removeTruck() {
            if (!trucks.isEmpty() && trucks.peek().getPosition() > length) {
                Truck truck = trucks.poll();
                currentWeight -= truck.getWeight();
            }
        }

        public boolean canAddTruck(Truck truck) {
            return currentWeight + truck.getWeight() <= weight;
        }

        public boolean hasTrucks() {
            return !trucks.isEmpty();
        }

    }

    public class Truck{
        private final int weight;
        private int position;

        public Truck(int weight) {
            this.weight = weight;
            this.position = 0;
        }

        public int getWeight() {
            return weight;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public void move() {
            position++;
        }

    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sec = 0;
        Queue<Truck> waitingQueue = new LinkedList<>();
        for (int w : truck_weights) {
            waitingQueue.add(new Truck(w));
        }

        Bridge bridge = new Bridge(bridge_length, weight);

        while (!waitingQueue.isEmpty() || bridge.hasTrucks()) {
            sec++;


            bridge.moveTrucks();
            bridge.removeTruck();


            if (!waitingQueue.isEmpty() && bridge.canAddTruck(waitingQueue.peek())) {
                Truck truck = waitingQueue.poll();
                bridge.addTruck(truck);
            }
        }

        return sec;
    }

    public static void main(String[] args) {
        다리를지나는트럭 answer = new 다리를지나는트럭();
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int solution = answer.solution(100, 100, truck_weights);
        System.out.println("solution = " + solution);
    }

}
//30723682