public class Main {
    public static int trap(int[] height) {
        int len = height.length;
        if (len == 1) {
            return 0;
        }

        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        int result=0;
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i=0;i<len;i++){
            result += Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // {0,1,0,2,1,0,1,3,2,1,2,1}  6
        //             {4,2,0,3,2,5}  9
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
