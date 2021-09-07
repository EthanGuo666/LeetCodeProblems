public class Main {
    public int jump(int[] nums) {
        int len = nums.length;
        int rightMost = 0;
        int mostPos = 0;
        int step = nums[0];
        for(int i=0;i<len;i++){

            if (i<rightMost){
                rightMost = Math.max(rightMost, nums[i]+i);
            }

        }
    }

    public static void main(String[] args) {

    }
}
