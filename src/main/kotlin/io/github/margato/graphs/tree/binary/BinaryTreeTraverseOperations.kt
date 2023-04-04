package io.github.margato.graphs.tree.binary

object BinaryTreeTraverseOperations {

    fun <T> traverseInOrderRecursively(node: BinaryTreeNode<T>?, fn: (value: T) -> (Unit)) {
        if (node == null) return
        traverseInOrderRecursively(node.getLeft(), fn)
        fn(node.value)
        traverseInOrderRecursively(node.getRight(), fn)
    }

    fun <T> traverseInPreOrderRecursively(node: BinaryTreeNode<T>?, fn: (value: T) -> (Unit)) {
        if (node == null) return
        fn(node.value)
        traverseInOrderRecursively(node.getLeft(), fn)
        traverseInOrderRecursively(node.getRight(), fn)
    }

    fun <T> traverseInPostOrderRecursively(node: BinaryTreeNode<T>?, fn: (value: T) -> (Unit)) {
        if (node == null) return
        traverseInOrderRecursively(node.getLeft(), fn)
        traverseInOrderRecursively(node.getRight(), fn)
        fn(node.value)
    }

}