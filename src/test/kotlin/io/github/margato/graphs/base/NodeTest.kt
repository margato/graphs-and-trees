package io.github.margato.graphs.base

import io.github.margato.graphs.tree.binary.BinaryTreeNode
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NodeTest : FunSpec({

    test("hashCode shouldBe id hashCode") {
        val node = BinaryTreeNode(value="1")

        node.hashCode() shouldBe node.id.hashCode()
    }

    test("isEqual should return true because it is same instance") {
        val a = BinaryTreeNode(value="1")

        (a == a) shouldBe true
    }

    test("isEqual should return true because it has same id") {
        val a = BinaryTreeNode(id="2", value="1")
        val b = BinaryTreeNode(id="2", value="3")

        (a == b) shouldBe true
    }

    test("isEqual should return false because it doesn't have the same id") {
        val a = BinaryTreeNode(id="1", value="1")
        val b = BinaryTreeNode(id="2", value="3")

        (a == b) shouldBe false
    }

    test("isEqual should return false because the comparing value is null") {
        val a = BinaryTreeNode(id="1", value="1")

        a.equals(null) shouldBe false
    }

})