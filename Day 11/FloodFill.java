class Solution {

    int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    void helper(int[][] image, int sr, int sc, int oldColor, int newColor){
        image[sr][sc] = newColor;

        for(int i=0; i<dir.length; i++){
            int new_sr = sr + dir[i][0];
            int new_sc = sc + dir[i][1];

            if(new_sr >= 0 && new_sr < image.length && new_sc >= 0 && new_sc < image[0].length && image[new_sr][new_sc] == oldColor){
                helper(image, new_sr, new_sc, oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor != image[sr][sc]){      //Although it seems like this loop should wok without this codition also, but when oldColor and newColor are same, then it will get into infinite loop, so either we can put this check or keep a visited array
            helper(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
}