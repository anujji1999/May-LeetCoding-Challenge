#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> umap;
        for(int i=0; i<nums.size(); i++){
            umap[nums[i]]++;
        }

        for(int i=0; i<nums.size(); i++){
            if(umap[nums[i]] > nums.size()/2){
                return nums[i];
            }
        }
        return -1;
    }
};