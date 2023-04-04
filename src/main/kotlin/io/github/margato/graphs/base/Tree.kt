package io.github.margato.graphs.base

abstract class Tree<T>(open val root: TreeNode<T>?) {
    abstract fun numberOfNodes(): Int
    abstract fun traverseInOrder(fn: (value: T) -> Unit)
    abstract fun traverseInPostOrder(fn: (value: T) -> Unit)
    abstract fun traverseInPreOrder(fn: (value: T) -> Unit)
}