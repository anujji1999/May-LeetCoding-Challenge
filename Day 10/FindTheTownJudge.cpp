#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> indegree(N+1, 0);
        vector<int> outdegree(N+1, 0);

        for(vector<int> v : trust){
            outdegree[v[0]]++;
            indegree[v[1]]++;
        }

        for(int i=1; i<=N; i++){
            if(indegree[i] == N-1 && outdegree[i] == 0){
                return i;
            }
        }

        return -1;
    }
};