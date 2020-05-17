class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int max_straight_sum = Integer.MIN_VALUE;
        int min_straight_sum = Integer.MAX_VALUE;

        int array_sum = 0;
        int temp_max_sum = 0;
        int temp_min_sum = 0;

        for(int i=0; i<A.length; i++){
            array_sum += A[i];
            
            temp_max_sum += A[i];
            if(temp_max_sum > max_straight_sum){
                max_straight_sum = temp_max_sum;
            }
            if(temp_max_sum < 0){
                temp_max_sum = 0;
            }

            temp_min_sum += A[i];
            if(temp_min_sum < min_straight_sum){
                min_straight_sum = temp_min_sum;
            }
            if(temp_min_sum > 0){
                temp_min_sum = 0;
            }
        }

        if(min_straight_sum == array_sum){
            return max_straight_sum;
        }

        return Math.max(max_straight_sum, (array_sum - min_straight_sum));
    }
}