function pageCount(n,p){
    let front = 0;
    if(p==1 || p==n){
        return 0;
    }else{
    let back = 0;
    if(n%2==0){
        for(let i =1; i<n;i=i+2){
            back++;
            if(n-i==p || n-i-1==p){
                break;
            }//end if statement
        }//end for loop
    }else{
        for(let i =1;i<n;i=i+2){
            if(n-i==p || n-i-1==p){
                break;
            }//end if statement
            back++;
        }//end for loop
    }//end if else statement

    for(let i=1;i<n;i=i+2){
        front++;
        if(1+i==p || 1+1+i==p){
            break;
        }
    }//end for loop

    if(front>back){
        return back;
    }else{
        return front;
    }
}//end if else statement
}//end pageCount function


pageCount(6,2);
