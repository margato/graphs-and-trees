package io.github.margato.graphs.tree.binary

import io.github.margato.graphs.base.Tree
import io.github.margato.graphs.base.TreeNode
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.inOrderTraverseRecursively
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.postOrderTraverseRecursively
import io.github.margato.graphs.tree.binary.BinaryTreeTraverseOperations.preOrderTraverseRecursively
import io.github.margato.graphs.tree.exceptions.InvalidInsertionException
import mu.KotlinLogging
import java.util.*

class BinaryTree<T : Comparable<T>>(root: BinaryTreeNode<T>) : Tree<T>(root) {
    override val root = super.root as BinaryTreeNode<T>
    private val logger = KotlinLogging.logger {}


    override fun findByValue(value: T): Optional<TreeNode<T>> {
        return findByValueRecursively(root, value)
    }

    private fun findByValueRecursively(node: BinaryTreeNode<T>?, value: T): Optional<TreeNode<T>> {
        if (node == null) {
            logger.trace {
                "findByValueRecursively - Value to find: $value - Not found"
            }
            return Optional.empty()
        }

        logger.trace {
            "findByValueRecursively - Value to find: $value - Current node: ${node.id} = ${node.value}"
        }

        val comparingValue = node.value.compareTo(value)
        return if (comparingValue < 0) {
            findByValueRecursively(node.getRight(), value)
        } else if (comparingValue > 0) {
            findByValueRecursively(node.getLeft(), value)
        } else {
            logger.trace {
                "findByValueRecursively - Value to find: $value - Value found: ${node.id} = ${node.value}"
            }
            Optional.of(node)
        }
    }

    override fun add(id: String, value: T) {
        addRecursively(root, id, value)
    }

    private fun addRecursively(node: BinaryTreeNode<T>?, id: String, value: T) {
        val comparingValue = node!!.value.compareTo(value)

        if (comparingValue < 0) {
            when (node.getRight() == null) {
                true -> node.setRight(BinaryTreeNode(id, value))
                false -> addRecursively(node.getRight(), id, value)
            }
        } else if (comparingValue > 0) {
            when (node.getLeft() == null) {
                true -> node.setLeft(BinaryTreeNode(id, value))
                false -> addRecursively(node.getLeft(), id, value)
            }
        } else {
            throw InvalidInsertionException("Tree already has value $value")
        }
    }

    override fun inOrderTraverse(fn: (node: TreeNode<T>) -> (Unit)) {
        inOrderTraverseRecursively(root, fn)
    }

    override fun preOrderTraverse(fn: (node: TreeNode<T>) -> (Unit)) {
        preOrderTraverseRecursively(root, fn)
    }

    override fun postOrderTraverse(fn: (node: TreeNode<T>) -> (Unit)) {
        postOrderTraverseRecursively(root, fn)
    }

    override fun numberOfNodes(): Int {
        return countChildrenRecursively(root)
    }

    private fun countChildrenRecursively(node: BinaryTreeNode<T>?): Int {
        if (node == null) return 0
        return 1 + countChildrenRecursively(node.getLeft()) + countChildrenRecursively(node.getRight())
    }
}