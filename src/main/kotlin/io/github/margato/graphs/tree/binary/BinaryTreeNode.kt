package io.github.margato.graphs.tree.binary

import io.github.margato.graphs.base.TreeNode
import java.util.UUID

class BinaryTreeNode<T>(id: String = UUID.randomUUID().toString(), value: T) : TreeNode<T>(id, value) {
    private var left: BinaryTreeNode<T>? = null
    private var right: BinaryTreeNode<T>? = null

    fun getLeft() = left
    fun getRight() = right

    fun setLeft(treeNode: BinaryTreeNode<T>?): BinaryTreeNode<T> {
        left = treeNode
        return this
    }

    fun setRight(treeNode: BinaryTreeNode<T>?): BinaryTreeNode<T> {
        right = treeNode
        return this
    }

    override fun isLeaf() = left == null && right == null
}