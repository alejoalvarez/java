# Binary Trees
A Binary Tree is a structure in which each node can have at most two children (child nodes). In a Binary tree, there exists a unique path from the root node to every other node. The topmost node of a binary tree is called the root node or the parent node, and the nodes coming from the root node are called the child nodes.

A binary tree is either empty (which is called a null tree), or it consists of a root node along with the remaining two nodes, each being a binary tree itself.

Each node in a binary tree can have zero, one or maximum two successors or child nodes: left successor or child node and right successor or child node. A terminal node (that is, a node with n successor) is called a leaf node.

<p align="center">
<img height="270" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/binary-tree-in-java.jpeg">
</p>

Representation of Binary Trees
Each object in a binary tree is represented by a pointer on the topmost node along with the two references of the left node and the right node of the tree. If the nodes in the tree are empty, that is, leaf node, then it’s left and right references are NULL.

**The parts of the binary tree are:**

- Data
- Reference to the left child
- Reference for the right child

In a binary tree, there is a level number for each node. The Root node is at level 0, then each child having the level number one more than the level number of its parent node.

**Traversing Binary Trees**

The tree traversal is the process of going through a tree, in such a way it visits each node only once. There are three standard ways of traversing a binary tree which are:

- Preorder Traversal
- Inorder Traversal
- Postorder Traversal

**Properties of Binary Trees:**

- The number of children of a node is called the degree of the tree. A binary tree is a tree of degree 2, as each node can have a maximum of 2 children.
- The depth or height of a tree is the maximum number of nodes in a branch of it. It is always one more than the longest level number of the tree.
- The maximum number of nodes at level ‘L’ is 2^ (L-1)
- The maximum number of nodes for a tree with height ‘h’ is 2^ (h – 1)
- Time Complexity of Tree Traversal is O(n)