//package baekjoon.bronze.level3;
//
//import java.io.*;
//import java.util.*;
//
//public class Test_1 {
//    static int maxEarnings = 0;
//    static boolean[] visited;
//    static PriorityQueue<int[]> queue;
//    public static void main(String[] args) {
//        int[][] jobs = {
//                {3, 6, 3},
//                {2, 4, 2},
//                {10, 12, 8},
//                {11, 15, 5},
//                {1, 8, 10},
//                {12, 13, 1},
//        };
//
//        queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
//        for(int[] job : jobs){
//            queue.offer(job);
//        }
//
//        dfs(0, 0, new ArrayList<>());
//        System.out.println(maxEarnings);
//    }
//
//    public static void dfs(int currentTime, int currentEarnings, ArrayList<int[]> selectedJobs) {
//        maxEarnings = Math.max(maxEarnings, currentEarnings);
//
//        PriorityQueue<int[]> tempQueue = new PriorityQueue<>(queue);
//        while (!tempQueue.isEmpty()) {
//            int[] job = tempQueue.poll();
//            if (job[0] >= currentTime) {
//                selectedJobs.add(job);
//                dfs(job[1], currentEarnings + job[2], selectedJobs);
//                selectedJobs.remove(selectedJobs.size() - 1);
//            }
//        }
//    }
//}
//
//

package baekjoon.bronze.level3;

import java.io.*;
import java.util.*;

public class Test_1 {
    static int maxEarnings = 0;

    public static void main(String[] args) {
        int[][] jobs = {
                {3, 6, 3},
                {2, 4, 2},
                {10, 12, 8},
                {11, 15, 5},
                {1, 8, 10},
                {12, 13, 1},
        };

        Arrays.sort(jobs, (a,b) -> a[1] - b[1]);

        // DFS 호출
        dfs(0, 0, new ArrayList<>(), jobs);
        System.out.println(maxEarnings);
    }

    public static void dfs(int currentTime, int currentEarnings, ArrayList<int[]> selectedJobs, int[][] jobs) {
        // 최대 수익 업데이트
        maxEarnings = Math.max(maxEarnings, currentEarnings);

        for (int i = 0; i < jobs.length; i++) {
            if (currentTime <= jobs[i][0]) {
                selectedJobs.add(jobs[i]);
                dfs(jobs[i][1], currentEarnings + jobs[i][2], selectedJobs, jobs);
                selectedJobs.remove(selectedJobs.size() - 1);
            }
        }
    }
}