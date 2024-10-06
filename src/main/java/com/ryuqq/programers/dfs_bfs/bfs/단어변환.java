package com.ryuqq.programers.dfs_bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {


    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words){
        int count = 0;

        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        while (!queue.isEmpty()){
            for (int i =0; i<queue.size(); i++) {
                String poll = queue.poll();

                if (poll.equals(target)){
                    return count;
                }

                for(int j =0; j<words.length; j++){
                    if(!visited[j] && canChange(poll, words[j])){
                        visited[j] = true;
                        queue.add(words[j]);
                    }
                }
            }

            count++;
        }

        return 0;
    }

    private boolean canChange(String begin, String target){
        int count = 0;
        for(int i=0; i < begin.toCharArray().length; i ++){
            if(begin.charAt(i) != target.charAt(i)){
                count++;
                if(count > 1) return false;
            }
        }
        return true;
    }

}
