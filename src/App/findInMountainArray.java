package App;

public class findInMountainArray {
    public int findInMountainArray(int target, MountainArray A) {
        int idx = findInMountainArray(target, A, 0, A.length() - 1);
        return idx == Integer.MAX_VALUE ? - 1 : idx;
    }

    private int findInMountainArray(int target, MountainArray A, int l, int r) {
        if (l >= r) {
            if (l == r && A.get(l) == target) {
                return l;
            }
            return Integer.MAX_VALUE;
        }
        int m = l + (r - l) / 2;
        int val = A.get(m);
        if (val == target) {
            return A.get(m + 1) < val ? Math.min(findInMountainArray(target, A, l, m - 1), m) : m;
        } else if (target > val) {
            return A.get(m + 1) > val ? findInMountainArray(target, A, m + 1, r) : findInMountainArray(target, A, l, m - 1);
        }
        int idx = findInMountainArray(target, A, l, m - 1);
        return idx != Integer.MAX_VALUE ? idx : findInMountainArray(target, A, m + 1, r);
    }
    class MountainArray{
        int[] arr;
        public MountainArray(int[] arr) {
            this.arr = arr;
        }
        public int get(int index) {
            return arr[index];
        }
        public int length(){
            return arr.length;
        }
    }

}
