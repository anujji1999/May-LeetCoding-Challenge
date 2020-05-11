class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];

        for(int i=0; i<=N; i++){
            indegree[i] = 0;
            outdegree[i] = 0;
        }

        for(int[] v : trust){
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
}