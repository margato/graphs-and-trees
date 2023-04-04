package io.github.margato.graphs.tree.binary

object BinaryTreeTraverseOperations {

    fun <T> inOrderTraverseRecursively(node: BinaryTreeNode<T>?, fn: (value: T) -> (Unit)) {
        if (node == null) return
        inOrderTraverseRecursively(node.getLeft(), fn)
        fn(node.value)
        inOrderTraverseRecursively(node.getRight(), fn)
    }

    fun <T> preOrderTraverseRecursively(node: BinaryTreeNode<T>?, fn: (value: T) -> (Unit)) {
        if (node == null) return
        fn(node.value)
        inOrderTraverseRecursively(node.getLeft(), fn)
        inOrderTraverseRecursively(node.getRight(), fn)
    }

    fun <T> postOrderTraverseRecursively(node: BinaryTreeNode<T>?, fn: (value: T) -> (Unit)) {
        if (node == null) return
        inOrderTraverseRecursively(node.getLeft(), fn)
        inOrderTraverseRecursively(node.getRight(), fn)
        fn(node.value)
    }

}