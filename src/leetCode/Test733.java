package leetCode;

/**
 * DFS/BFS
 * 733. 图像渲染
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，
 * 重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回金国上色先软后的图像。
 * */

public class Test733 {
    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0},{1,0,1}};
        int[][] newImage = new Solution733().floodFill(image, 1, 1, 2);

        for (int[] row : newImage) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return dfs(image, sr, sc, newColor, image[sr][sc]);
    }

    private int[][] dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length
            || image[i][j] == newColor || image[i][j] != oldColor) {

        } else {
            image[i][j] = newColor;
            dfs(image, i + 1, j, newColor, oldColor);
            dfs(image, i - 1, j, newColor, oldColor);
            dfs(image, i, j + 1, newColor, oldColor);
            dfs(image, i, j - 1, newColor, oldColor);
        }

        return image;
    }
}