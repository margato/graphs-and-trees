package io.github.margato.graphs.tree.binary

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BinaryTreeNodeTest : FunSpec({

    test("should create leaf node") {
        val node = BinaryTreeNode(value = "1")

        node.value shouldBe "1"
        node.getLeft() shouldBe null
        node.getRight() shouldBe null
        node.isLeaf() shouldBe true
    }

    test("should create node with only left child") {
        val node =
            BinaryTreeNode(value = "1")
                .setLeft(
                    BinaryTreeNode(value = "2")
                )

        node.value shouldBe "1"
        node.getLeft()!!.value shouldBe "2"
        node.getRight() shouldBe null
        node.isLeaf() shouldBe false
    }

    test("should create node with only right child") {
        val node =
            BinaryTreeNode(value = "1")
                .setRight(
                    BinaryTreeNode(value = "3")
                )

        node.value shouldBe "1"
        node.getLeft() shouldBe null
        node.getRight()!!.value shouldBe "3"
        node.isLeaf() shouldBe false
    }

    test("should create node with left and right child") {
        val node =
            BinaryTreeNode(value = "1")
                .setLeft(
                    BinaryTreeNode(value = "2")
                ).setRight(
                    BinaryTreeNode(value = "3")
                )

        node.value shouldBe "1"
        node.getLeft()!!.value shouldBe "2"
        node.getRight()!!.value shouldBe "3"
        node.isLeaf() shouldBe false
    }

})