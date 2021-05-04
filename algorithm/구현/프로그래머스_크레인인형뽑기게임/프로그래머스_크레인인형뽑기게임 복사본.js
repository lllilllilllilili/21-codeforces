function solution(board, moves) {
    var answer = 0;
    
    var stack = []
    
    stack.push(1)
    stack.push(2)
    console.log(stack.pop())

    for(let j=0; j<moves.length; j++){
        for(let i=0; i<board.length; i++){
            if(board[i][moves[j]-1]!=0){
                if(stack[stack.length-1]==board[i][moves[j]-1]){
                    stack.pop()
                    answer+=2
                }else
                    stack.push(board[i][moves[j]-1])
                board[i][moves[j]-1]=0
                break;
            }
        }                
    }
    
    return answer;
}