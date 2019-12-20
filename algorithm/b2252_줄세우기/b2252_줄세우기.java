package backjun_re;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node3 {
	int vertex;
	Node3 next;

	Node3(int vertex, Node3 next) {
		this.vertex = vertex;
		this.next = next;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}


	public Node3 getNext() {
		return next;
	}

	public void setNext(Node3 next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", weight=" + ", next=" + next + "]";
	}

}
public class 줄세우기 {

	static int N; static int M; static Node3[] adjList; static int[] inDegree;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M= Integer.parseInt(st.nextToken());
		adjList = new Node3[N+1];
		inDegree = new int[N+1];
		int from, to; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); from = Integer.parseInt(st.nextToken()); to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node3(to,adjList[from]);
			inDegree[to] ++; //to정점의 진입차수 증가
		}
		System.out.println(go());
	}
	private static String go() {
		Queue<Integer> queue = new LinkedList<>();
		//1. 진입차수가 0인 정점들 큐에 넣기 
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		int visitCnt = 0; int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			visitCnt +=1 ;
			sb.append(current).append(" ");
			Node3 temp = adjList[current];
			while(temp!=null) { //현재 정점의 인접 정점 처리(진입차수 1감소 : 간선 끊음의 의미)
				if(--inDegree[temp.vertex]==0) queue.offer(temp.vertex); 
				temp = temp.next; 
			}
		}
		return visitCnt == N ?sb.toString() : null;
	}

}
