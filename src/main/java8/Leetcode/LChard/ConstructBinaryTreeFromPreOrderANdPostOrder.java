package Leetcode.LChard;





// LC-889



class TreeNode{
    int v;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v){
        this.v = v;
        this.left = null;
        this.right = null;
    }
}
public class ConstructBinaryTreeFromPreOrderANdPostOrder {



    public static void main(String[] args){
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        constructFromPrePost(preorder, postorder);

    }




        public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int numOfNodes = preorder.length;
            return constructTree(0, numOfNodes - 1, 0, preorder, postorder);
        }

        // Helper function to construct the tree recursively
        private static TreeNode constructTree(
                int preStart,
                int preEnd,
                int postStart,
                int[] preorder,
                int[] postorder
        ) {
            // Base case: If there are no nodes to process, return null
            if (preStart > preEnd) return null;

            // Base case: If only one node is left, return that node
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }

            // The left child root in preorder traversal (next element after root)
            int leftRoot = preorder[preStart + 1];

            // Calculate the number of nodes in the left subtree by searching in postorder
            int numOfNodesInLeft = 1;
            while (postorder[postStart + numOfNodesInLeft - 1] != leftRoot) {
                numOfNodesInLeft++;
            }

            TreeNode root = new TreeNode(preorder[preStart]);

            // Recursively construct the left subtree
            root.left = constructTree(
                    preStart + 1,
                    preStart + numOfNodesInLeft,
                    postStart,
                    preorder,
                    postorder
            );

            // Recursively construct the right subtree
            root.right = constructTree(
                    preStart + numOfNodesInLeft + 1,
                    preEnd,
                    postStart + numOfNodesInLeft,
                    preorder,
                    postorder
            );

            return root;
        }


}
