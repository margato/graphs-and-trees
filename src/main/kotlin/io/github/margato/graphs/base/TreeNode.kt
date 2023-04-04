package io.github.margato.graphs.base

abstract class TreeNode<T>(id: String, val value: T) : Node(id) {
    abstract fun isLeaf(): Boolean
}