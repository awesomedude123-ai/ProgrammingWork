function findDigits(n){
    const array = n.split('');
    let count = 0;
    for(let i = 0;i<array.length;i++){
        if(n%array[i]==0){
            count++;
        }//end if statement
    }//for loop
}//end function

console.log(findDigits(111));