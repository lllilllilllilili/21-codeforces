줄세우기
```
ArrayList<Integer> go[] = (ArrayList<Integer>[]) new ArrayList[n+1]; //어레이 리스트를 
배열로 생성
		for(int i=1; i<=n; i++) {
			go[i] = new ArrayList<>(); 
		}
        //어레이 리스트를 사용하는 노드는 인접리스트를 구현하기 위함입니다.
```
```
int[] gote = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
            //줄세우기로 두명의 키를 입력받은후 이때 a가 b 앞에 오게 되므로 
			go[a].add(b);
            //a->b 이런 노드와 간선으로 이루어진 모습일것입니다.
			gote[b]++;
            //따라서 b 노드에 a노드 하나가 붙어있으므로 연결된 간선 하나를 증가시켜줍니다.
		}
```
```
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(gote[i]==0)
            //노드를 확인하면서 연결된 간선이 0인것(즉, 인그리디=노드로 들어오는 화살표)을 큐에 넣어줍니다.
				q.add(i);
		}
```
```
while(!q.isEmpty()) {
			int s = q.poll();
			System.out.print(s+" "); //큐에 적재된 순서가 문제에서 요구하는 줄을 세우는 순서가 됩니다.
			for(int i=0; i<go[s].size(); i++) {
				int next= go[s].get(i); //또, 인접리스트로 구현되었기 때문에 인접된 노드를 확인
				gote[next]-=1; //실제로 간선은 연결되어있지만, 간선을 삭제 한다 의미를 -1로 수행
				if(gote[next]==0) //인그리디가 0이라면 큐에 적재 
					q.add(next);
			}
		}
```