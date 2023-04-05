package io.github.margato.graphs

import io.github.margato.graphs.tree.binary.BinaryTree
import io.github.margato.graphs.tree.binary.BinaryTreeNode
import mu.KotlinLogging
import org.slf4j.impl.SimpleLogger

fun main() {
    System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, System.getenv("LOG_LEVEL"));
    val logger = KotlinLogging.logger {}

    val tree = BinaryTree(root = BinaryTreeNode(value = 3.0))
    tree.add(value = 2.0)
    tree.add(value = 4.0)
    tree.add(value = 1.0)
    tree.add(value = 5.0)
    tree.add(value = 3.3)

    tree.inOrderTraverse { logger.debug { "In Order Trave - $it" } }

    tree.findByValue(1.0).also { logger.debug { "Find By Value - $it" } }
    tree.findByValue(3838.2).also { logger.debug { "Find By Value - $it" } }
    tree.findByValue(3.3).also { logger.debug { "Find By Value - $it" } }
}