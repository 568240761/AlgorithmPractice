public class Practice1_1 {
    public static boolean find(int target, int[][] array) {
        if (array != null) {
            //获取行数
            int line = array.length;
            //获取列数
            int column = array[0].length;

            //列数不能等于0
            if (column <= 0)
                return false;

            /*
             每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序；
             如下二维数组：
             {
                 {1, 2, 8, 9},
                 {2, 4, 9, 12},
                 {4, 7, 10, 13},
                 {6, 8, 11, 15}
             }
             不难发现数字6是第一列中的最大值，但在最后一行中是最小值，所以可以考虑使用二分思想来查找，避免逐个比较。
             我们把二维数组中的数字再重新排列一下，如下：
             1,2,4,6,8,11,15
             2,4,7,10,13
             8,9,12
             9
            */
            int j = 0;
            for (int i = line - 1; i >= 0; i--) {
                int temp = array[i][j];
                if (temp == target) {
                    return true;
                } else if (temp < target) {
                    if (j < column - 1) {
                        for (int s = j + 1; s < column; s++) {
                            temp = array[i][s];
                            if (temp == target) {
                                return true;
                            } else if (temp > target) {
                                break;
                            }
                        }
                    }
                } else {
                    if (i > 0) {
                        for (int s = i - 1; s >= 0; s--) {
                            temp = array[s][j];
                            if (temp == target) {
                                return true;
                            } else if (temp < target) {
                                break;
                            }
                        }
                    }
                }

                j++;
                if (j >= column)
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] array = {{}};
        boolean flag = find(1, array);
        System.out.println("result=" + flag);
    }
}
