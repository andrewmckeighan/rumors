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
	/**
	 * Basically reads the first line for each set of brokers.
	 * For the example given:
	 * 3 <<<----------
	 * 2 2 4 3 5
	 * 2 1 2 3 6
	 * 2 1 2 2 2
	 * 5 <<<----------
	 * ... and so on, it will read the numbers 3, 5 and the 0 at the end.
	 * 
	 * @param scan = A scanner.
	 * @param line = The line read by the scanner.
	 */
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
	 * Stores the broker information into a matrix.
	 * @param size = The size of the array
	 * @param scan = The scanner that is used throughout the program
	 */
	public static void storeMatrix(int size, Scanner scan) {
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
		floydWarshall(arr, size);
		
	}
	
	public static void floydWarshall(int arr[][], int size){
		int i, j;
		int k;
		int through_k;
		for(k=0; k<size; k++){
			for(i=0; i<size; i++){
				for(j=0; j<size; j++){
					through_k = arr[i][k]+arr[k][j];
					if(through_k < arr[i][j]){
						arr[i][j] = through_k;
					}
				}
			}
		}
	}
}

