
public class Node {

	public int mId, score;
	public String name;
	public Node next;
	
	public Node(int mId, String name, int score){
		
		this.mId = mId;
		this.name = name;
		this.score = score;
		this.next = null;
	}
}
