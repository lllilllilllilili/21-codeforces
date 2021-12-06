import string
nums = string.digits + string.ascii_uppercase

def change_num(number, n) : 
    a, b = divmod(number, n) 
    if not a : return nums[b]
    else :
        return change_num(a, n) + nums[b]
def solution(n, t, m, p):
    answer = ''
    length = m*t
    
    num = ''
    number = 0
    while len(num) < length : 
        num += str(change_num(number, n))
        number+=1
    
    print(num)
    for i in range(t) : 
        answer += num[i*m+(p-1)]
    
    return answer