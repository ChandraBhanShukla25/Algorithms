package com.bst;

import com.bst.TreeNode;
import com.tree.InOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC450 {

    public static void main(String[] args) {
        List<Integer> lst  = List.of(5,3,6,2,4,null,7);
        int key = 3;
        LC450 lc450 = new LC450();
        TreeNode root = lc450.createTree(lst, 0);
        TreeNode afterDelete = lc450.deleteNode(root, key);
        lc450.traverse(afterDelete);
    }

    public List<Integer> traverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root!=null) {
                stack.push(root);
                root=root.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.peek();
                result.add(root.val);
                stack.pop();
                root= root.right;
            }
        }
        return  result;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val == key)
            return connector(root);

        TreeNode node = root;
        while(node!=null){
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                    node.left=connector(node.left);
                    break;
                }else{
                    node = node.left;
                }
            }else{
                if(node.right!=null && node.right.val==key) {
                    node.right = connector(node.right);
                    break;
                }else{
                    node=node.right;
                }
            }
        }
        return root;
    }

    private TreeNode connector(TreeNode root) {
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;

        TreeNode leftChild = root.left;
        TreeNode leftMostNodeInRight = root.right;
        while(leftMostNodeInRight.left!=null){
            leftMostNodeInRight=leftMostNodeInRight.left;
        }
        leftMostNodeInRight.left = leftChild;
        return root.right;
    }

    public TreeNode createTree(List<Integer> lst, int index){
        if(index<lst.size() && lst.get(index)!=null){
            TreeNode root = new TreeNode(lst.get(index));
            root.left = createTree(lst, 2*index+1);
            root.right = createTree(lst, 2*index+2);
            return root;
        }
        return null;
    }

}
