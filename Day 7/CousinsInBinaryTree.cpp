class Solution {
public:

    int helper(TreeNode* root, int val, int level, int &parent){
        // if(root->left == NULL && root->right == NULL){
        //     return -1;
        // }

        if(root->val == val){
            return level;
        }

        int ans = -1;
        
        if(root->left != NULL){
            parent = root->val;
            ans = helper(root->left, val, level+1, parent);
        }

        if(ans == -1 && root->right != NULL){
            parent = root->val;
            ans = helper(root->right, val, level+1, parent);
        }

        return ans;

    }

    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL || (root->left == NULL && root->right == NULL)){
            return false;
        }
        if(root->val == x || root->val == y){
            return false;
        }

        int parent1 = -1, parent2 = -1;
        int height1 = -1, height2 = -1;

        height1 = helper(root, x, 0, parent1);
        height2 = helper(root, y, 0, parent2);

        if(height1 == height2 && parent1 != parent2){
            return true;
        }
        return false;
    }
};