function solution(jobs) {
    var answer = 0;
    jobs.sort((a,b)=>{
        return a[0]-b[0];
    })
    
    
    let task = []
    let taskIdx = 0;
    let time = 0;
    while(taskIdx<jobs.length || task.length!==0){
        if(taskIdx<jobs.length && time>=jobs[taskIdx][0]){
           task.push(jobs[taskIdx]);
           taskIdx++;
           console.log(task)
           task.sort((a,b)=>{
              return a[1]-b[1];  
           });
           continue;
        }
        
        if(task.length!==0){
            //어떤 값이 있다 
            time += task[0][1];
           
            answer += (time-task[0][0]);
            task.shift();
        }else{
            time = jobs[taskIdx][0];
        }
     }
    //end of for loop
   
    
    
    return parseInt(answer/jobs.length);
}