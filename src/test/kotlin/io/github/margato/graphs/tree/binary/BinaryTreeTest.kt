package io.github.margato.graphs.tree.binary

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.*

class BinaryTreeTest : FunSpec({

    lateinit var tree: BinaryTree<Int>

    beforeEach {
        tree = BinaryTree(
            BinaryTreeNode(
                id = UUID.randomUUID().toString(), value = 3
            )
        )

        tree.root
            .setLeft(
                BinaryTreeNode(
                    id = UUID.randomUUID().toString(), value = 2
                ).setLeft(
                    BinaryTreeNode(
                        id = UUID.randomUUID().toString(), value = 1
                    )
                )
            ).setRight(
                BinaryTreeNode(
                    id = UUID.randomUUID().toString(), value = 5
                ).setLeft(
                    BinaryTreeNode(
                        id = UUID.randomUUID().toString(), value = 4
                    )
                ).setRight(
                    BinaryTreeNode(
                        id = UUID.randomUUID().toString(), value = 6
                    )
                )
            )
    }

    test("should traverse in order") {
        val correctOrderTraversed = listOf(1, 2, 3, 4, 5, 6)
        val traversed = mutableListOf<Int>()

        tree.inOrderTraverse {
            traversed.add(it.value)
        }

        traversed shouldBe correctOrderTraversed
    }

    test("should traverse in pre order") {
        val correctOrderTraversed = listOf(3, 1, 2, 4, 5, 6)
        val traversed = mutableListOf<Int>()

        tree.preOrderTraverse {
            traversed.add(it.value)
        }

        traversed shouldBe correctOrderTraversed
    }

    test("should traverse in post order") {
        val correctOrderTraversed = listOf(1, 2, 4, 5, 6, 3)
        val traversed = mutableListOf<Int>()

        tree.postOrderTraverse {
            traversed.add(it.value)
        }

        traversed shouldBe correctOrderTraversed
    }

})