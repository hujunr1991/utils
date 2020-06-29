package com.example.springboorutil.jianzhiOffer.two.binaryTree;

public class BinaryTreeNode {

    /**
     * 节点数据
     */
    public int value;
    /**
     * 左子节点
     */
    public BinaryTreeNode leftNode;
    /**
     * 右子节点
     */
    public BinaryTreeNode rightNode;

    public BinaryTreeNode(){}

    public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.value = value;
        this.leftNode = leftChild;
        this.rightNode = rightChild;
    }

/*————————————————
    版权声明：本文为CSDN博主「清茶_」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/m0_38001814/article/details/90610728*/
}
