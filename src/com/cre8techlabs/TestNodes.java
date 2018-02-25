package com.cre8techlabs;

import java.awt.Rectangle;
import java.util.HashMap;

public class TestNodes {
	static String[][] matrix = new String[13][5];
	static HashMap<String, Node> map = new HashMap<String, Node>();

	public static void main(String[] args) {
		Node a = createNode(0, 0, 3, 1, "A");
		map.put("A", a);
		Node b = createNode(6, 0, 3, 1, "B");
		map.put("B", b);
		Node c = createNode(5, 1, 2, 1, "C");
		map.put("C", c);
		Node d = createNode(8, 1, 3, 1, "D");
		map.put("D", d);
		Node e = createNode(2, 2, 4, 2, "E");
		map.put("E", e);
		Node f = createNode(7, 2, 2, 1, "F");
		map.put("F", f);
		Node g = createNode(10, 2, 3, 2, "G");
		map.put("G", g);
		Node h = createNode(1, 4, 10, 1, "H");
		map.put("H", h);
		for (Node n : map.values()) {
			n.fillMatrix(matrix);
		}
		// Left Nodes
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int left = i;
				if (matrix[left][j] != null) {
					while (left >= 0) {
						if (matrix[left][j] != null && matrix[left][j] != matrix[i][j]) {
							map.get(matrix[i][j]).setLeftNode(matrix[left][j], left);
						}
						left--;
					}
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			// Right Nodes
			for (int j = 0; j < matrix[0].length; j++) {
				int right = i;
				if (matrix[right][j] != null) {
					while (right < matrix.length) {
						if (matrix[right][j] != null && matrix[right][j] != matrix[i][j]) {
							map.get(matrix[i][j]).setRightNode(matrix[right][j], right);
						}
						right++;
					}
				}
			}
			// Up Nodes
			for (int j = 0; j < matrix[0].length; j++) {
				int up = j;
				if (matrix[i][up] != null) {
					while (up >= 0) {
						if (matrix[i][up] != null && matrix[i][up] != matrix[i][j]) {
							map.get(matrix[i][j]).setUpNode(matrix[i][up], up);
						}

						up--;
					}
				}
			}
			// Down Nodes
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				int down = j;
				if (matrix[i][down] != null) {
					while (down < matrix[0].length) {
						if (matrix[i][down] != null && matrix[i][down] != matrix[i][j]) {
							map.get(matrix[i][j]).setDownNode(matrix[i][down], down);
						}
						down++;
					}
				}
			}
		}
		displayRecursivelyAllNodesFromParentNode();
	}

	private static void displayRecursivelyAllNodesFromParentNode() {
		if (matrix.length > 0) {
			for (int i = 0; i < matrix[0].length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[j][i] == null)
						System.out.print(" ");
					else
						System.out.print(matrix[j][i]);
				}
				System.out.print("\n");
			}
		}
		for (Node n : map.values()) {
			System.out.println("\n" + n.getName() + " {\n" + "    upNodes: " + n.getUpNodes() + ", \n    downNodes: "
					+ n.getDownNodes() + ", \n    leftNodes: " + n.getLeftNodes() + ", \n    rightNodes: "
					+ n.getRightNodes() + ",\n}");
		}
	}

	private static Node createNode(int x, int y, int width, int height, String data) {
		Node result = new Node(data);
		result.setRect(new Rectangle(x, y, width, height));
		return result;
	}
}
