package collections1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue1 {

	public static void main(String[] args) {

		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
		Queue<Integer> queue3 = new ArrayDeque<Integer>(1);
		Queue<Integer> queue4 = new LinkedBlockingQueue<Integer>(1);
		
	}

}
