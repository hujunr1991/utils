package com.example.springboorutil.jianzhiOffer.two.binaryTree;

import java.util.Arrays;

public class Problem6 {
    public static void main(String[] args) {

        int[] preSort = {1,2,4,7,3,5,6,8};
        int[] inSort = {4,7,2,1,3,5,8,6};

        BinaryTreeNode root = constructCore(preSort, inSort);
        System.out.println(root);


    }

    private static BinaryTreeNode constructCore(int[] preorder, int[] inorder) {

        if(preorder==null||inorder==null){
            return null;
        }
        if(preorder.length!=inorder.length){
            throw new RuntimeException("长度不一样，非法的输入");
        }

        BinaryTreeNode root=new BinaryTreeNode();
        for(int i=0;i<inorder.length;i++) {
            //找到根节点
            if (inorder[i] == preorder[0]) {
                root.value = inorder[i];
                System.out.println(root.value);
                /**
                 * Arrays.copyOfRange(T[ ] original,int from,int to)
                 *
                 * 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
                 *
                 * 注意这里包括下标from，不包括上标to。
                 */
                root.leftNode = constructCore(Arrays.copyOfRange(preorder, 1,
                        i + 1), Arrays.copyOfRange(inorder, 0, i));

                root.rightNode = constructCore(Arrays.copyOfRange(preorder, i +
                        1, preorder.length), Arrays.copyOfRange(inorder, i + 1,
                        inorder.length));
            }
        }
        return root;
    }

    /**
     * 解法二：https://blog.csdn.net/ahaha413525642/article/details/78210024?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-2
     * 根据前序遍历和中序遍历，后序遍历和中序遍历重构二叉树
     */
}
