package recursion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class HexagonDriver {
	final static int NHEXAGON = 7; //total number of Hexagon
	static int solutionNum = 1; //total number of solution
	static String line;
	static ArrayList<Hexagon> hexagon = new ArrayList<Hexagon>();
	static ArrayList<Hexagon> boardSize = new ArrayList<Hexagon>();
	
	//main method
	public static void main(String[] args) {
		importFromFile();
		boardSize.add(hexagon.get(0));
		//Solve given the ArrayList
		solve(hexagon);	
	}
	
	public static void solve(ArrayList<Hexagon> hexagon) {
		solve(hexagon, boardSize);
	}
	
	public static void solve(ArrayList<Hexagon> hexagon, ArrayList<Hexagon> boardSize) {
		//Base case if there are 7 hexagon in the array list
		if (boardSize.size() == NHEXAGON) {
			printBoard(boardSize);
			System.out.println("done");
		}
		else {
			for (int i = 0 ; i < hexagon.size() ; i++) {
				
				for (int j = 0 ; j < 6 ; j++) {
					Hexagon newHexagon = hexagon.get(i);
					 if(areSame(boardSize, newHexagon)){
						 boardSize.add(newHexagon);
						 System.out.println("answer" + boardSize);
						 System.out.println("HEXAGON" + hexagon);
						 hexagon.remove(i);
						 System.out.println("HEXAGON2" + hexagon);
						 solve(hexagon);
						 hexagon.add(boardSize.get(boardSize.size() - 1));
						 boardSize.remove(boardSize.size() - 1);
					 }
					 else{
						 newHexagon.canRotate();
					 }
					 
				}
				System.out.println("Moving on");
				System.out.println("finaly answer:" + boardSize);
		}
		}
	}
	
// Print out the color for the 7 position
	public static void printBoard(ArrayList<Hexagon> boardSize) {
		System.out.println("Solution Number: " + solutionNum++);
		for (int i = 0 ; i < boardSize.size();  i++) {
				System.out.println("Position: " + (i+1) + ": " + boardSize.get(i));
		}
	}

//method to check if the new hexagon is the same color as the first hexagon
	public static boolean areSame(ArrayList<Hexagon> boardSize, Hexagon newHexagon) {
			if (boardSize.size() == 0) {
				return true;
			}
			else if (boardSize.size() == 1) {
				if(boardSize.get(0).iceCream(0) == newHexagon.iceCream(3))
				return true;
			}
			else if (boardSize.size() == 2) {
				if(boardSize.get(0).iceCream(1) == newHexagon.iceCream(4) && boardSize.get(1).iceCream(2) == newHexagon.iceCream(5))
				return true;
			}
			else if (boardSize.size() == 3) {
				if(boardSize.get(0).iceCream(2) == newHexagon.iceCream(5) && boardSize.get(2).iceCream(3) == newHexagon.iceCream(0))
				return true;
			}
			else if (boardSize.size() == 4) {
				if(boardSize.get(0).iceCream(3) == newHexagon.iceCream(0) && boardSize.get(3).iceCream(4) == newHexagon.iceCream(1))
				return true;
			}
			else if (boardSize.size() == 5) {
				if(boardSize.get(0).iceCream(4) == newHexagon.iceCream(1) && boardSize.get(4).iceCream(2) == newHexagon.iceCream(5))
				return true;
			}
			else if (boardSize.size() == 6) {
				if(boardSize.get(0).iceCream(5) == newHexagon.iceCream(2) && boardSize.get(5).iceCream(0) == newHexagon.iceCream(3)
				   && boardSize.get(1).iceCream(4) == newHexagon.iceCream(1))
				return true;
			}
//			if (emptyList.size() == 0) {
//			return true;
//		} else if (emptyList.size() == 1) {
//			if (hexagon.get(0).iceCream(0) == newHexagon.iceCream(3))
//				return true;
//		} else if (emptyList.size() == 2) {
//			if (hexagon.get(0).iceCream(1) == newHexagon.iceCream(4)
//					&& emptyList.get(1).iceCream(2) == newHexagon.iceCream(5))
//				return true;
//		} else if (emptyList.size() == 3) {
//			if (hexagon.get(0).iceCream(2) == newHexagon.iceCream(5)
//					&& emptyList.get(2).iceCream(3) == newHexagon.iceCream(0))
//				return true;
//		} else if (emptyList.size() == 4) {
//			if (hexagon.get(0).iceCream(3) == newHexagon.iceCream(0)
//					&& emptyList.get(3).iceCream(4) == newHexagon.iceCream(1))
//				return true;
//		} else if (emptyList.size() == 5) {
//			if (hexagon.get(0).iceCream(4) == newHexagon.iceCream(1)
//					&& emptyList.get(4).iceCream(5) == newHexagon.iceCream(2))
//				return true;
//		} else if (emptyList.size() == 6) {
//			if (hexagon.get(0).iceCream(5) == newHexagon.iceCream(2)
//					&& emptyList.get(5).iceCream(0) == newHexagon.iceCream(3)
//					&& emptyList.get(1).iceCream(4) == newHexagon.iceCream(1))
//				return true;
//		}
			return false;
	}
	
	// A method that imports a list 
	public static void importFromFile() {	
		JFileChooser chooseFile = new JFileChooser();
		int retVal = chooseFile.showOpenDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File fileSelected = chooseFile.getSelectedFile();
			try {
				Scanner freader = new Scanner(fileSelected);
				while (freader.hasNextLine()) {
					line = freader.nextLine();
					Hexagon hex = new Hexagon(line);
					hexagon.add(hex);
				}
				freader.close(); // Close to unlock.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
