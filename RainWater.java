//https://leetcode-cn.com/problems/trapping-rain-water/

class RainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3 ){
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        rightMax[height.length - 1] = 0;
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        
        return  result;
    }
}
