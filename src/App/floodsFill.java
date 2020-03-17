package App;

public class floodsFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int original = image[sr][sc];
        if(original == newColor)
            return image;

        CheckSides(image, sr, sc, original, newColor);
        return image;
    }

    private void CheckSides(int[][] image, int x, int y, int original, int newColor){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != original)
            return;

        image[x][y] = newColor;

        CheckSides(image, x+1, y, original, newColor);
        CheckSides(image, x-1, y, original, newColor);
        CheckSides(image, x, y+1, original, newColor);
        CheckSides(image, x, y-1, original, newColor);
    }
}
