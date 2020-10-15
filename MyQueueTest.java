package Stacks_and_Queues;

public class MyQueueTest {

		@Test
	public void createQueueTest() {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		MyNode<Integer> firstNode = new MyNode<Integer>(56);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(70);
		myQueue.enqueue(firstNode);
		myQueue.enqueue(secondNode);
		myQueue.enqueue(thirdNode);
		myQueue.printQueue();
		Assert.assertEquals((int) firstNode.getKey(), 56);
	}
	@Test
	public void dequeueTest() {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		MyNode<Integer> firstNode = new MyNode<Integer>(56);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(70);
		myQueue.enqueue(firstNode);
		myQueue.enqueue(secondNode);
		myQueue.enqueue(thirdNode);
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		INode<Integer> peak = myQueue.dequeue();
		Assert.assertEquals(thirdNode, peak);
	}
}