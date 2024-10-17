package com.ryuqq.pccp;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class 과제진행하기 {

    public static class Project{

        private String name;
        private LocalTime startTime;
        private long spendingTime;

        public Project(String name, LocalTime startTime, long spendingTime) {
            this.name = name;
            this.startTime = startTime;
            this.spendingTime = spendingTime;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public long getSpendingTime() {
            return spendingTime;
        }

        public String getName() {
            return name;
        }

        public void setSpendingTime(int spendingTime) {
            this.spendingTime = spendingTime;
        }
    }


    public String[] solution(String[][] plans) {
        List<Project> projects = new ArrayList<>();
        Stack<Project> pendingStack = new Stack<>();

        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            LocalTime localTime = LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            Project project = new Project(plan[0], localTime, Integer.parseInt(plan[2]));
            projects.add(project);
        }

        projects.sort(Comparator.comparing(Project::getStartTime));
        List<String> completedProjects = new ArrayList<>();

        LocalTime now;

        for (int i = 0; i < projects.size() - 1; i++) {
            Project p1 = projects.get(i);
            Project p2 = projects.get(i + 1);

            LocalTime currentEndTime = p1.getStartTime().plusMinutes(p1.getSpendingTime());

            //현재 작업이 다음 작업의 시작시간보다 늦게 끝날때
            if(currentEndTime.isAfter(p2.getStartTime())){
                //현재 시간을 다음 작업 시작시간으로 설정
                now = p2.getStartTime();
                int remainingTime = (int) java.time.Duration.between(p2.getStartTime(), currentEndTime).toMinutes();
                //현재 작업 남은시간 재설정
                p1.setSpendingTime(remainingTime);
                pendingStack.push(p1);
            }
            // 현재 작업이 다음 작업의 시작시간보다 빠르게 끝날때
            else{
                completedProjects.add(p1.getName());
                now = currentEndTime;
            }


            while(!pendingStack.isEmpty()){
                Project pendingProject = pendingStack.pop();
                LocalTime pendingEndTime = now.plusMinutes(pendingProject.getSpendingTime());

                //대기중인 작업의 완료시간이 아까프로젝트 시작 전이거나 똑같을때
                if (pendingEndTime.isBefore(p2.getStartTime()) || pendingEndTime.equals(p2.getStartTime())) {
                    // 스택 작업이 끝나면 완료
                    completedProjects.add(pendingProject.getName());
                    now = pendingEndTime; // 시간 업데이트
                } else {
                    int remainingPendingTime = (int) java.time.Duration.between(p2.getStartTime(), pendingEndTime).toMinutes();
                    pendingProject.setSpendingTime(remainingPendingTime);
                    pendingStack.push(pendingProject);
                    break; // 더 이상 처리할 시간이 없으므로 반복 종료
                }
            }


            completedProjects.add(projects.get(projects.size() - 1).getName());

            // 남은 스택 작업 처리
            while (!pendingStack.isEmpty()) {
                completedProjects.add(pendingStack.pop().getName());
            }

        }
        return completedProjects.toArray(new String[0]);
    }


}
