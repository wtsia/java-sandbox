public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int amtNEQVal = 0;

        while (i < nums.length - 1) {
            if (nums[i] == val) {
                removeInPlace(nums, i);
            } else {
                amtNEQVal++;
                ++i;
            }
        }

        return amtNEQVal;
    }

    public static void removeInPlace(int[] nums, int arrIndex) {
        for (int j = arrIndex; j < nums.length - 1; ++j) {
            nums[j] = nums[j + 1];
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int newLength1 = solution.removeElement(nums1, val1);
        System.out.println("New length: " + newLength1);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        // Test case 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int newLength2 = solution.removeElement(nums2, val2);
        System.out.println("New length: " + newLength2);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}