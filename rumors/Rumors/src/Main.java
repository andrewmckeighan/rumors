import java.util.Scanner;

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
			storeMatrix(Integer.parseInt(line), scan);
		}
		scan.close();
	}

	public static void storeMatrix(int size, Scanner scan) {
		int arr[][] = new int[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j<size; j++){
				
			}
		}
		
		
	}
}
