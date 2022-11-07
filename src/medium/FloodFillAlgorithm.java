package medium;

import java.util.List;

public class FloodFillAlgorithm {
    public static void main(String[] args) {
        int[][] image = {{}};

        int sr = 1;
        int sc = 1;

        int color = 3;

        // We calculate oldColor first using the coordinates (sr , sc)

        int oldColor = image[sr][sc];

        // Incase the oldColor & given Color is same, we can simply return the Original Image

        if (oldColor == color)
            System.out.println(image);

        // We calculate the Dimmensions of image matrix[]

        int n = image.length, m = image[0].length;

        flood(sr , sc , image, oldColor, color , n, m);

        // We return the new image[][] matrix after changing all the Neighbouring Cells of (sr , sc) having OldColor to Color

        System.out.println(image);
    }

    public static void flood(int i, int j, int[][] image, int oldColor, int newColor, int n, int m)
    {

        // If we move out of the Matrix Or oldColor is not equal to newColor, we just return back

        if (i < 0 || j < 0 || i == n || j == m || image[i][j] != oldColor)
            return;

        // We change the color of the Current-Cell to newColor

        image[i][j] = newColor;

        // Recursive call in Downward direction

        flood(i + 1, j, image, oldColor, newColor, n, m);

        // Recursive call in the Upward direction

        flood(i - 1, j, image, oldColor, newColor, n, m);

        // Recursive call in the Right direction

        flood(i, j + 1, image, oldColor, newColor, n, m);

        // Recursive call in the left direction

        flood(i, j - 1, image, oldColor, newColor, n, m);
    }
}
