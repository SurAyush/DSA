package SegmentTree;
class SegmentTree{
    int low, high, sum;
    SegmentTree left, right;
    public SegmentTree(int low, int high, int sum){
        this.low = low;
        this.high = high;
        this.sum = sum;
    }
}
class NumArray {

    SegmentTree root;
    public NumArray(int[] nums) {
        int n = nums.length;
        if(n>0)
            root = build(nums,0,n-1); 
    }

    public SegmentTree build(int[] nums, int i, int j){
        if(i==j){
            return new SegmentTree(i,j,nums[i]);
        }
        if(i<j){
            int mid = (i+j)/2;
            SegmentTree left = build(nums,i,mid);
            SegmentTree right = build(nums, mid+1, j);

            SegmentTree node = new SegmentTree(i,j,left.sum+right.sum);
            node.left = left;
            node.right = right;
            return node;
        }
        return null;
    }
    
    public void update(int index, int val) {
        updateTree(root, index, val);
    }

    public void updateTree(SegmentTree node, int idx, int val){
        if(node.low==node.high && node.low==idx){
            node.sum = val;
            return;
        }

        int mid = (node.low+node.high)/2;
        if(idx<=mid){
            updateTree(node.left, idx, val);
        }
        else{
            updateTree(node.right, idx, val);
        }

        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int left, int right) {
        return findsum(root, left, right);
    }

    public int findsum(SegmentTree tree, int l, int r){
        // not changing segment
        if (tree == null || tree.low > r || tree.high < l) {
            return 0; // No overlap
        }

        // [l, low, high, r]
        // Return complete segment
        if (tree.low >= l && tree.high <= r) {
            return tree.sum; 
        }

        // Partial overlap
        int s1 = findsum(tree.left, l, r);
        int s2 = findsum(tree.right, l, r);

        return s1 + s2;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
