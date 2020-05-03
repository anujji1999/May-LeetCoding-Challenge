#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numJewelsInStones(string J, string S) {
        unordered_set<char> uset;
        for(int i=0; i<J.size(); i++){
            uset.insert(J[i]);
        }

        int count = 0;
        for(int i=0; i<S.size(); i++){
            if(uset.find(S[i]) != uset.end()){
                count++;
            }
        }
        return count;
    }
};