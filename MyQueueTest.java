package Stacks_and_Queues;

public class MyQueueTest {

	@Test
	public void threeNumbersAddedToQueueTest() {
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
}