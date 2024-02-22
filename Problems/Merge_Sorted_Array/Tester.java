public class Tester {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);
        System.out.println("Merged Array for Test Case 1:");
        printArray(nums1);

        // Test case 2
        int[] nums3 = {4, 5, 6, 0, 0, 0};
        int m2 = 3;
        int[] nums4 = {1, 2, 3};
        int n2 = 3;

        solution.merge(nums3, m2, nums4, n2);
        System.out.println("Merged Array for Test Case 2:");
        printArray(nums3);

        // Test case 3
        int[] nums5 = {1};
        int m3 = 1;
        int[] nums6 = {};
        int n3 = 0;

        solution.merge(nums5, m3, nums6, n3);
        System.out.println("Merged Array for Test Case 3:");
        printArray(nums5);

        // Test case 4
        int[] nums7 = {};
        int m4 = 0;
        int[] nums8 = {1};
        int n4 = 1;

        solution.merge(nums7, m4, nums8, n4);
        System.out.println("Merged Array for Test Case 4:");
        printArray(nums7);
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
