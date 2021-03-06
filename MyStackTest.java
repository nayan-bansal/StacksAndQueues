package Stacks_and_Queues;

import org.junit.Assert.*;

import org.junit.Test;



public class StacksTest {
	@Test
	public void threeNumbersPushedToStackTest() {
		MyNode<Integer> firstNode = new MyNode<Integer>(70);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(56);
		Stacks<Integer> myStack = new Stacks<Integer>();
		myStack.push(firstNode);
		myStack.push(secondNode);
		myStack.push(thirdNode);
		INode<Integer> peak = myStack.peak();
		myStack.printStack();
		Assert.assertEquals(thirdNode, peak);
	}

@Test
	public void threeNumbersPoppedFromStackTest() {
		MyStack<Integer> myStack = new MyStack<Integer>();
		MyNode<Integer> firstNode = new MyNode<Integer>(70);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(56);
		myStack.push(firstNode);
		myStack.push(secondNode);
		myStack.push(thirdNode);
		myStack.printStack();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		INode<Integer> peak = myStack.peak();
		Assert.assertEquals(null, peak);
	}

}
