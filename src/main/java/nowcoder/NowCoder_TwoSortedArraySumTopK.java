/*输入描述:
        第一行三个整数N, K分别表示数组arr1, arr2的大小，以及需要询问的数
        接下来一行N个整数，表示arr1内的元素
        再接下来一行N个整数，表示arr2内的元素
        输出描述:
        输出K个整数表示答案
        示例1
        输入
        5 4
        1 2 3 4 5
        3 5 7 9 11
        输出
        16 15 14 14


        备注:
        1<=N<=10^5
        0<=arr1i,arr2i<=10^9
        保证：1<=K<=2N*/
package nowcoder;

import java.util.*;

//https://www.nowcoder.com/practice/7201cacf73e7495aa5f88b223bbbf6d1\
//给定两个有序数组arr1和arr2，再给定一个正数K
//求两个数累加和最大的前K个，两个数必须分别来自arr1和arr2
//tips:
//大根堆 sum来组织
//右下角最大，先进大根堆，然后弹出，左边和上面的依次加入
//不要重复加入
//O(K*logK)
// TODO 内存优化
public class NowCoder_TwoSortedArraySumTopK {
    public static class Node {
        public int x;
        public int y;
        public int value;

        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            value = v;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();

        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        int[] res = topK(arr1, arr2, n, k);
        for (int i : res) {
            if (i != k - 1) {
                System.out.print(i + " ");
            } else {
                System.out.print(i);
            }
        }
        in.close();

    }

    public static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }

    public static int[] topK(int[] arr1, int[] arr2, int n, int k) {
        if (arr1 == null || arr2 == null || k < 1) {
            return null;
        }
        //k = Math.min(k, n * n);
        PriorityQueue<Node> heap = new PriorityQueue<>(new MyComparator());
        int biggestIndexOfArr1 = n - 1;
        int biggestIndexOfArr2 = n - 1;
        int biggestSum = arr1[biggestIndexOfArr1] + arr2[biggestIndexOfArr2];
        int[] ans = new int[k];

        // boolean[][] isSet = new boolean[n][n];
        // isSet[n - 1][n - 1] = true;
        HashSet<String> isSet = new HashSet<>();
        heap.add(new Node(biggestIndexOfArr1, biggestIndexOfArr2, biggestSum));
        int ind = 0;
        while (!heap.isEmpty() && k > 0) {
            Node sum = heap.poll();
            ans[ind++] = sum.value;
            //System.out.println("第" + k + "大的数是" + sum.value);
            k--;
            biggestIndexOfArr1 = sum.x;
            biggestIndexOfArr2 = sum.y;
            if (biggestIndexOfArr1 >= 1 && !isSet.contains((biggestIndexOfArr1 - 1)+"_"+(biggestIndexOfArr2))) {
                heap.offer(new Node(biggestIndexOfArr1 - 1, biggestIndexOfArr2, arr1[biggestIndexOfArr1 - 1] + arr2[biggestIndexOfArr2]));
                isSet.add((biggestIndexOfArr1 - 1)+"_"+(biggestIndexOfArr2));
            }
            if (biggestIndexOfArr2 >= 1 && !isSet.contains((biggestIndexOfArr1)+"_"+(biggestIndexOfArr2 - 1))) {
                heap.offer(new Node(biggestIndexOfArr1, biggestIndexOfArr2 - 1, arr1[biggestIndexOfArr1] + arr2[biggestIndexOfArr2 - 1]));
                 isSet.add((biggestIndexOfArr1)+"_"+(biggestIndexOfArr2 - 1));
            }
        }
        return ans;
    }

}
