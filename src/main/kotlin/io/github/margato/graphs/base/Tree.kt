package io.github.margato.graphs.base

import java.util.*

abstract class Tree<T : Comparable<T>>(open val root: TreeNode<T>) {
    abstract fun numberOfNodes(): Int
    abstract fun add(id: String = UUID.randomUUID().toString(), value: T)
    abstract fun findByValue(value: T): Optional<TreeNode<T>>
    abstract fun inOrderTraverse(fn: (node: TreeNode<T>) -> Unit)
    abstract fun postOrderTraverse(fn: (node: TreeNode<T>) -> Unit)
    abstract fun preOrderTraverse(fn: (node: TreeNode<T>) -> Unit)

    override fun toString(): String {
        return "Tree(root=$root)"
    }

}