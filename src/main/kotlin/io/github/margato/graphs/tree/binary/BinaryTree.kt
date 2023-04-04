package io.github.margato.graphs.tree.binary

import io.github.margato.graphs.base.Tree
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.traverseInOrderRecursively
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.traverseInPostOrderRecursively
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.traverseInPreOrderRecursively

class BinaryTree<T>(root: BinaryTreeNode<T>?) : Tree<T>(root) {
    override val root = super.root as BinaryTreeNode<T>?

    override fun traverseInOrder(fn: (value: T) -> (Unit)) {
        if (root == null) return
        traverseInOrderRecursively(root, fn)
    }

    override fun traverseInPreOrder(fn: (value: T) -> (Unit)) {
        if (root == null) return
        traverseInPreOrderRecursively(root, fn)
    }

    override fun traverseInPostOrder(fn: (value: T) -> (Unit)) {
        if (root == null) return
        traverseInPostOrderRecursively(root, fn)
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