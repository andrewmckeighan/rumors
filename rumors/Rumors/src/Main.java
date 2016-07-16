/**
 * @author Andrew McKeighan
 * Iowa State University
 * CS311 Dr. Mitra
 * Homework 2 "Rumors"
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String read = "";
		Scanner scan = new Scanner(System.in);
		readInput(scan, read);
	}

	public static void readInput(Scanner scan, String line){
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			while(line.equals("")){
				line = scan.nextLine();
			}
			if(Integer.parseInt(line) == 0){
				break;
			}
			storeMatrix(Integer.parseInt(line), scan);//stores the broker information into a matrix.
		}
		scan.close();
	}
	/**
	 * 
	 * @param size = The size of the array
	 * @param scan = The scanner that is used throughout the program
	 */
	public static void storeMatrix(int size, Scanner scan) { //Stores the broker info on a matrix
		int arr[][] = new int[size][size];
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				if(i==j){
					arr[i][j]=0;
				}else{
					arr[i][j] = 11;		//Sets all to be 11 because that is MAX+1
				}						//This is just to keep track of null or zero objects.
			}							
		}
		String line = scan.nextLine();
		StringTokenizer st;
		int contacts;
		int temp;
		
		/**
		 * This is where the broker infomation gets added into the matrix.
		 * 
		 */
		for(int i = 0; i < size; i++){
			st = new StringTokenizer(line);
			contacts = Integer.parseInt(st.nextToken());
			for(int j = 0; j<contacts; j++){
				temp = Integer.parseInt(st.nextToken());
				arr[i][temp-1] = Integer.parseInt(st.nextToken());
			}
			if(i<size-1){
				line = scan.nextLine();
			}
		}
		
		
	}
}
