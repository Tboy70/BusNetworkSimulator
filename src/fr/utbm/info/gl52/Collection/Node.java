package fr.utbm.info.gl52.Collection;

import java.util.*;

import fr.utbm.gl52.tree.BinaryTreeNode;

/**
 * 
 */
public class Node<D>  extends AbstractNode<D, Node<D>> {

	/**
	 * The child at the left.
	 */
	private Node<D> leftChild;
	
	/**
	 * The child at the right.
	 */
	private Node<D> rightChild;
	
	/**
	 * Data of the node.
	 */
	private D data;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param data Data of the node.
	 */
	public Node(D data) {
		super();
		this.leftChild = null;
		this.rightChild = null;
		this.data = data;
	}
	
	@Override
	public void setParentNode(Node<D> iparent) {
		super.setParentNode(iparent);
	};

	@Override
	public int getChildCount() {
		int nbChild = 0;
		if (this.leftChild != null) {
			nbChild++;
		}
		if (this.rightChild != null) {
			nbChild++;
		}
		return nbChild;
	}
	
	/**
     * To get the left child
     * 
     * @return the left child
     */
    public Node<D> getLeftChild() {
            return this.leftChild;
    }

    /**
     * To set the left child
     * 
     * @param leftChild BinaryTreeNode The left child
     */
    public void setLeftChild(Node<D> leftChild) {
            this.leftChild = leftChild;
            leftChild.setParentNode(this);
    }

    /**
     * To get the right child
     * 
     * @return the right child
     */
    public Node<D> getRightChild() {
            return this.rightChild;
    }

    /**
     * To set the right child
     * 
     * @param rightChild BinaryTreeNode the right child
     */
    public void setRightChild(Node<D> rightChild) {
            this.rightChild = rightChild;
            rightChild.setParentNode(this);
    }

	@Override
	public D getUserData() {
		return this.data;
	}

	@Override
	public void setUserData(D data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRoot() {
		if(this.getParentNode() == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean isLeaf() {
		if (this.leftChild == null && this.rightChild == null) {
			return true;
		}
		return false;
	}

	@Override
	public void getParentNode(Node<D> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node<D> getChildAt(int index) throws IndexOutOfBoundsException {
		if (index == 0 ) {
			return this.leftChild;
		} else if (index == 1) {
			return this.rightChild;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void setChildAt(int index, Node<D> node)
			throws IndexOutOfBoundsException {
		switch (index) {
		case 0 :
			if (this.leftChild == null) {
				if (node != null) {
					this.leftChild = node;
					node.setParentNode(this);
				}
			}
			break;
		case 1:
			if (this.rightChild == null) {
				if (node != null) {
					this.rightChild = node;
					node.setParentNode(this);
				}
			}
			break;
		default:
			throw new IndexOutOfBoundsException();
		}		
	}
}