//https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
class MinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int result = 0;
        if (points.length == 0)
            return result;

        int minRight = points[0][1];
        result++;
        int[] currentBalloon = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > minRight){
                result++;
                minRight = points[i][1];
            } else if(points[i][1] < minRight){
                minRight = points[i][1];
            }
        }
        return result;
    }
}
