package com.cre8techlabs;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;

public class Node {

	private int leftDist = 0;
	private int rightDist = (int) Double.POSITIVE_INFINITY;
	private int downDist = (int) Double.POSITIVE_INFINITY;
	private int upDist = 0;

	String name;
	Rectangle rect;

	Set<String> leftNodes = new HashSet<String>();
	Set<String> rightNodes = new HashSet<String>();
	Set<String> upNodes = new HashSet<String>();
	Set<String> downNodes = new HashSet<String>();

	Node(String name) {
		this.name = name;
	}

	public Rectangle getRect() {
		return this.rect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpNode(String name, int dist) {
		if (dist > this.upDist) {
			Set<String> upNodes = new HashSet<String>();
			upNodes.add(name);
			this.upNodes = upNodes;
			this.upDist = dist;
		} else if (this.upDist == dist) {
			this.upNodes.add(name);
		}
	}

	public void setDownNode(String name, int dist) {
		if (dist < this.downDist) {
			Set<String> downNodes = new HashSet<String>();
			downNodes.add(name);
			this.downNodes = downNodes;
			this.downDist = dist;
		} else if (this.downDist == dist) {
			this.downNodes.add(name);
		}
	}

	public void setLeftNode(String name, int dist) {
		if (dist > this.leftDist) {
			Set<String> leftNodes = new HashSet<String>();
			leftNodes.add(name);
			this.leftNodes = leftNodes;
			this.leftDist = dist;
		} else if (this.leftDist == dist) {
			this.leftNodes.add(name);
		}
	}

	public void setRightNode(String name, int dist) {
		if (dist < this.rightDist) {
			Set<String> rightNodes = new HashSet<String>();
			rightNodes.add(name);
			this.rightNodes = rightNodes;
			this.rightDist = dist;
		} else if (this.rightDist == dist) {
			this.rightNodes.add(name);
		}
	}

	public Set<String> getUpNodes() {
		return this.upNodes;
	}

	public Set<String> getDownNodes() {
		return this.downNodes;
	}

	public Set<String> getLeftNodes() {
		return this.leftNodes;
	}

	public Set<String> getRightNodes() {
		return this.rightNodes;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public void fillMatrix(String[][] matrix) {
		int i, j, x = this.rect.x, y = this.rect.y;

		for (i = 0; i < this.rect.width; i++) {
			for (j = 0; j < this.rect.height; j++) {
				matrix[x + i][y + j] = this.name;
			}
		}
	}
}