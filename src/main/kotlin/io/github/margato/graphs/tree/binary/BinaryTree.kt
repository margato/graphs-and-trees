package io.github.margato.graphs.tree.binary

import io.github.margato.graphs.base.Tree
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.inOrderTraverseRecursively
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.postOrderTraverseRecursively
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.preOrderTraverseRecursively

class BinaryTree<T>(root: BinaryTreeNode<T>?) : Tree<T>(root) {
    override val root = super.root as BinaryTreeNode<T>?


    override fun add(value: T) {
        TODO("Not yet implemented")
    }


    override fun inOrderTraverse(fn: (value: T) -> (Unit)) {
        if (root == null) return
        inOrderTraverseRecursively(root, fn)
    }

    override fun preOrderTraverse(fn: (value: T) -> (Unit)) {
        if (root == null) return
        preOrderTraverseRecursively(root, fn)
    }

    override fun postOrderTraverse(fn: (value: T) -> (Unit)) {
        if (root == null) return
        postOrderTraverseRecursively(root, fn)
    }

    override fun numberOfNodes(): Int {
        if (root == null) return 0

        return countChildrenRecursively(root)
    }


    private fun countChildrenRecursively(node: BinaryTreeNode<T>?): Int {
        if (node == null) return 0
        return 1 + countChildrenRecursively(node.getLeft()) + countChildrenRecursively(node.getRight())
    }
}