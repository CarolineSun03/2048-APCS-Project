
public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b = new Board();

		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		/*
		int[] sample1 = {0,0,0,0};
		int[] sample2 = {1,0,0,0};
		int[] sample3 = {0,1,0,0};
		int[] sample4 = {0,0,1,0};
		int[] sample5 = {0,0,0,1};
		int[] sample6 = {1,1,0,0};
		int[] sample7 = {1,0,1,0};
		int[] sample8 = {1,0,0,1};
		int[] sample9 = {0,1,1,0};
		int[] sample10 = {0,1,0,1};
		int[] sample11 = {0,0,1,1};
		int[] sample12 = {1,1,1,0};
		int[] sample13 = {1,1,0,1};
		int[] sample14 = {1,0,1,1};
		int[] sample15 = {0,1,1,1};
		int[] sample16 = {1,1,1,1};
		*/
		
		//invoke the slideRight method on the array 
		/* 
		b.slideRight(sample1);
		b.slideRight(sample2);
		b.slideRight(sample3);
		b.slideRight(sample4);
		b.slideRight(sample5);
		b.slideRight(sample6);
		b.slideRight(sample7);
		b.slideRight(sample8);
		b.slideRight(sample9);
		b.slideRight(sample10);
		b.slideRight(sample11);
		b.slideRight(sample12);
		b.slideRight(sample13);
		b.slideRight(sample14);
		b.slideRight(sample15);
		b.slideRight(sample16);

		b.slideLeft(sample1);
		b.slideLeft(sample2);
		b.slideLeft(sample3);
		b.slideLeft(sample4);
		b.slideLeft(sample5);
		b.slideLeft(sample6);
		b.slideLeft(sample7);
		b.slideLeft(sample8);
		b.slideLeft(sample9);
		b.slideLeft(sample10);
		b.slideLeft(sample11);
		b.slideLeft(sample12);
		b.slideLeft(sample13);
		b.slideLeft(sample14);
		b.slideLeft(sample15);
		b.slideLeft(sample16);
		*/

		//print out the array to see if slideRight
		//worked
		/*
		for (int element: sample1) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample2) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample3) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample4) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample5) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample6) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample7) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample8) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample9) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample10) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample11) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample12) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample13) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample14) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample15) {
            System.out.print(element + " ");
        }
		System.out.println();
		for (int element: sample16) {
            System.out.print(element + " ");
        }
		System.out.println();
		*/
		b.populateOne();
		b.populateOne();
		b.populateOne();
		b.populateOne();
		System.out.println(b.toString());

		
		b.slideRight();
		b.combineRight();
		System.out.println(b.toString());
		
		b.slideLeft();
		b.combineLeft();
		System.out.println(b.toString());
		/* 
		b.slideUp();	
		System.out.println(b.toString());

		b.slideDown();	
		System.out.println(b.toString());
		*/	
	}
}
