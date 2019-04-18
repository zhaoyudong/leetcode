package me.zhaoyudong;

public class SetZeroes {

    /**
     * 使用首行首列标记当前行或者当前列是否需要全标记为0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        //记录首行首列是否需要为0标记，第一次标记完之后需要遍历首行首列决定对应行列是否为0，
        boolean xmarked0 = false;
        boolean ymarked0 = false;

        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 0) {
                    //标记当前点的对应的x，y首个节点为0
                    if (i == 0) {
                        xmarked0 = true;
                    }

                    if (j == 0) {
                        ymarked0 = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        int[] array = matrix[0];

        // 如果第二次mark不跳过首行首列，会导致第二次标记时 行或者列被误标记
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int j = 1; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                for (int i = 0; i < matrix[j].length; i++) {
                    matrix[j][i] = 0;
                }
            }
        }

        //根据bool值标记首行首列
        if (matrix[0][0] == 0) {
            if (!ymarked0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][0] = 0;
                }
            }

            if (!xmarked0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
    }
}
