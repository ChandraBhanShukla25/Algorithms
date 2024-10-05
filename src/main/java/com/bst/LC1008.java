package com.bst;

import java.util.Stack;

public class LC1008 {

    public static void main(String[] args) {
       int[] preorder = {8,5,1,7,10,12};
       LC1008 lc1008 = new LC1008();
       TreeNode node = lc1008.bstFromPreorder(preorder);
       System.out.println(node);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
      if(preorder.length==0){
          return null;
      }
      Stack<TreeNode> stack = new Stack<>();
      TreeNode root = new TreeNode(preorder[0]);
      stack.push(root);

      for(int i=1;i<preorder.length;i++){
          TreeNode node = stack.peek();
          TreeNode child = new TreeNode(preorder[i]);

          while(!stack.isEmpty() && preorder[i]>stack.peek().val){
            node = stack.pop();
          }

          if(node.val<child.val){
              node.right = child;
          }else{
              node.left = child;
          }
          stack.push(child);
      }
      return root;
    }


}
