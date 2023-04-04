package io.github.margato.graphs.base

abstract class Tree<T>(open val root: TreeNode<T>?) {
    abstract fun numberOfNodes(): Int
    abstract fun add(value: T)
    abstract fun inOrderTraverse(fn: (value: T) -> Unit)
    abstract fun postOrderTraverse(fn: (value: T) -> Unit)
    abstract fun preOrderTraverse(fn: (value: T) -> Unit)
}