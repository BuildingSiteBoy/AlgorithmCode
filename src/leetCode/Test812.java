package leetCode;

/**
 * 812. 最大三角形面积
 * 三角形面积 S = |x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2| / 2;
 * 使用枚举法求解
 *
 * @author 曾奕
 */
public class Test812 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res = Math.max(res, area(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return res;
    }

    private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2) * 0.5;
    }
}
