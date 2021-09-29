N,M = map(int, input().split())
memory = [0]+list(map(int, input().split()))
cost = [0]+list(map(int, input().split()))
sum = sum(cost)

dp = [0 for _ in range(sum+1)]


for i in range(0, N+1) :
    for j in range(sum, cost[i]-1, -1) : #ERROR
        #print(j)
        dp[j] = max(dp[j], dp[j-cost[i]]+memory[i])


number = 0
for i in range(0, sum+1) :
    if dp[i]<M : #ERROR
        number+=1
print(number)