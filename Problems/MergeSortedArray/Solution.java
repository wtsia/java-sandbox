class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (k != (m + n)) {
            if (i == m || j == n || nums1[i] == 0 | nums2[j] == 0) {
                if (i == m || nums1[i] == 0) {
                    merged[k] = nums2[j];
                    j++;
                    k++;
                } else {
                    merged[k] = nums1[i];
                    i++;
                    k++;
                }
            } else if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        printArray(merged);
        
        for (i = 0; i < m; i++) {
            nums1[i] = merged[i];
        }
    }
    
    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        
        System.out.println("Merging:");
        printArray(nums1);
        printArray(nums2);

        System.out.println("Merged Array for Test Case 1:");
        solution.merge(nums1, m, nums2, n);

        // Test case 2
        int[] nums3 = {4, 5, 6, 0, 0, 0};
        int m2 = 3;
        int[] nums4 = {1, 2, 3};
        int n2 = 3;

        System.out.println("Merging:");
        printArray(nums3);
        printArray(nums4);

        System.out.println("Merged Array for Test Case 2:");
        solution.merge(nums3, m2, nums4, n2);

        // Test case 3
        int[] nums5 = {1};
        int m3 = 1;
        int[] nums6 = {};
        int n3 = 0;
        
        System.out.println("Merging:");
        printArray(nums5);
        printArray(nums6);

        System.out.println("Merged Array for Test Case 3:");
        solution.merge(nums5, m3, nums6, n3);

        // Test case 4
        int[] nums7 = {};
        int m4 = 0;
        int[] nums8 = {1};
        int n4 = 1;

        System.out.println("Merging:");
        printArray(nums7);
        printArray(nums8);

        System.out.println("Merged Array for Test Case 4:");
        solution.merge(nums7, m4, nums8, n4);
    }
}
