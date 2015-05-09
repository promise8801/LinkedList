import java.util.Scanner;

public class LinkedList {

	private Node first, last;
	private Scanner sc;
	private LinkedList ll;

	// What do you want to do?
	private final static String DELETE_NODE = "d";
	private final static String INSERT_NODE = "i";
	private final static String SHOW_NODE = "s";

	// Which do you want to insert?
	private final static String INSERT_TO_THE_FIRST = "f";
	private final static String INSERT_TO_THE_LAST = "l";
	private final static String INSERT_TO_THE_POSITION = "m";

	// Which do you want to remove?
	private final static String REMOVE_THE_FIRST = "f";
	private final static String REMOVE_THE_LAST = "l";
	private final static String REMOVE_THE_POSITION = "m";

	// private LinkedList linkedList = new LinkedList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		Node newNode;

		System.out.println("Here are default data.");

		// Insert default data into LinkedList
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				newNode = new Node(i, "san", 90);

				linkedList.first = newNode;
				linkedList.last = newNode;
				break;

			case 1:
				newNode = new Node(i, "si", 65);

				linkedList.last.next = newNode;
				linkedList.last = newNode;
				break;

			case 2:
				newNode = new Node(i, "wu", 100);

				linkedList.last.next = newNode;
				linkedList.last = newNode;
				break;
			}
		}

		linkedList.showNode();

		while (true) {

			System.out.println("Type in a word to continue...\n"
					+ "d: delete the first node.\n"
					+ "i: insert node at position. \n"
					+ "s: show all node in linked list.");

			linkedList.sc = new Scanner(System.in);
			String mode = linkedList.sc.nextLine();

			if (mode.equals(DELETE_NODE)) {

				System.out.println("You can remove node at position.\n"
						+ "f = remove first node\n" + "l = remove last node\n"
						+ "m = remove node where you want to remove");

				linkedList.deleteNode(linkedList.sc.nextLine());
				linkedList.showNode();
			}

			else if (mode.equals(INSERT_NODE)) {

				System.out.println("You can insert node at position.\n"
						+ "f = before first\n" + "l = after last\n"
						+ "m = after position where you want to insert");

				linkedList.insertNode(linkedList.sc.nextLine());
				linkedList.showNode();
			}

			else if (mode.equals(SHOW_NODE)) {

				linkedList.showNode();
			}

			else {

				System.out.println("Error!");
			}

		}
	}

	/**
	 * 
	 * @param linkedList
	 * @param whichOne
	 *            : you can insert node at position. e.g.: f = first, l = last,
	 *            m = position
	 */
	private void insertNode(String position) {

		Node newNode;
		// insert at first position
		if (position.equals(INSERT_TO_THE_FIRST)) {

			Node tmp = first;

			if (first.mId == 0)
				increaseNodeId(tmp);

			newNode = new Node(0, "Insert to the first", 101);
			newNode.next = first;
			first = newNode;
		}

		// insert at last position
		else if (position.equals(INSERT_TO_THE_LAST)) {

			newNode = new Node(last.mId + 1, "Insert to the last node", 102);
			last.next = newNode;

		}

		// if position out of range , check!
		else if (position.equals(INSERT_TO_THE_POSITION)) {

			System.out.println("Where do you want to insert?");
			int where = Integer.parseInt(sc.nextLine());

			if (where == first.mId || where == 0) {

				insertNode(INSERT_TO_THE_FIRST);
				return;
			}

			Node tmp = first;
			Node nextNode = null;

			while (tmp.next.mId != where) {

				tmp = tmp.next;
			}

			increaseNodeId(tmp.next);

			nextNode = tmp.next;

			newNode = new Node(tmp.mId + 1, "insert in position", 50);
			tmp.next = newNode;
			newNode.next = nextNode;
		}

		else
			System.out.println("Error!");

	}

	/**
	 * 
	 * @param mode
	 *            : choose remove mode. e.g.: f = remove first, l = remove last,
	 *            m = remove position.
	 */
	private void deleteNode(String mode) {

		Node pointer = first;

		if (mode.equals(REMOVE_THE_FIRST)) {

			first = pointer.next;
			return;
		}

		else if (mode.equals(REMOVE_THE_POSITION)
				|| mode.equals(REMOVE_THE_LAST)) {

			System.out.println("Where do you want to remove?");

			int position = Integer.parseInt(sc.nextLine());

			while (pointer != null) {

				if (position == first.mId) {

					deleteNode(REMOVE_THE_FIRST);
					return;
				} else {
					if (pointer.next.mId == position) {

						Node tmp = pointer.next;
						pointer.next = tmp.next;

						return;

					} else
						pointer = pointer.next;

				}
			}
		}
	}

	/**
	 * Show all node in linked list.
	 */
	private void showNode() {

		Node tmp = first;

		while (tmp != null) {
			System.out.println("mId: " + tmp.mId);
			System.out.println("name: " + tmp.name);
			System.out.println("score: " + tmp.score);
			System.out.println("------------------------");

			tmp = tmp.next;
		}

	}

	private int inputInteger(Scanner sc) {

		int inInteger = Integer.parseInt(sc.nextLine());

		return inInteger;
	}

	/**
	 * You can use this method to increase mId.
	 * 
	 * @param tmp
	 *            : The start line to increase mId.
	 */
	private void increaseNodeId(Node tmp) {

		while (tmp != null) {

			tmp.mId += 1;
			tmp = tmp.next;
		}
	}

}
