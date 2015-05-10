import java.util.Scanner;

public class LinkedList {

	private Node first, last;
	private Scanner sc;

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

		// Choose mode
		while (true) {

			System.out.println("Type in a word to continue...\n"
					+ "d: delete the first node.\n"
					+ "i: insert node at position. \n"
					+ "s: show all node in linked list.");

			linkedList.sc = new Scanner(System.in);
			String mode = linkedList.sc.nextLine();

			// Choose remove mode.
			if (mode.equals(DELETE_NODE)) {

				System.out.println("You can remove node at position.\n"
						+ "f = remove first node\n" + "l = remove last node\n"
						+ "m = remove node where you want to remove");

				linkedList.deleteNode(linkedList.sc.nextLine());
				linkedList.showNode();
			}

			// Choose insert mode.
			else if (mode.equals(INSERT_NODE)) {

				System.out.println("You can insert node at position.\n"
						+ "f = before first node\n" + "l = after last node\n"
						+ "m = after position where you want to insert");

				linkedList.insertNode(linkedList.sc.nextLine());
				linkedList.showNode();
			}

			// Choose show mode.
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
	private void insertNode(String mode) {

		Node newNode;

		// insert before first position
		if (mode.equals(INSERT_TO_THE_FIRST)) {

			newNode = new Node(00000, "Insert to the first", 101);
			newNode.next = first;
			first = newNode;
		}

		// insert at last position
		else if (mode.equals(INSERT_TO_THE_LAST)) {

			newNode = new Node(999, "Insert to the last node", 102);
			last.next = newNode;
			last = newNode;
		}

		// Insert node at the specific position
		else if (mode.equals(INSERT_TO_THE_POSITION)) {

			System.out
					.println("You can insert a node after the position, so Which position do you want to insert ?");
			int position = Integer.parseInt(sc.nextLine());

			// Insert node after the position.
			if (position != 0 && position > 0) {

				// the tmp is at the first node, so position must -1, beacuse it
				// start from the first one
				Node tmp = first;
				Node nextNode = null;
				position -= 1;

				while (position > 0) {

					tmp = tmp.next;
					position -= 1;

					// The position is out of last node
					if (tmp == null) {

						System.out.println("Out of range");
						return;
					}
				}

				nextNode = tmp.next;

				newNode = new Node(555, "insert in position", 50);
				tmp.next = newNode;
				newNode.next = nextNode;

			}

			// Type in 0 or not number
			else {
				System.out.println("Error!");
			}

		}

		// Does not type in f, m, l.
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

		// Remove the specific node
		else if (mode.equals(REMOVE_THE_POSITION)) {

			System.out.println("Which do you want to remove?");
			int position = Integer.parseInt(sc.nextLine());

			// the position is the first one
			if (position == 1) {

				deleteNode(REMOVE_THE_FIRST);

				// not the first one
			} else {

				Node tmp = null;
				position -= 1;

				// move the pointer to the next
				while (position > 0) {

					position -= 1;

					// tmp move to pointer's position, and pointer move to the
					// next position
					tmp = pointer;
					pointer = pointer.next;

					// if position > linked list size, then display the error
					// message
					if (pointer == null) {

						System.out.println("Position is out of range.");
						return;
					}
				}

				// If the position is the last node, then call method to remove
				// the last one.
				if (pointer.next != null)
					tmp.next = pointer.next;
				else
					deleteNode(REMOVE_THE_LAST);
			}
		}

		// Remove the last node.
		else if (mode.equals(REMOVE_THE_LAST)) {

			// tmp is at pointer's next position
			Node tmp = pointer.next;

			// move the pointer, does tmp at the last position?
			while (tmp.next != null) {

				// move pointer to next, and also move tmp to the next.
				pointer = pointer.next;
				tmp = tmp.next;
			}

			last = pointer;
			last.next = null;

		}

		else
			System.out.println("Error!");

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
}
