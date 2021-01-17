//https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
class CheckLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }

        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];

        for(int i = 2; i < coordinates.length; i++) {
            int deltaX1 = coordinates[i][0] - coordinates[0][0];
            int deltaY1 = coordinates[i][1] - coordinates[0][1];
            if (deltaX * deltaY1 != deltaX1 * deltaY) {
                return false;
            }
        }
        return true;
    }
}
