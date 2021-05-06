function solution(N, stages) {
    var answer = [];
    var arr =[]
    var total = stages.length;
    
    for(let i=1; i<=N; i++){
        let count = stages.filter(element => i===element).length;
        arr.push({number : i, failRate : (count/total)*100});
        //key -> number, failRate
        total-=count;
    }
    
    arr.sort(function(a,b){
        if(a.failRate!=b.failRate)
            return b.failRate-a.failRate
        else{
            return a.number-b.number
        }
    })

    console.log(arr)
    return arr.map(element=>element.number);
}