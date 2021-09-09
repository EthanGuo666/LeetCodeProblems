public class Main {
    public static int maxSubArray(int[] nums) {
        int pre=0, max=nums[0];
        for(int i=0;i<nums.length;i++){
            pre=Math.max(nums[i], pre+nums[i]);
            max=Math.max(pre,max);
        }
        return max;
    }

    public static void main(String[] args) {
        // {-2,1,-3,4,-1,2,1,-5,4}    6
        // {1,1,1}                    3
        // {1}                        1
        //
        int[] numbers = {0};
        System.out.println(maxSubArray(numbers));
    }
}
