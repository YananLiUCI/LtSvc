package App;

public class writeToMatrix {

    public void write(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                new Thread(i, j).run();
            }
        }
    }

    class Thread implements Runnable {

        private int x;
        private int y;
        public Thread(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public void run() {
            writeToCell(x, y);
        }
        private void writeToCell(int x, int y) {

        }
    }
}
