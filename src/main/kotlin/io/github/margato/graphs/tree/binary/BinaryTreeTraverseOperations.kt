package io.github.margato.graphs.tree.binary

import io.github.margato.graphs.base.TreeNode

object BinaryTreeTraverseOperations {

    fun <T> inOrderTraverseRecursively(node: BinaryTreeNode<T>?, fn: (node: TreeNode<T>) -> (Unit)) {
        if (node == null) return
        inOrderTraverseRecursively(node.getLeft(), fn)
        fn(node)
        inOrderTraverseRecursively(node.getRight(), fn)
    }

    fun <T> preOrderTraverseRecursively(node: BinaryTreeNode<T>?, fn: (node: TreeNode<T>) -> (Unit)) {
        if (node == null) return
        fn(node)
        inOrderTraverseRecursively(node.getLeft(), fn)
        inOrderTraverseRecursively(node.getRight(), fn)
    }

    fun <T> postOrderTraverseRecursively(node: BinaryTreeNode<T>?, fn: (node: TreeNode<T>) -> (Unit)) {
        if (node == null) return
        inOrderTraverseRecursively(node.getLeft(), fn)
        inOrderTraverseRecursively(node.getRight(), fn)
        fn(node)
    }

}