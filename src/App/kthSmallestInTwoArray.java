package App;

public class kthSmallestInTwoArray {

    public int kthSamllestInTwoArray(int[] A, int[] B, int k){

        return findKth(A, 0, B, 0, k);

    }
    private int findKth(int[] A, int startA, int[] B, int startB, int k){
        if(startA == A.length) return B[startB + k - 1];
        if(startB == B.length) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);

        int keyA = (startA + k / 2 - 1 < A.length)
                ? A[startA + k / 2 - 1]
                : Integer.MAX_VALUE;
        int keyB = (startB + k / 2 - 1 < B.length)
                ? B[startB + k / 2 - 1]
                : Integer.MAX_VALUE;
        if(keyA < keyB){
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}
