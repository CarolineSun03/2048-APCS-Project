
public class Activity2Tester {

	public static void main(String[] args) {
		//Create a Board object
		Board b = new Board();
		
		//call the populateOne method and print out the board each time
		//does it fill a random location? How about if the board is almost
		//full? Does it still work?
		b.populateOne();
		System.out.println(b.toString());
		b.populateOne();
		System.out.println(b.toString());
		b.eraseBoard();
	}

}
