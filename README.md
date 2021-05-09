# super-idea-repository




Type | Name | Platform | Number | Level | Describe

e.g) Add | 욕심쟁이판 | BOJ | 1937 | 골드3 | DFS컨셉에 DP를 함께 사용해야 합니다



[![Algorithm](https://img.shields.io/badge/Algorithm-Kakao%20Talk%20%3A%20%EC%9E%90%EB%B0%94%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%20%EB%B0%A9-Red.svg?logo=baidu)](https://open.kakao.com/o/gK0gr6T)


[![Sccore](https://img.shields.io/badge/15--16-%EB%A0%88%EC%8A%A4%ED%84%B0%EC%9A%B0%EC%8A%B9-blue.svg?logo=facebook)](https://www.lcfc.com/)




- [Introduction](#introduction)


- [Background](#background)


- [Development](#development)


- [Infomation](#infomation)


- [Category](#Category)





## Introduction



## Background


- [BFS/DFS](https://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF): 그래프이론 관련 내용





## Development


### Install





```bash


$ git clone https://github.com/lllilllilllilili/algorithmWithDonburi.git


```


### Testing





```bash


$ git checkout -b {branchName}


$ git remote add {align} {git repository URL}


$ git push {remoteAlign} {branch}


```



## Infomation


We solve on the **backjun**





## Category



##### BFS


> - [구슬탈출](./algorithm/BFS/b_구슬탈출/구슬탈출.java) | BFS로 해결, 시뮬레이션, 조건이 까다로움
> - [연구소3](./algorithm/BFS/b17142_연구소3/boj_17142_연구소3.java) | BFS 문제, 문제의 조건을 확인하고 완전탐색
> - [스타트링크](./algorithm/BFS/스타트링크/스타트링크.java) | 문제에서 주어진 조건에 따라 BFS를 돌면서 G 인경우 기저조건을 만들어주면 됩니다.
> - [탈출](./algorithm/BFS/탈출/탈출.java) | 한칸 이동할 때마다 시간을 증가해서 물인 경우 고슴도치인 경우 각각을 확인하면 된다.
> - [토마토](./algorithm/BFS/토마토/토마토.java) | 동작원리, 입력받은 맵으로부터 1 이라고 써인 위치의 지점을 큐에 넣습니다. 큐에서 꺼내어 4방향(좌, 우, 위, 아래) 로 탐색을 진행합니다. 이때 주의해야할것은 1이 하나가 아니라 여러개가 있을 수 있기 때문에 탐색의 횟수를 하나의 값으로 설정하는것이 아니라, 큐에 넣는 값으로 둬야 동시에 1인 위치에서 4방향 탐색을 진행하더라도 방문체크를 해주기 때문에 끝나는 순간에 정답을 도출할 수 있다고 생각했습니다. 또 맵에서 -1인 지점은 갈수 없는 곳입니다. 따라서 이 부분도 역시 방문체크를 했습니다. (탐색에서는 진행될 수 없으므로)
> - [가장먼노드](./algorithm/BFS/가장먼노드/가장먼노드.java) | 동작원리, 노드 1번에서 가장 먼 노드의 거리를 찾는 문제이다. BFS를 통해 문제를 해결할 수 있다. 
> - [숨바꼭질5](./algorithm/BFS/숨바꼭질5/숨바꼭질5_2.java) | 수진이와 동생이 갈 수 있는 거리는 [0, 500000] 이기 때문에 완전탐색 시 주어진 시간안에 탐색을 수행할 수 없습니다. 짝수와 홀수로 나누어서 수진이의 거리를 모두 찾아 수행시간을 기록해 둡니다. 그리고 수진이가 동생을 추격하도록 코드를 구성합니다.





##### DFS

> - [소문난칠공주](./algorithm/DFS/b1941_소문난칠공주/b1941_소문난칠공주.java) | DFS 접근으로 해결 할 수 있다.
> - [에너지 모으기](./algorithm/DFS/에너지모으기/에너지모으기.java) | 배열의 크기를 어떻게 둘까 고민을 많이했는데 -1 씩 감소하여 배열의 크기가 2일때까지 확인해서 해결할 수 있었다.
> - [테트로미노](./algorithm/DFS/테트로미노/_2번.java) | 철 한자 9 모양의 예외처리만 제외하면 DFS로 문제를 해결 할 수 있습니다. 
> - [게리맨더링](./algorithm/DFS/게리맨더링/게리맨더링.java) | 선거구를 나누고 연결되어있는지 확인(DFS), 이후 지역마다 정해진 값을 이용해서 최솟값을 구하는 문제
> - [팀나누기](./algorithm/DFS/팀나누기/팀나누기.java) | 간단한 팀나누기 문제
> - [암호만들기](./algorithm/DFS/암호만들기/암호만들기.java) | 조건이 있지만 DFS로 해결할 수 있다.
> - [로또](./algorithm/DFS/로또/로또.java) | DFS
> - [Nqueen](./algorithm/DFS/nQueen/nQueen.java) | 이 문제를 O(N^2) 안에 풀 수 있습니다.
> - [연산자끼워넣기2](./algorithm/DFS/연산자끼워넣기2/BOJ_14888_연산자끼워넣기_v2.java) | 이 문제는 DFS를 통해 풀 수 있는데요 class를 만들어서 풀어야 했습니다.
> - [스도쿠](./algorithm/DFS/스도쿠/BOJ_2580_스도쿠.java)  | 원래는 스도쿠 문제가 백트래킹으로 해결될 수 없지만, 백트래킹으로 문제를 해결할 수 있는 경우입니다.
> - [빙산](./algorithm/DFS/빙산/BOJ_2573_빙산.java) | while loop 를 돌면서 0이 아닌 수를 발견하면 인접해있는 바다를 카운트하여 어레이리스트에 저장합니다. 그리고 빙하를 깎습니다. 이후 덩어리가 몇개 있는지 체크합니다. 
> - [꽃길](./algorithm/DFS/꽃길/BOJ_14620_꽃길.java) | 입력을 받고 씨앗을 심습니다. 씨앗을 둘 수 있는지 판단하고, 꽃잎을 만개시킵니다. 꽃잎이 만개할 때 맵을 벗어나는지, 다른 꽃잎과 만나는지 확인합니다.
> - [여행경로](./algorithm/DFS/여행경로/프로그래머스_여행경로.java) | DFS로 브루트포스를 수행하고 ArrayList에 저장한 뒤 sort하여 가장 위에 있는 값을 출력하였습니다.
> - [계란으로계란치기](./algorithm/DFS/계란으로계란치기/BOJ_16987_계란으로계란치기.java) | 
> - [N과M(1)](./algorithm/DFS/N과M_1/BOJ_15649_N과M_1.java) | DFS를 이용해서 순열을 구하는 방법으로 문제를 해결할 수 있습니다.




##### Simulation(구현)


> - [뱀](./algorithm/구현/b3190_뱀/backjun_3190_뱀.java) | 시뮬레이션 문제, 조건에 따라 구현해주는것이 중요하다.
> - [2048(easy)](./algorithm/구현/b12100_2048/backjun_2048.java) | 시뮬레이션 이다. 
> - [이진수 연산](./algorithm/구현/b12813_이진수연산/b12813_이진수연산.java) | 이진수 연산을 할 수 있다. 
> - [SWEA_모의SW역량테스트_수영장](./algorithm/구현/SWEA_모의SW역량테스트_수영장/swea_수영장.java) | DFS로 해결할 수 있는 시뮬레이션 문제
> - [SWEA_모의SW역량테스트_요리사](./algorithm/구현/SWEA_모의SW역량테스트_요리사/SWEA_모의SW역량테스트_요리사.java) | 시뮬레이션 문제이다. 
> - [SWEA_모의SW역량테스트_특이한자석](./algorithm/구현/SWEA_모의SW역량테스트_특이한자석.java) | 특이한 자석 문제, 비슷한 문제가 있었던것 같기도 하고
> - [낚시왕](./algorithm/구현/낚시왕/낚시왕.java) | 세월을 낚았다... 방향을 잘 파악해서 풀어야 한다.
> - [셔틀버스](./algorithm/구현/KAKAO_셔틀버스/KAKAO_셔틀버스.java) | 문자열을 이용한 구현 문제
> - [숫자만들기](./algorithm/구현/SWEA_4008_숫자만들기/SWEA_4008_숫자만들기.java) | +, -, *, / number-1 개수에서 최댓값, 최솟값을 갱신합니다. 부호 개수 만큼 돌면서 값을 계산합니다. 백트래킹으로 부호 중 하나를 사용해서 값을 계산하여 계산을 다하고 난후에 사용한 부호를 원상복구 합니다. 
> - [로봇](./algorithm/구현/BOJ_13901_로봇/BOJ_13901_로봇.java) | 모듈러 연산을 통해서 로봇의 흐름을 제어합니다.
> - [Gaaaaaaaaaarden](./algorithm/구현/Gaaaaaaaaaarden/BOJ_Gaaaaaaaaaarden_18809.java) | 모듈러 연산을 통해서 로봇의 흐름을 제어합니다.
> - [원판 돌리기](./algorithm/구현/원판 돌리기/BOJ_17822_원판돌리기.java) | 시뮬레이션 문제
> - [문자열압축](./algorithm/구현/프로그래머스_문자열압축.java) | 문자열 하나, 두개, ... 주어진 문자 길이/2 만큼 잘라서 비교해보면 됩니다.
> - [추석트래픽](./algorithm/구현/KAKAO_추석트래픽/KAKAO_추석트래픽.java) | 문자열을 파싱해서 1초 간격 범위 안에 숫자들을 카운팅하면 됩니다. 
> - [프렌즈4블록](./algorithm/구현/프렌즈4블록/프렌즈4블록.java) | 위에서 아래로 떨어지는 구현을 구현하는것이 가장 큰 중요 포인트 였습니다.
> - [블록이동하기](./algorithm/구현/블록이동하기/블록이동하기.java) | 실제 구현 문제였지만, 시계방향 반시계방향으로 고려해야할 사항이 많았던 문제 였습니다. 
> - [예산](./algorithm/구현/KAKAO_예산/KAKAO_예산.java) | 투포인트 문제인줄 알았지만, 실제 sort해서 앞에서부터 더해서 목표값이 되는 가장 큰 경우를 구하는 문제 였습니다. 
> - [신규아이디](./algorithm/구현/KAKAO_신규아이디/KAKAO_신규아이디.java) | step1~6 까지 있는데, 해당 내용에 맞춰 구현을 해주면 됩니다. 
> - [구슬탈출2](./algorithm/구현/구슬탈출2/구슬탈출2.java) | 방향처리, 예외를 잘 처리해서 구현하면 됩니다. 
> - [2048(EASY)](./algorithm/구현/2048(EASY)/2048_EASY.java) | 방향처리, 예외를 잘 처리해서 구현하면 됩니다. 
> - [경사로](./algorithm/구현/경사로/BOJ_14890_경사로.java) | 브루트포스로 문제에 제시된 조건에 따라 경사로를 놓을 수 있는지 혹은 없는지 체크하는 문제입니다. 
> - [캐시](./algorithm/구현/경사로/BOJ_14890_경사로.java) | HashMap을 이용해서 구현할 수 있습니다.
> - [카카오프렌즈컬러링북](./algorithm/구현/KAKAO_카카오프렌즈컬러링북/KAKAO_카카오프렌즈컬러링북.java) | DFS+BFS로 섬구하기 문제 유형입니다. 
> - [회전 초밥](./algorithm/구현/BOJ_15961_회전초밥/BOJ_15961_회전초밥.java) | deque를 활용해서 문제를 해결할 수 있습니다. 
> - [피카츄](./algorithm/구현/BOJ_14405_피카츄) | 입력 받은 문자열을 순회하면서 'pi', 'ka', 'chu' 외에 문자가 포함되어 있는지 확인해서 No, Yes를 출력하면 됩니다.  
> - [크레인인형뽑기게임](./algorithm/구현/프로그래머스_크레인인형뽑기게임) | moves에 담긴 값에 따라 board에 선택하여 stack에 담긴 수와 비교하여 정답을 계산할 수 있습니다. 
> - [타켓넘버](./algorithm/구현/타켓넘버/타겟넘버.java) | (+), (-) 부호를 array의 원소안에 적용하여 값을 더해 원하는 target을 만들어 낼 수 있습니다.
> - [막대기](./algorithm/구현/막대기/BOJ_1094_막대기.java) | 64를 기준으로 32, 16, 8, 4, 2, 1로 더 이상 쪼갤 수 없을 때까지 2로 나눈 다음에 X 숫자를 만듭니다. 더한 숫자의 개수가 문제의 정답이 됩니다. 
> - [실패율](./algorithm/구현/KAKAO_실패율/KAKAO_실패율.js) | 프로그래머스 | Javascript | 주어진 stages list 값 맞춰 실패율을 구해서 내림차순 정렬 후 실패율이 갖다면 인덱스로 오름차순 정렬합니다. 
> - [폰켓몬](./algorithm/구현/프로그래머_폰켓몬/폰켓몬.js) | 프로그래머스 | Javascript | 입력으로 주어진 nums에 데이터를 중복으로 체크하지 않고 각각 Unique한 값을 세줍니다. 단, nums.length/2를 넘지 말아야 합니다. 넘을경우, nums.length을 리턴합니다. 



##### Graph
> - [줄세우기](./algorithm/정렬/b2252_줄세우기/b2252_줄세우기.java) | 위상정렬 문제중 가장 좋은 표본이 되는 문제였다.
> - [네트워크연결](./algorithm/그래프/네트워크연결/네트워크연결.java) | 프림을 이용해서 구현할 수 있습니다. 크루스칼 알고리즘을 활용하여 해결하였습니다.
> - [문제집](./algorithm/그래프/문제집/문제집.java) | 문제집
> - [작업](./algorithm/그래프/작업/작업.java) | 작업
> - [특정도시의거리찾기](./algorithm/그래프/프로그래머스_특정거리의도시찾기2) | 그래프의 기본 문제 BFS 알고리즘을 이용하면 쉽게 해결 할 수 있었습니다. 
> - [숨바꼭질4](./algorithm/BFS/숨바꼭질4/BOJ_13913_숨바꼭질4.java) | 단순 BFS문제입니다. 역추적을 어떻게 처리해야할지 고민해야 했었던 문제입니다. 
> - [DFS와BFS](./algorithm/그래프/DFS와BFS.java) | DFS와 BFS의 원론적인 문제
> - [이모티콘](./algorithm/그래프/BOJ_14226_이모티콘.java) | 큐를 이용해서 풀수 있는 문제였습니다.
> - [전화번호목록](./algorithm/그래프/프로그래머스_전화번호목록.java) | 트라이를 활용하여, 문자열 처리를 수행해야 하는 문제였습니다.
> - [전화번호목록-2](./algorithm/그래프/프로그래머스_전화번호목록_2.java) | 정렬 후 이전 문자가 다음 문자에 포함되어있는지 확인해보면 쉽게 해결할 수 있습니다.
> - [도시분할계획](./algorithm/그래프/BOJ_1647_도시분할계획.java) | MST를 구성하여 크루스칼, 프림 알고리즘을 이용해서 해결할 수 있습니다. 
> - [Symmetric Tree](./algorithm/그래프/LeetCOde_SymmetricTree.java) | 재귀함수를 이용해서 root Node를 기준으로 좌우 대칭인지 확인해야 하는 문제였습니다. 
> - [Merge Two Binary Trees](./algorithm/그래프/LeetCode_Merge_Two_Binary_Trees.java) | 왼쪽 트리 기준으로 값이 있으면 오른쪽 트리와 비교해서 값을 더하고 그렇지 않으면 추가해서 Merge (Recursive)



##### Greedy


> - [전구와스위치](./algorithm/그리디알고리즘/b2138_전구와스위치/boj_2138.java) | 그리디하게 풀 수 있다.
> - [잃어버린괄호](./algorithm/그리디알고리즘/잃어버린괄호/잃어버린괄호.java) | 원리만 알면 쉽게 접근할 수 있다.
> - [행렬](./algorithm/그리디알고리즘/행렬/행렬.java)  | N과 M 맵의 크기가 주어졌을 때 map 모두를 바라보게 되면  2^NM 의 시간복잡도가 걸립니다. 따라서 한 지점의 좌표가 다르게 되면 3by3을 뒤짚어서 그리디하게 확인해봅니다.
> - [체육복1](./algorithm/그리디알고리즘/체육복/프로그래머스_체육복_v1.java)  | 빌려주는 인원이 체육복을 잃어버리는 케이스를 우선적으로 제외하고 시작합니다. 그리고 난 후에 잃어버린 사람들의 숫자를 조회하면서 앞 뒤로 체육복을 빌려줄 수 있는지 카운트하고 정답을 출력합니다.
> - [체육복2](./algorithm/그리디알고리즘/체육복/프로그래머스_체육복_v2.java)  | 프로그래머스에 다른 답안으로, 하나의 배열로 관리할 수 있는 방법입니다. 로직은 위와 유사하나 코드가 간결해지고 깔끔합니다.
> - [예산](./algorithm/정렬/SUMMER/WINTER_예산/SUMMER/WINTER_예산.java)  | 단순히 정렬 후 조건에 맞게 구현해주면 됐었습니다.
> - [아우으우아으이야](./algorithm/그리디알고리즘/아우으우아으이야/BOJ_15922_아우으우아으이야.java)  | 라인 스위핑 문제로 소개가 되어있는데, 그리디 기법으로 접근하여 문제를 해결할 수 있습니다.



##### Dynamic


> - [욕심쟁이판다](./algorithm/Dynamic/BOJ_1937_욕심쟁이판다2.java) | DFS문제인데 실제 완전탐색을 수행하면 시간초과가 납니다. 따라서, DP를 활용해 DFS를 써야 합니다. 
> - [목장건설하기](./algorithm/Dynamic/BOJ_14925_목장건설하기.java) | O(n^2) 이긴 하지만 장애물 없는 경우, 왼쪽 위 부터 보니까 3면의 minimum +1 
> - [평범한배낭](./algorithm/Dynamic/BOJ_12865_평범한배낭.java) | dp[i-1][j-weight] + value : 해당 차례의 물건을 담는 경우, dp[i-1][j] : 해당 차례의 물건을 담지 않은 경우를 살펴보면서 가방에 들어갈 수 있는 크기에 따라서 뽑아낼 수 있는 Value의 MAX를 찾아냅니다. 
> - [LCS](./algorithm/Dynamic/BOJ_9251_LCS.java) | 이전 문자열과 같은지 확인해서 같은 경우 DP에 길이를 담습니다. 그렇지 않은 경우 비교 문자열1 과 비교 문자열2의 길이를 비교해서 DP에 저장합니다.
> - [내리막길](./algorithm/Dynamic/BOJ_1520_내리막길.java) | 우리가 흔히 알고있는 DFS 방법으로 문제를 해결 할 수 있지만, 범위가 제 시간안에 해결할 수 없도록 구성되어 있습니다. 따라서, DP와 함께 사용해야 했습니다. 
> - [자두나무](./algorithm/Dynamic/BOJ_2240_자두나무.java) | 현재위치, 다음위치를 top-down 방식으로 코드를 구성해서 memorization을 통해 해결할 수 있습니다.
> - [동전1](./algorithm/Dynamic/BOJ_2293_동전1.java) | dp를 이용해서 해결할 수 있다. 특히, dp[j] = dp[j] + dp[j-arr[i]] 식에서 arr[i] 선택하는지, 선택하지 않는지 결정해서 점화식을 세웁니다. 
> - [서울에서경산까지](./algorithm/Dynamic/BOJ_14863_서울에서경산까지.java) | 2차원 dp를 활용하여 해결할 수 있는 문제입니다. 정의를 어떻게 하는지에 따라 문제 접근 방식이 달라지게 됩니다. 
> - [축구](./algorithm/Dynamic/BOJ_1344_축구.java) | 단순 확률 개념으로 문제를 접근할 수 있으나, Bottom-up 방식/ Top-down으로도 문제를 해결할 수 있습니다.



##### Dijkstra

> - [파티](./algorithm/다익스트라/BOJ_1238_파티.java) | 초기화를 진행하고, M만큼 돌면서 거리 시작점, 끝점, 소요시간을 저장합니다. 목적지 -> 도착지 2번 (한번은 경로만 바꿔서 진행합니다.) 참석하려고 가는 경우(목적지를 제외한 모든 노드가 다익스트라를 사용), 목적지에서 다시 돌아올 경우 다익스트라 알고리즘을 활용 다익스트라 함수를 통해 계산해둔 dist, revdist 배열안에 i번째 학생이 목적지로 갈 때의 시간과 되돌아올 때의 시간을 더하여 최댓값을 갱신합니다. idx에 연결된 노드들을 찾아봅니다. 미리 저장되어있는 다음 위치에서의 도달 시간의 값과 현재 위치의 도달 시간의 값 더하기 다음 노드까지 걸리는데 시간을 더해줍니다. 갱신된 위치와 시간값을 pq에 넣고 다시 연산을 반복수행하게 됩니다.



##### Character 


> - [명령프롬프트](./algorithm/문자열처리/명령프롬프트/명령프롬프트_1032.java) | 단순히 문자열의 위치만 맞으면 된다.
> - [알파벳](./algorithm/문자열처리/알파벳/_4.java) | DFS로 해결할 수 있는 문제였다.
> - [알파벳-ver2](./algorithm/문자열처리/알파벳/_5.java) | 알파벳과 다르게 최적화 시켜서 해결해봤다. 그래봤자 return 여부였지만 ㅠ..
> - [그룹단어체커](./algorithm/문자열처리/그룹단어체커/그룹단어체커.java) | 그룹단어 체커, HahMap을 사용하면 됬었다.




##### Brute Force


> - [치킨배달](./algorithm/브루트포스/b15686_치킨배달/boj_15686_치킨배달.java) | 순열과 조합을 사용한 치킨배달 문제
> - [부등호](./algorithm/브루트포스/부등호/BOJ_2529_부등호_2.java) 부등호 | 완전 탐색 문제
> - [외벽점검](./algorithm/브루트포스/외벽점검/프로그래머스_외벽점검.java) 완전 탐색으로 해결할 수 있습니다. (카카오 기출 문제)
> - [종이조각](./algorithm/브루트포스/종이조각/BOJ_14391_종이조각.java) 맵 전체를 순회하는 Brute Force 를 수행 한뒤, 가로 그리고 세로에 연속된 수를 더해 최댓값을 구하면 해결할 수 있습니다.



##### Hash


> - [나는야포켓몬마스터이다솜](./algorithm/해시/BOJ_1620_나는야포켓몬마스터이다솜.java) | 해시를 이용한 문제
> - [Hash 연습문제](./algorithm/해시/연습문제/hash연습문제.java) | 해시 연습문제 1
> - [오픈채팅방](./algorithm/해시/오픈채팅방/오픈채팅방.java) | 




##### Math


> - [완전제곱수](./algorithm/수학/완전제곱수/완전제곱수.java) | 최대 범위를 확인하고 제곱수를 찾아서 ArrayList에 넣어보자.
> - [수이어쓰기1](./algorithm/수학/수이어쓰기1/_1번.java) | 직접 만들려고하지 말고, 길이를 구해서 더해보자1
> - [A+B - 9](./algorithm/수학/A+B-9/_3번.java) | 굉장히 범위가 커서 BigInteger를 사용해야 했다. 
> - [하노이타워](./algorithm/수학/하노이/하노이.java) | 하노이타워는 n 높이를 만들어 줄때 2의 n승 -1 정도를 돈다. 이 문제에서는 20승 이하까지는 출력하지만, 그 이후 부터는 출력하지 않는다. 오로지 몇번 이동했는지 체크한다. stack을 사용한다. 
> - [영수증](./algorithm/수학/영수증/영수증.java) | 산술 문제
> - [과제안내신분](./algorithm/수학/과제안내신분/과제안내신분.java) | 산술 문제
> - [맞았는데왜틀려](./algorithm/수학/맞았는데왜틀려/맞았는데왜틀려.java) | 산술 문제
> - [직사각형탈출](./algorithm/수학/직사각형에서탈출/직사각형.java) | 가로, 세로 4변 을 다 살펴봐야 한다.
> - [구독자전쟁](./algorithm/수학/구독자전쟁/구독자전쟁.java) | 나도잘 원리를 모르겠음..
> - [평균구하기](./algorithm/수학/평균구하기/프로그래머스_평균구하기.java) | double형으로 평균값을 계산할 수 있습니다.



##### To Point


> - [수들의합2](./algorithm/투포인터/_7번.java) | 투포인터 형식으로 문제를 해결한다.
> - [두용액](./algorithm/투포인터/BOJ_2470_두용액.java) | 정렬한 뒤 투 포인트 알고리즘을 활용하면 해결할 수 있습니다.
> - 



##### Stack & Queue


> - [오큰수](./algorithm/스택/_8.java) | 다음 index와 비교 -> index 1 의 값 1은 현재스 index 0 (=2) 보다 값이 작으므로 안된다. 이런식으로 다음 index 의 값 2, 그 다음 index 의 값 1 해당하지 못하고 7 일때 해당되므로 현재스택 은 비어지고 오큰수를 저장하는 배열에 7이 들어가게 된다. 이런식으로 반복하면 해결할 수 있다. 
> - [Valid_Parentheses](./algorithm/스택/Valid_Parentheses.java) | HashMap, Stack 을 이용해서 구현할 수 있습니다. 
> - [단어뒤집기](./algorithm/스택/BOJ_9093_단어뒤집기.java) | 공백을 기준으로 단어를 뒤집습니다. 스택을 이용해 구현합니다.
> - [괄호](./algorithm/스택/BOJ_9012_괄호.java) | Stack을 이용해서 풀수도 있고, 공통변수를 이용해서 접근하여 문제를 해결할 수 있습니다. 
> - [스택수열](./algorithm/스택/BOJ_1874_스택수열.java) | Stack에 수를 저장합니다. 필요한 수에 따라 (+),(-) 를 Stack에 push, pop 합니다. 입력으로 들어오는 숫자에 모자르면 (+) 합니다. 반면에 숫자가 크면 (-) 합니다. pop 해도 만들 수 없는 수에 대해서는 "NO" 를 출력합니다.
> - [에디터](./algorithm/스택/BOJ_1406_에디터.java) | left, right stack을 커서를 기준으로 만듭니다. L이면 커서를 왼쪽으로 한칸 옮김 = right 스택으로 옮김. D이면 커서를 오른쪽으로 한칸 옮김 = left 스택으로 옮김. B이면 left 스택에 있는 top 값을 삭제 P이면 left 스택에 해당 값을 추가해줍니다.
> - [프린터](./algorithm/스택/프로그래머스_프린터.java) | 큐의 앞에서 부터 숫자를 확인하고 문제에서 요구하는 location과 일치하는 경우 정답을 출력합니다.



##### Union-Find


> - [바이러스](./algorithm/DFS/b2606_바이러스/b2606_바이러스.java) | Union-Find문제
> - [집합의 표현](./algorithm/유니온파인드/b1717_집합의표현/b1717_집합의표현.java) | 유니온 파인드 문제!
> - [친구네트워크](./algorithm/유니온파인드/b4195_친구네트워크/b4195_친구네트워크.java) | =>Disjoint-Set 알고리즘 (서로소 집합) & 상호베타적 집합
> - [PGR섬연결하기](./algorithm/유니온파인드/PGR_섬연결하기/섬연결하기.java) | 프로그래머스에서 Union-Find 문제를 풀었다. 최단비용을 찾을 수 있어야 한다. 
> - [이분그래프](./algorithm/이분그래프/b1707_이분그래프/b1707_이분그래프.java) | 잘모르겠다. 다시풀어보자!!
> - [도시분할계획](./algorithm/유니온파인드/도시분할계획/BOJ_1647_도시분할계획.java) | MST를 이용하는 방법으로, 크루스칼 알고리즘으로 쉽게 해결할 수 있습니다.



##### Deque


> - [Deque](./algorithm/디큐/BOJ_10866_Deque.java) | Deque의 기본적인 특징을 모두 사용해볼 수 있는 문제 입니다.
> - [Deque 연습문제](./algorithm/디큐/연습문제/Deque연습문제.java) | Deque 연습문제 1
> - [풍선터뜨리기](./algorithm/디큐/풍선터뜨리기/BOJ_2346_풍선터뜨리기_2.java) | Deque를 이용해서 양수인 경우 맨 앞에 있는것을 맨 뒤로 이동시키고 반대로 음수인 경우 맨 뒤에 있는것을 맨 앞으로 이동시킵니다.



##### Binary Search


> - [파닭파닭](./algorithm/이분탐색/BOJ_14627_파닭파닭.java) | 파닭의 개수를 기준으로 이분탐색을 통해 해결할 수 있습니다.
> - [기타레슨](./algorithm/이분탐색/BOJ_2343_기타레슨.java) | tape를 기준으로 이분탐색을 통해 문제를 해결할 수 있습니다. 





##### Division and conquest


> - [배열합치기](./algorithm/분할정복/BOJ_11728_배열합치기.java) | 임시배열 값을 생성해서 a,b 배열의 작은값을 차례대로 담습니다.  n,m 범위 안에서 값의 대소비교를 수행합니다. j가 m의 범위를 넘어서면 j는 이미 임시배열안에 다 채워진것이기 때문에 대소비교할 필요없이 i번째 데이터를 c 배열에 추가해줍니다. a[i] 번째 값을 임시배열에 넣는것이므로 a[i]<=b[j] 만족시켜야 합니다. 
> - 가장큰증가부분수열 |  i번째 위치의 값을 매번 갱신합니다. j번째 위치의 숫자가 i번째 위치의 숫자보다 작을 경우 LIS 가 해당됩니다. LIS가 해당되면 i번째 위치의 값을 매번 갱신합니다. 매 LIS마다 최댓값을 확인하기 위해 MAX 변수에 값을 저장합니다.



##### Tree


> - [트리순회](./algorithm/트리/BOJ_1991_트리순회.java) | 트리 순위(전위, 중위, 후위)




##### Bipartite graph







##### Sort


> - [k번째수](./정렬/k번째수/프로그래머스_k번째수.java) | 프로그래머스 | 정렬 | 간단한 구현
> - 



##### SQL


> - [보호소에서중성화된동물](./sql/join/보호소에서중성화된동물.sql) | 프로그래머스 | join 문제
> - [sql_example](./sql/join/sql_%_example.sql) | 프로그래머스 | e.g 
> - [오랜기간보호한동물](./sql/join/오랜기간보호한동물.sql) | 프로그래머스 | join 문제
> - [있었는데요없어졌습니다](./sql/join/있었는데요없어졌습니다.sql) | 프로그래머스 | join 문제
> - [없어진기록찾기](./sql/join/없어진기록찾기.sql) | 프로그래머스 | join 문제
> - [이름에el들어가는동물찾기](./sql/string,date/이름에el들어가는동물찾기.sql) | 프로그래머스 | string, date 문제
> - [루시와엘라찾기](./sql/string,date/루시와엘라찾기.sql) | 프로그래머스 | string, date 문제
> - [Revising the Select Query 1](./sql/select/Revising the Select Query 1.sql) | HackerRank | select 문제



##### Implementation


> - [quick-sort](./algorithm/구현/quick-sort.py) | List와 Pivot 을 이용해서 quick-sort 구현하기, in-place로 quick-sort 구현하기




##### 참고


> - [비트마스크](./algorithm/참고/[2019_12_19]비트마스크.md) | 잘쓰면 시간단축에 용이할 수 있을 것 같다.
>
> - [함수형프로그래밍](./algorithm/참고/[2019_12_19]함수형프로그래밍.md) | 리터럴 개념 이 조금 나오는데, 아직 잘모르는 부분 같다.
>
> - [인접리스트 노드로 구현](./algorithm/참고/[2019_12_20]인접리스트노드로구현.md) | 인접리스트를 Node Class를 써서 구현할 수 있다. 
>
>   

##### 실패 혹은 고생해서 푼것들...


> - BOJ_2346_풍선터뜨리기
>
>   

##### 시간 부족해서 못푼 문제...


> - BOJ_2775_부녀회장이될테야
> - BOJ_1874_스택수열 : 메모리초과
> - BOJ_1406_에디터 : 순서 에러
