public class Main {
    public static int findPeakElement(int[] nums) {
        int max=Integer.MIN_VALUE;
        int maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }
}
