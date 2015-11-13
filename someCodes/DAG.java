import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DAG {
	int adjMatrix[][];
	int numberOfNodes;
	int noOfAdjacentNode[];
	int numberOfPath[];
	int noOfPath = 0;
	int time;
	int color[];
	int discoveryTime[];
	int finishTime[];
	int parent[];
	int weight[];
	Stack<Integer> stack;
	ArrayList<Integer> arr;
	Scanner s = new Scanner(System.in);
	public DAG(){
		numberOfNodes = s.nextInt();
		adjMatrix = new int[numberOfNodes][numberOfNodes];
		noOfAdjacentNode = new int[numberOfNodes];
		color = new int[numberOfNodes];
		discoveryTime = new int[numberOfNodes];
		finishTime = new int[numberOfNodes];
		parent = new int[numberOfNodes];
		numberOfPath = new int[numberOfNodes];
		weight = new int[numberOfNodes];
		input();
		stack = new Stack<Integer>();
		arr = new ArrayList<Integer>();
		DFS(0);  //source = 0;
		noOfPath = 0;
		numberOfPaths();
		System.out.println(noOfPath);
		dagShortestPath(1);
		for(int i = 0 ; i < numberOfNodes ; i++){
			System.out.print(weight[i] + " ");
		}
	}
	public void input(){
		int numberOfInput = s.nextInt();
		for(int i = 0 ; i < numberOfInput; i++){
			int x = s.nextInt();
			int y = s.nextInt();
			adjMatrix[x][y] = s.nextInt();
		}
	}
	public void init(){
		for(int i = 0 ; i < numberOfNodes ; i++){
			weight[i] = (1 << 28);
		}
	}
	public void DFS(int src){
        color[src] = 1;
        time++;
        discoveryTime[src] = time;
        for(int j = 0 ; j < numberOfNodes; j++){
            if(adjMatrix[src][j] != 0){
                if(color[j] == 0){
                    parent[j] = src;
                    DFS(j);
                }
            }
        }
        color[src] = 2;
        time++;
        finishTime[src] = time;
        stack.push(src);
        arr.add(src);
    }
	public void numberOfPaths(){
		for(int v: arr){
			numberOfPath[v] = 0;
			for(int i = 0 ; i < numberOfNodes; i++){
				if(adjMatrix[v][i] != 0){
					int u = i;
					numberOfPath[v] = numberOfPath[v] + numberOfPath[u] + 1;
					
				}
			}
			noOfPath += numberOfPath[v];
		}
	}
	public void dagShortestPath(int src){
		init();
		weight[src] = 0;
		while(!stack.empty()){
			int u = stack.pop();
			for(int i =  0 ; i < numberOfNodes; i++){
				if(adjMatrix[u][i]!=0){
					relax(u,i,adjMatrix[u][i]);
				}
			}
		}
	}
	private void relax(int u,int v,int w ){
		if(weight[v] > weight[u] + w){
			weight[v] = weight[u] + w;
		}
	}
}
