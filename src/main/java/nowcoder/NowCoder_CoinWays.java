/*链接：https://www.nowcoder.com/questionTerminal/93bcd2190da34099b98dfc9a9fb77984
        来源：牛客网

        现有n1+n2种面值的硬币，其中前n1种为普通币，可以取任意枚，后n2种为纪念币， 每种最多只能取一枚，每种硬币有一个面值，问能用多少种方法拼出m的面值?


        输入描述:
        第一行输入三个整数n1,n2,m        n1,n2<=1000 m<=100000
        第二行输入n1个整数表示普通币的面值
        第三行输入n2个整数表示纪念币的面值
        不同的硬币面值可能相同


        输出描述:
        使用编号不同但面值相同的硬币算不同的拼法
        输出用多少种方法拼出m的面值，由于答案过大，对1e9 + 7取模
        示例1
        输入
        5 5 100
        87 76 15 79 53
        1 94 59 30 5
        输出
        2
        说明
        1+94+5
        79+15+5+1*/
package nowcoder;

import java.util.Scanner;

public class NowCoder_CoinWays {
    static int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int m = in.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        String numOfArr1 = in.next();
        String[] arr1Ele = numOfArr1.split(" ");
        for (int i = 0; i < arr1Ele.length; i++) {
            arr1[i] = Integer.parseInt(arr1Ele[i]);
        }
        String numOfArr2 = in.next();
        String[] arr2Ele = numOfArr2.split(" ");
        for (int i = 0; i < arr2Ele.length; i++) {
            arr2[i] = Integer.parseInt(arr2Ele[i]);
        }
        System.out.println(ways(arr1, arr2, m));
        in.close();
    }

    public static int ways(int[] many, int[] one, int target) {
        if (target < 0) {
            return 0;
        }
        if (many == null || many.length == 0 || one == null || one.length == 0) {
            return target == 0 ? 1 : 0;
        }
        int[][] dpOne = one(one, target);
        int[][] dpMany = many(many, target);
        long answer = 0;
        for (int i = 0; i <= target; i++) {
            answer += dpMany[many.length - 1][i] * dpOne[one.length - 1][target - i];
        }
        return (int) (answer % MOD);
    }

    // TODO
	// dp[i][j] 0..i自由选择纪念币， 搞定j元， 有多少方法？
    public static int[][] one(int[] one, int target) {
        int[][] dp = new int[one.length][target + 1];
        return null;
    }
    // dp[i][j] 0..i自由选择普通币， 搞定j元， 有多少方法？
    public static int[][] many(int[] many, int target) {
        return null;
    }
}