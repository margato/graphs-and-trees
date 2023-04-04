package io.github.margato.graphs.graph

import io.github.margato.graphs.base.Node
import io.github.margato.graphs.graph.exceptions.InvalidEdgeException

class GraphNode(id: String) : Node(id) {
    private val edges: MutableList<GraphNode> = mutableListOf()

    fun addEdge(graphNode: GraphNode) {
        if (edges.contains(graphNode)) {
            throw InvalidEdgeException("Edge to node ${graphNode.id} already exists")
        }

        edges.add(graphNode)
    }

    fun removeEdge(graphNode: GraphNode) {
        if (!edges.contains(graphNode)) {
            throw InvalidEdgeException("Edge to node ${graphNode.id} does not exist")
        }

        edges.remove(graphNode)
    }

    fun removeEdge(id: String) {
        val graphNode = GraphNode(id)
        if (!edges.contains(graphNode)) {
            throw InvalidEdgeException("Edge to node ${graphNode.id} does not exist")
        }

        edges.remove(graphNode)
    }
}