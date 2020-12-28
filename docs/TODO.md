[TODO]
AVL, SBT, 红黑树
AC自动机


[TODO]
给定一个正整数M，请构造出一个长度为M的数组arr，要求
对任意的i、j、k三个位置，如果i<j<k，都有arr[i] + arr[k] != 2*arr[j]
返回构造出的arr
tips:
长度为1，满足
假设 a + b != 2*c
-> 2 * a - 1 + 2 * b - 1 != 2 * c - 1
2 * a + 2 * b != 2 * c

[a,b,c]
->[2 * a - 1, 2 * b - 1, 2 * c - 1, 2 * a, 2 * b, 2 * c]

[1,5,3]
->[1,9,5,2,10,6]

长度为M，只需要一个(M + 1)/2长度的种子

复杂度估计
T(N) = T(N/2) + O(N)

空间复杂度可以做到O(1)


[TODO]
有n个打包机器从左到右一字排开，上方有一个自动装置会抓取一批放物品到每个打 包机上，放到每个机器上的这些物品数量有多有少，由于物品数量不相同，需要工人 将每个机器上的物品进行移动从而到达物品数量相等才能打包。每个物品重量太大、 每次只能搬一个物品进行移动，为了省力，只在相邻的机器上移动。请计算在搬动最 小轮数的前提下，使每个机器上的物品数量相等。如果不能使每个机器上的物品相同， 返回-1。 例如[1,0,5]表示有3个机器，每个机器上分别有1、0、5个物品，经过这些轮后: 
第一轮:1    0 <- 5 => 1 1 4
第二轮:1 <- 1 <- 4 => 2 1 3
第三轮:2    1 <- 3 => 2 2 2 
移动了3轮，每个机器上的物品相等，所以返回3
例如[2,2,3]表示有3个机器，每个机器上分别有2、2、3个物品， 这些物品不管怎么移动，都不能使三个机器上物品数量相等，返回-1
tips: 所有数的累加和 % N != 0, 怎么都无法做到

考虑i位置，
左有 ，左余
右有，右余
预处理数组，累加和


[TODO]
给定一个有序数组arr，给定一个正数aim

1）返回累加和为aim的，所有不同二元组
双指针
[L] + [R] > aim
[L] + [R] < aim
[L] + [R] = aim
   L - 1 和 L 位置的数不等于的时候 收集答案
2）返回累加和为aim的，所有不同三元组
遍历每个位置，剩余位置 根据 找二元组的算法找出aim — [i] 的所有二元组


[TODO]
长度为N的数组arr，一定可以组成N^2个数值对。
例如arr = [3,1,2]，
数值对有(3,3) (3,1) (3,2) (1,3) (1,1) (1,2) (2,3) (2,1) (2,2)，
也就是任意两个数都有数值对，而且自己和自己也算数值对。
数值对怎么排序？规定，第一维数据从小到大，第一维数据一样的，第二维数组也从小到大。所以上面的数值对排序的结果为：
(1,1)(1,2)(1,3)(2,1)(2,2)(2,3)(3,1)(3,2)(3,3)

给定一个数组arr，和整数k，返回第k小的数值对。

tips:
第一个数字定位
第二个数字定位
无序数组求第K小 bfprt和快排改进


[TODO]
给定一个有序数组arr，从左到右依次表示X轴上从左往右点的位置
给定一个正整数K，返回如果有一根长度为K的绳子，最多能盖住几个点
绳子的边缘点碰到X轴上的点，也算盖住

tips：
暴力方法：
贪心，绳子边缘没必要不压中某个点
以每个位置作为结尾来找，假设某个位置是103，长度是5，
其实就是找[0，102]范围内>=98的最左的点
O(N*logN)
最优解
长度和范围有单调性 -> 滑动窗口，左右指针


[TODO]
给定一个二叉树的头节点head，路径的规定有以下三种不同的规定：

1）路径必须是头节点出发，到叶节点为止，返回最大路径和 

2）路径可以从任何节点出发，但必须往下走到达任何节点，返回最大路径和

3）路径可以从任何节点出发，到任何节点，返回最大路径和




[TODO]
括号有效配对是指：
1）任何一个左括号都能找到和其正确配对的右括号
2）任何一个右括号都能找到和其正确配对的左括号
有效的：    (())  ()()   (()())  等
无效的：     (()   )(     等
问题一：怎么判断一个括号字符串有效？
问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效

问题1，用一个count变量
遇到左括号 count++
遇到右括号 count--
如果过程中count<0 直接返回无效
最后count==0 返回有效

问题2，用一个count和need变量
如果count == -1， need++， count恢复成0
到最后count == 0 ， 返回need，到最后count不等于0，返回need + count


[TODO]
括号有效配对是指：
1）任何一个左括号都能找到和其正确配对的右括号
2）任何一个右括号都能找到和其正确配对的左括号
返回一个括号字符串中，最长的括号有效子串的长度
tips:
枚举每个位置结尾的答案

[TODO]
括号最大嵌套层数

[TODO]
每种工作有难度和报酬，规定如下
class Job {
public int money;// 该工作的报酬
public int hard; // 该工作的难度
}
给定一个Job类型的数组jobarr，表示所有岗位，每个岗位都可以提供任意份工作
选工作的标准是在难度不超过自身能力值的情况下，选择报酬最高的岗位
给定一个int类型的数组arr，表示所有人的能力
返回int类型的数组，表示每个人按照标准选工作后所能获得的最高报酬

排序
难度一样，只保留最高报酬的
难度更大，报酬却更小的也删掉
然后加入有序表，找离自己最近的最大的值

[TODO]
背包容量为w
一共有n袋零食, 第i袋零食体积为v[i] 
总体积不超过背包容量的情况下，
一共有多少种零食放法？(总体积为0也算一种放法)。

[TODO]
1. 给定一个二维数组matrix，其中每个数都是正数，要求从左上到右下
每一步只能向右或者向下，沿途经过的数字要累加起来
最后请返回最小的路径和

2. 最长公共子序列问题

3. 最长公共子串问题（空间压缩极致用法，二维的非最优解，最优解来自后缀数组）

tips:
动态规划的空间压缩技巧！

[TODO]
给定一个由字符串组成的数组String[] strs，给定一个正数K

返回词频最大的前K个字符串，假设结果是唯一的
tips:
Hash表+小根堆

[TODO]
请实现如下结构：
TopRecord{
public TopRecord(int K)  :  构造时事先指定好K的大小，构造后就固定不变了
public  void add(String str)  :   向该结构中加入一个字符串，可以重复加入
public  List<String> top() : 返回之前加入的所有字符串中，词频最大的K个
}
要求： 
add方法，复杂度O(log K);
top方法，复杂度O(K)

tips:
手写堆



Leetcode 845 最长山脉问题 【单调栈】
Leetcode 683 K个空花盆
Leetcode 568 最大休假天数

相关题目
LeetCode

1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target

LintCode
406. 和大于S的最小子数组
https://www.lintcode.com/problem/minimum-size-subarray-sum/description