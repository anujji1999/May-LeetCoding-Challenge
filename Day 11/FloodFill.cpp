#include<bits/stdc++.h>
using namespace std;


class Solution {
public:

    vector<vector<int>> dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    void helper(vector<vector<int>>& image, int sr, int sc, int oldcColor, int newColor){

        image[sr][sc] = newColor;

        for(int i=0; i<dir.size(); i++){
            int new_sr = sr + dir[i][0];
            int new_sc = sc + dir[i][1];

            if(new_sr >= 0 && new_sr < image.size() && new_sc >= 0 && new_sc < image[0].size() && image[new_sr][new_sc] == oldcColor){
                helper(image, new_sr, new_sc, oldcColor, newColor);
            }
        }
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(newColor != image[sr][sc])   //Although it seems like this loop should wok without this codition also, but when oldColor and newColor are same, then it will get into infinite loop, so either we can put this check or keep a visited array
            helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
};