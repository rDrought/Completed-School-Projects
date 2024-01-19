package Assignment4;

public class Dijkstra {

	// disply the adjacent matrix: Matrix.
	public void displayMatrix(Integer[][] Matrix)	{
		for(int i=0; i < Matrix.length; i++){
			for(int j=0; j < Matrix[i].length; j++){
				if (Matrix[i][j]==Integer.MAX_VALUE) {
					System.out.print(" Inf");
				}else {
					System.out.print(" "+Matrix[i][j]);
				}
			}
			System.out.println();
		}    	
	}

	// your code here.      
	public void findShortestPath(Integer[][] adjMatrix, Integer[][] weightMatrix, int source) {
		int INF = Integer.MAX_VALUE;
		Integer dist[] = { 0, INF, INF, INF, INF}; //create a distance array with source at 0, rest infinity
		Integer pred[] = {-1, -1, -1, -1, -1}; //create pred array with all -1
		Integer visited[] = { 0, 0, 0, 0, 0 }; //create visited vertices array, initially all unvisited

		int visited_count = 0; //number of vertices visited: whose distance is finalized
		System.out.println("S | d | pred |\n---------------------------------------------------------------------------");
		while (visited_count < dist.length) { //loop until all vertices are visited
			printVisited(visited); //print visited array
			printDistances(visited, dist); //print distances array
			printPred(visited, pred); //print pred array
			int v = getMinimum(dist, visited); //get minimum distance vertex from unvisited vertices
			visited[v] = 1; //mark that vertex as visited
			for (int j = 0; j<adjMatrix[v].length; j++) { //update neighbours if smaller distance can be obtained
				if (adjMatrix[v][j] == 1 && dist[v] + weightMatrix[v][j]<dist[j]) {
					dist[j] = dist[v] + weightMatrix[v][j]; //update the distance
					pred[j] = v; //pred[j] is v, since path to j is smaller via v
				}
			}
			visited_count++; //increment visited count
			if (visited_count == 3)
			{
				System.out.println();
				System.out.print("Program Written By: Alexander Chukwuka 215259294, Halfway To GO!");
			}
			System.out.print("\n");
		}
		printVisited(visited);
		printDistances(visited, dist);
		printPred(visited, pred);
		System.out.print("\n");
	}

	//Returns minimum distance vertex from unvisited vertices
	public static int getMinimum(Integer[] dist, Integer[] visited) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i<dist.length; i++) {
			if (visited[i] == 0 && dist[i]<min) { //get unvisited vertex with minimum distance
				min = dist[i];
				min_index = i;
			}
		}
		return min_index; //returns index of the minimum distance vertex
	}
	public static void printVisited(Integer[] visited) { //prints the visited visited vertices
		for (int i = 0; i<visited.length; i++) {
			if (visited[i] == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.print("| ");
	}
	public static void printDistances(Integer[] visited, Integer[] dist) {
		int INF = Integer.MAX_VALUE; //prints the distances of the unvisited vertices
		for (int i = 0; i<visited.length; i++) {
			if (visited[i] == 0) {
				if (dist[i] == INF)
					System.out.print("d[" + i + "]=Inf ");
				else
					System.out.print("d[" + i + "]=" + dist[i] + " ");
			}
		}
		System.out.print("| ");
	}
	public static void printPred(Integer[] visited, Integer[] pred) {
		for (int i = 0; i<visited.length; i++) { //prints pred of the unvisited vertices
			if (visited[i] == 0 && pred[i] != -1) {
				System.out.print("p[" + i + "]=" + pred[i] + " ");
			}
		}
		System.out.print("| ");
	}
}