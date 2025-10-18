# Algorithmic-Implementations-in-Java
A collection of Java-based data structure and algorithm implementations. Each folder in this repository contains a standalone problem solution focusing on different core computer science concepts such as data structures, trees, linked lists, and compression algorithms.
---

## ⚡ 1. HuffmanCompression

**Folder:** `HuffmanCompression/`  
**Main Concepts:** Frequency mapping, priority lists, Huffman trees, file encoding/decoding  
**Core Classes:** `HuffmanList`, `HuffmanNode`, `HuffmanTree`, `Main`

### 🧩 Overview
This implementation demonstrates the **Huffman Coding Algorithm**, a core data compression technique used to minimize storage by assigning shorter codes to more frequent symbols.

### 🔍 Features
- Converts text files into symbol-frequency mappings  
- Builds a sorted Huffman linked list and binary tree  
- Encodes text using Huffman codes  
- Decodes the encoded text back into the original form  
- Handles file I/O operations (read/write) for encoded and decoded data  

### 🧠 How It Works
1. Reads input from `source.txt`
2. Calculates frequency of each character  
3. Builds a Huffman Tree  
4. Encodes text into binary codes  
5. Decodes encoded data and writes to output files  

### 📄 Example Files
- `letter.txt` – input text with character frequency  
- `source.txt` – raw input text to encode  
- `encoded.txt` – Huffman-encoded binary output  
- `decoded.txt` – decoded text output  

---

## 🌳 2. BinarySearchTree

**Folder:** `BinarySearchTree/`  
**Main Concepts:** Node-based tree structure, recursion, searching, and traversal  
**Core Classes:** `BinarySearchTree`, `TNode`

### 🧩 Overview
Implementation of a **Generic Binary Search Tree (BST)** supporting all major operations, including node insertion, traversal, searching, and height calculation.

### 🔍 Features
- Recursive and iterative node insertion  
- In-order, pre-order, and post-order traversals  
- Search operations (recursive and iterative)  
- Deletion of nodes (with zero, one, or two children)  
- Finding in-order successors  
- Height and node count calculation  
- Basic bubble sort for array data  

### 🧠 Example Flow
1. Insert integer elements  
2. Print traversals in order  
3. Search for values and display tree height  
4. Find in-order successor of a given node  
5. Delete elements while maintaining BST properties  

### 💻 Example Code Snippet
```java
BinarySearchTree<Integer> tree = new BinarySearchTree<>();
tree.insert(10);
tree.insert(5);
tree.insert(15);
tree.inOrder();
System.out.println("Height: " + tree.findHeight());
```
## 🌳 3. LinkedListStackQueue

**Folder:** `LinkedListStackQueue/`  
**Main Concepts:** Dynamic data structures — Linked List, Stack, Circular Queue  
**Core Classes:** `LinkedList`, `Node`, `CircularQueue`, `Stack`

### 🧩 Overview
This section focuses on implementing and optimizing data structures for search efficiency, memory tracking, and performance measurement.

### 🔍 Features
- Insertions (front, end, sorted)
- Memory access tracking for efficiency testing 
- Value search and removal while maintaining original order
- Supports enqueue, dequeue, and display operations
- Bubble sorting implementation
- Generic queue implementation with circular indexing 

### 🧠 Example Flow
1. Reads integer lists from text files
2. Inserts unique values into linked lists
3. Applies “move-to-front” optimization for frequent searches
4.Measures execution time and memory access counts
5.Demonstrates stack comparison and circular queue usage

### 💻 Example Code Snippet
```java
CircularQueue<Integer> queue = new CircularQueue<>(Integer.class, 5);
queue.enQueue(10);
queue.enQueue(20);
queue.deQueue();
queue.display();
```
## End of the README

Feel free to explore each code in detail, modify parameters as needed. If you have questions or suggestions, please open an issue or submit a pull request.
- **Email:** [catsudeebrar@gmail.com](mail)
