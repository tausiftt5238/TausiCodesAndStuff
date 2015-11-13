import java.util.Scanner;

public class FloydWarshall {
	
	Scanner s = new Scanner(System.in);
	int numberOfNodes;
	int adjMatrix[][];
	
	public FloydWarshall(){
		numberOfNodes = s.nextInt();
		adjMatrix = new int[numberOfNodes][numberOfNodes];
		input();
		floydWarshall();
		for(int i = 0 ; i < numberOfNodes ; i++){
			for(int j = 0 ; j < numberOfNodes; j++){
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();	
		}
	}
	public void input(){
		init();
		int numberOfInput = s.nextInt();
		for(int i = 0 ; i < numberOfInput; i++){
			int x = s.nextInt();
			int y = s.nextInt();
			adjMatrix[x][y] = s.nextInt();
		}
	}
	public void init(){
		for(int i = 0 ; i < numberOfNodes ; i++){
			for(int j = 0 ; j < numberOfNodes; j++){
				if(i != j) adjMatrix[i][j] = (1<<28);
			}
		}
	}
	public void floydWarshall(){
		for(int k = 0 ; k < numberOfNodes ; k++){
			for(int i = 0 ; i < numberOfNodes ; i++){
				for(int j = 0 ; j < numberOfNodes; j++){
					if(adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j]){
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
	}
	
}
