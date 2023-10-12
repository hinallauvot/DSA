/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int bs(MountainArray mountainArr,int start, int end, int target, boolean reverse) {
        int left = start, right = end;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int midEle = mountainArr.get(mid);
            if(midEle == target) return mid;
            else if((!reverse && midEle < target) || (reverse && midEle > target)) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private int findPeak(MountainArray mountainArr, int length) {
        int left = 0, right = length;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int midEle = mountainArr.get(mid);
            if(left < mid && midEle < mountainArr.get(mid - 1)) right = mid - 1;
            else if(right > mid && midEle < mountainArr.get(mid + 1)) left = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0, right = len-1;
        int mid = findPeak(mountainArr, len);
        if(target == mountainArr.get(mid)) return mid;
        int firstOcc = bs(mountainArr, 0, mid-1, target, false);
        return firstOcc != -1 ? firstOcc : bs(mountainArr, mid+1, len-1, target, true);
    }
}