class Solution {

    int helper(TreeNode root, int val, int level, int[] parent){
        if(root == null){
            return -1;
        }

        if(root.val == val){
            return level;
        }

        int ans = -1;
        if(root.left != null){
            parent[0] = root.val;
            ans = helper(root.left, val, level+1, parent);
        }

        if(ans == -1 && root.right != null){
            parent[0] = root.val;
            ans = helper(root.right, val, level+1, parent);
        }

        return ans;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.left == null && root.right == null)){
            return false;
        }

        if(root.val == x || root.val == y){
            return false;
        }

        int[] parent1 = {-1}, parent2 = {-1};
        int height1 = -1, height2 = -1;

        height1 = helper(root, x, 0, parent1);
        height2 = helper(root, y, 0, parent2);

        if(height1 == height2 && parent1[0] != parent2[0]){
            return true;
        }

        return false;
        
    }
}