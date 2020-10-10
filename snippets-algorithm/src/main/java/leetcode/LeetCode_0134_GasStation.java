package leetcode;

import java.util.LinkedList;

//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//        Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
//
//        Note:
//
//        If there exists a solution, it is guaranteed to be unique.
//        Both input arrays are non-empty and have the same length.
//        Each element in the input arrays is a non-negative integer.
//        Example 1:
//
//        Input:
//        gas  = [1,2,3,4,5]
//        cost = [3,4,5,1,2]
//
//        Output: 3
//
//        Explanation:
//        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//        Travel to station 4. Your tank = 4 - 1 + 5 = 8
//        Travel to station 0. Your tank = 8 - 2 + 1 = 7
//        Travel to station 1. Your tank = 7 - 3 + 2 = 6
//        Travel to station 2. Your tank = 6 - 4 + 3 = 5
//        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//        Therefore, return 3 as the starting index.
//        Example 2:
//
//        Input:
//        gas  = [2,3,4]
//        cost = [3,4,3]
//
//        Output: -1
//
//        Explanation:
//        You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
//        Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//        Travel to station 0. Your tank = 4 - 3 + 2 = 3
//        Travel to station 1. Your tank = 3 - 3 + 3 = 3
//        You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
//        Therefore, you can't travel around the circuit once no matter where you start.
public class LeetCode_0134_GasStation {


    // 滑动窗口内的最大值和，最小值（双端队列，存下标，不要存值）
    /*
     * 这个方法的时间复杂度O(N)，额外空间复杂度O(N)
     */
    // tips, 纯能值数组（本身加油站扣去距离，还剩多少?） 累加没有小于0的，就是良好出发点
    // 纯能值数组的前缀和数组
    // 2倍的前缀和数组（考察窗口最小值是不是小于0）
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int N = gas.length;
        int[] r = new int[N];
        for (int i = 0; i < N; i++) {
            r[i] = gas[i] - cost[i];
        }
        int R = N << 1;
        int[] p = new int[N << 1];
        p[0] = r[0];
        for (int i = 1; i < N; i++) {
            p[i] = r[i] + p[i - 1];
        }
        for (int i = 0; i < N; i++) {
            p[i + N] = r[i] + p[i + N - 1];
        }
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] res = new boolean[R - N + 1];
        int index = 0;
        for (int i = 0; i < R; i++) {
            while (!q.isEmpty() && p[i] <= p[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            if (q.peekFirst() == (i - N)) {
                q.pollFirst();
            }
            if (i >= N - 1) {
                if (i == N - 1) {
                    res[index++] = (p[q.peekFirst()] >= 0);
                } else {
                    res[index++] = ((p[q.peekFirst()] - p[i - N]) >= 0);
                }

            }
        }
        for (int i = 0; i < R - N + 1; i++) {
            if (res[i]) {
                return i;
            }
        }
        return -1;
    }
    /*
     * TODO 这个方法的时间复杂度O(N)，额外空间复杂度O(1）
     */
    public static int canCompleteCircuit2(int[] oil, int[] dis) {
        return -1;
    }


}
