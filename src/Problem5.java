/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-04
 */

/**
 * Give the result of preorder and inorder traversal lists, reconstruct the
 * binary tree.
 */
public class Problem5 {
    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode constructTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length < 1 ||
                preorder.length != inorder.length){
            return null;

        }else{
            return construct(preorder, inorder, 0, preorder.length -1,0,  inorder.length -1);
        }
    }

    public static BinaryTreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int currRoot = preorder[preStart];
        int index = inStart;

        while(index <= inEnd){
            if(inorder[index] != currRoot){
                index ++;
            }
        }

        if(index > inEnd){
            throw new RuntimeException("invalid input");
        }

        // recursively reconstruct the tree.
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = currRoot;
        // new preorder start for the left tree would be simply the second element.
        // new preorder end for the left tree would be the index-th element for preorder.
        //            This should also count the offset between preorder start and inorder start.
        // new inorder start would always start with the leftmost value.
        // new inorder end would be the last element before current index.
        node.left = construct(preorder, inorder, preStart + 1,
                preStart - inStart + index, inStart, index - 1);
        node.right = construct(preorder, inorder, preStart - inStart + index + 1, preEnd,
                index + 1, inEnd);
        return node;
    }

    // print the tree in preorder
    public static void printTree(BinaryTreeNode root){
        if (root != null){
            System.out.println(root.value);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String args[]){
        //int[] preorder = {3, 7, 6, 9, 8, 10, 4};
        //int[] inorder = {6, 7, 9, 3, 10, 8, 4};
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        printTree(constructTree(preorder, inorder));
    }


}
