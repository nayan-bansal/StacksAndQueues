package Stacks_and_Queues;
public class MyQueue<K>{
	public static void main(String[] args) {
		System.out.println("Welcome to the Stack Queue Program.");
	}
	private final MyLinkedList<K> myLinkedList;
	public MyQueue() {
		myLinkedList= new MyLinkedList<>();
	}
	public void enqueue(INode<K> element) {
		myLinkedList.append(element);
	}
	public INode<K> dequeue() {
		return myLinkedList.pop();
	}
	public void printQueue() {
		myLinkedList.printMyNodes();
	}
}

interface INode<K> {
	K getKey();
	void setKey(K key);
	
	INode<K> getNext();
	void setNext(INode<K> next);
}

class MyNode<K> implements INode<K> {
	private K key;
	private INode<K> next;
	public MyNode(K key) {
		this.key = key;
		this.next = null;
	}
	@Override
	public K getKey() {
		return key;
	}
	@Override
	public void setKey(K key) {
		this.key = key;
	}
	public INode<K> getNext() {
		return next;
	}
	public void setNext(INode<K> next) {
		this.next = next;
	}
}

class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	public void add(INode<K> newNode) {
		if (this.tail == null)
		{
			this.tail = newNode;
		}
		if (this.head == null)
		{
			this.head = newNode;
		}
		else
		{
			INode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}
	public void append(INode<K> newNode) {
		if (this.tail == null)
		{
			this.tail = newNode;
		}
		if (this.head == null)
		{
			this.head = newNode;
		}
		else
		{
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}
	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}
	public INode<K> popLast() {
		INode<K> tempNode = this.head;
		while (!tempNode.getNext().equals(tail))
		{
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}
	public INode<K> search(K key) {
		INode<K> tempNode = this.head;
		while(tempNode != null && tempNode.getNext() != null)
		{
			if(tempNode.getKey().equals(key))
			{
				return tempNode;
			}
			else
			{
				tempNode=tempNode.getNext();
			}
		}
		return null;
	}
	public INode<K> insertAfterNode(K key,INode<K> newNode) {
		INode<K> tempNode = this.head;
		while(tempNode != null && tempNode.getNext() != null)
		{
			if(tempNode.getKey().equals(key))
			{
				return tempNode;
			}
			else
			{
				tempNode=tempNode.getNext();
			}
		}
		INode<K> newTempNode = tempNode.getNext();
		tempNode.setNext(newNode);
		newNode.setNext(newTempNode);
		return tempNode;
	}
	public void delete(INode<K> deleteNode) {
		INode<K> tempNode = this.head;
		INode<K> prevNode = null;
		while (tempNode != null && tempNode.getKey() != deleteNode.getKey())
		{
			prevNode = tempNode;
			tempNode = tempNode.getNext();
		}
		prevNode.setNext(tempNode.getNext());
		tempNode.setNext(null);
	}
	public int size() {
		int size = 0;
		INode<K> node = head;
		while (node != null)
		{
			size++;
			node = node.getNext();
		}
		return size;
	}
	public static <K extends Comparable<K>> boolean maximum(K key1, K key2) {
		K max = key1;
		if (key2.compareTo(max) > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public <K extends Comparable<K>> void sortList() {
		INode<K> current = (INode<K>) this.head;
		INode<K> index = null;
		K temp = null;
		if (this.head == null)
		{
			return;
		}
		else
		{
			while (current != null)
			{
				index = current.getNext();
				while(index!=null)
				{
					if(maximum(index.getKey(),current.getKey()))
					{
						temp=current.getKey();
						current.setKey(index.getKey());
						index.setKey(temp);
					}
					index=index.getNext();
				}
				current=current.getNext();
			}
		}
	}
	public void printMyNodes() {
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		INode<K> tempNode = head;
		while (tempNode.getNext() != null)
		{
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(tail))
			{
				myNodes.append("->");
			}
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}
}
