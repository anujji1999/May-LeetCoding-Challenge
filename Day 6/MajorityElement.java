import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> umap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            umap.put(nums[i], umap.getOrDefault(nums[i], 0)+1);
        }

        for(int i=0; i<nums.length; i++){
            if(umap.get(nums[i]) > (nums.length/2)){
                return nums[i];
            }
        }
        return -1;
    }
}