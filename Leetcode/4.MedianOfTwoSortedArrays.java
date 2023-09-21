//Approach 1 - TC - O(m+n) SC - O(m+n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;

        int[] temp = new int[size];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j])
                temp[k++] = nums1[i++];
            else
                temp[k++] = nums2[j++];
        }

        while(i < m) {
            temp[k++] = nums1[i++];
        }

        while(j < n) {
            temp[k++] = nums2[j++];
        }

        if(size % 2 == 1) return (double)temp[size/2];
        else return (temp[size/2] + temp[size/2 -1])/2.0;
    }
}

//Approach 1 - TC - O(m+n) SC - O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;

        int i = 0, j = 0, k = 0;
        int midIndex1 = size/2 -1, midIndex2 = size/2;
        int mid1 = 0, mid2 = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                if(k == midIndex1)
                    mid1 = nums1[i];
                if(k == midIndex2)
                    mid2 = nums1[i];
                i++;
            }
            else {
                if(k == midIndex1)
                    mid1 = nums2[j];
                if(k == midIndex2)
                    mid2 = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m) {
            if(k == midIndex1)
                mid1 = nums1[i];
            if(k == midIndex2)
                mid2 = nums1[i];
            i++;
            k++;
        }

        while(j < n) {
            if(k == midIndex1)
                mid1 = nums2[j];
            if(k == midIndex2)
                mid2 = nums2[j];
            j++;
            k++;
        }

        if(size % 2 == 1) return (double)mid2;
        else return (mid1 + mid2)/2.0;
    }
}

//Approach-3 Binary Search TC : O(log(min(m,n))), SC : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //setting the smaller length array as nums1
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = low + (high - low)/2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 1)
                    return Math.max(maxX, maxY);
                return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
            }
            if (maxX > minY)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }
        return -1;
    }
}