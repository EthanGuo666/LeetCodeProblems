public class Main {
    public static void sortColors(int[] nums) {
        int count0=0, count1=0, count2=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==0) {
                count0++;
            }
            if (nums[i]==1) {
                count1++;
            }
            if(nums[i]==2) {
                count2++;
            }
        }

        int i=0;
        while(i<count0) {
            nums[i]=0;
            i++;
        }

        while(i<count0+count1) {
            nums[i]=1;
            i++;
        }

        while(i<count0+count1+count2) {
            nums[i]=2;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
