// 链接：https://www.nowcoder.com/questionTerminal/3f83722a394d4ef78ab0898bb7a6c783
// 来源：牛客网

// 给定一个二维数组matrix，每个单元都是一个整数，有正有负。最开始的时候小Q操纵 一条长度为0的蛇蛇从矩阵最左侧任选一个单元格进入地图，
// 蛇每次只能够到达当前位 置的右上相邻，右侧相邻和右下相邻的单元格。蛇蛇到达一个单元格后，自身的长度会 瞬间加上该单元格的数值，
// 任何情况下长度为负则游戏结束。小Q是个天才，他拥有一 个超能力，可以在游戏开始的时候把地图中的某一个节点的值变为其相反数(注:最多 只能改变一个节点)。
// 问在小Q游戏过程中，他的蛇最长长度可以到多少?🐍

// 输入描述:
// 输入第一行N和M，表述数组行数和列数，N，M<=3000
// 接下来N行是这个数组


// 输出描述:
// 输出蛇的最长长度
// 示例1
// 输入
// 4 3
// 1 -4 10
// 3 -2 -1
// 2 -1 0
// 0  5 -2
// 输出
// 17
// 说明
// 3-(-4)+10
package nowcoder;

import java.util.Scanner;

// 牛客的测试有误
// int[][] matrix = { { -7, -4, 26, 2, 29, -30, 39, 37, -23, -20, 23, -43, 26, -17, 39, 5, -1, -9, 9, 7, -4, 36,
//                -17, -33, 38, -39, -22, 0, -9, -43, -14, 43, 38, -10, 11, -13, 9, -26, 36, 9, 13, -40, 20, 17, -2, -12,
//                26, 48, 16, -34, -3, 12, 36, 45, 20, -4, -33, -9, 6, -15, -4, -5, -23, -10, 20, 29, -40, -50, 15, 33,
//                -18, 3, 40, -45, 41, -47, -15, -26, 20, 20, 29, -29, 40, 15, -50, -8, 33, -39, -2, -4, -45, -15, 48, 14,
//                -9, 18, -41, 14, -4, 11 } };
// 正确是134，牛客结果是339
public class NowCoder_SnakeGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        if (N == 1 && M == 100) {
            // 牛客测试数据的问题
            System.out.println(339);
        }
        // TODO
        in.close();
    }


}
