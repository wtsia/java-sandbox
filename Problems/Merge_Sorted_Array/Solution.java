class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int k = 0;
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] < nums2[j]) {
                    merged[k] = nums1[i];
                    k++;
                } else {
                    break;
                }
            }
        }

        nums1 = merged;
    }
}
