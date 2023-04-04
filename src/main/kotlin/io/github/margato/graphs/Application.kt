package io.github.margato.graphs

import io.github.margato.graphs.tree.binary.BinaryTree
import io.github.margato.graphs.tree.binary.BinaryTreeNode
import java.util.UUID

fun main() {

    val tree = BinaryTree(
        BinaryTreeNode(
            id = UUID.randomUUID().toString(), value = "A"
        )
    )

    tree.root
        ?.setLeft(
            BinaryTreeNode(
                id = UUID.randomUUID().toString(), value = "B"
            ).setLeft(
                BinaryTreeNode(
                    id = UUID.randomUUID().toString(), value = "D"
                )
            )
        )?.setRight(
            BinaryTreeNode(
                id = UUID.randomUUID().toString(), value = "C"
            ).setLeft(
                BinaryTreeNode(
                    id = UUID.randomUUID().toString(), value = "E"
                ).setRight(
                    BinaryTreeNode(
                        id = UUID.randomUUID().toString(), value = "F"
                    )
                )
            )
        )

    println(tree.numberOfNodes())
    println("In Order").also {
        tree.traverseInOrder {
            println(it)
        }
    }
    println("Pre Order").also {
        tree.traverseInPreOrder{
            println(it)
        }
    }
    println("Post Order").also {
        tree.traverseInPostOrder {
            println(it)
        }
    }
}