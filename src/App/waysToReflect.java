public class waysToReflect{

    public int waysToReflect(int reflectsNum){

        int[] res = new int[1];
        int[] through = new int[1];
        dfs(reflectsNum, res, through);
        return res[0];

    }
    // state 0: reflect
    // state 1: through
    private void dfs(int depth, int[] res, int[] through) {
        if(depth == 0) {
            res[0]++;
            return;
        }
        if(through[0] == 3)
            return;
        for (int i = 0; i < 2; i++) {
            if(i == 0){
                dfs(depth - 1, res, through);
            }
            else {
                through[0]++;
                dfs(depth, res, through);
                through[0]--;
            }
        }
    }
}