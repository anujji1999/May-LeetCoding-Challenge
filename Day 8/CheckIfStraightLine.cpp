#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        float slope = (float)(coordinates[1][1] - coordinates[0][1]) / (float)(coordinates[1][0] - coordinates[0][0]);

        for(int i=2; i<coordinates.size(); i++){
            float temp = (float)(coordinates[i][1] - coordinates[i-1][1]) / (float)(coordinates[i][0] - coordinates[i-1][0]);
            if(temp != slope){
                return false;
            }
        }
        return true;
    }
};