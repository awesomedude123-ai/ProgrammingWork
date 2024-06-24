let name = "Sri Mukkamala";
let number = 17;

let array = [name, number];
for(let i = 0; i<array.length; i++){
    console.log(array[i]);
}

 console.log(name);
 console.log(number);

 let i = 10;
 console.log("This is the try" + (i+=2));


let obj = {
    cost: 10,
    num: 1,
    name1:"Colin"
};

let obj1 = {
    cost: 15,
    name2: "Sri",
    num2: 19
};//end obj1 object



console.log(obj.name);

function fun(){
    console.log("My name is " + name);
    console.log("My age is " + number);
}

fun();

if(obj.cost==10){
    console.log("This worked");
}else{
    console.log("This did not work");
}//end if/else stateement

switch(number + 10){
    case 10:
        console.log("The correct answer is 10");
        break;
    
    case 15:
        console.log("The correct answer is 15");
        break;
    
    case 20:
        console.log("The correct answer is 20");
        break;

    case 25:
        console.log("The correct answer is 25");
        break;

    case 30:
        console.log("The correct answer is 30");
        break;

    default:
        console.log("This is deafult. The answer is " + (number + 10));
        break;
}//end switch case statement




/**
 * let name = 6;
console.log(name);

let array = [6, "sixer", 9, 0, "like"];

console.log(array);

let obj = {
    cost:6,
    names: 'Cool'
};

function obj1(){
    console.log(obj);
}

obj1();

if(obj.cost==6){
    console.log("This worked");
}else{
    console.log("This did nto work. This is the right cost: " + obj.cost)
}

for(let i=0;i<10;i++){
    console.log(i);
}//end for loop

switch(name + 5){
    case 11:
        console.log("The answer is 11");
        break;
    case 15: 
        console.log("The answer is 15");
        break;
    case 21:
        console.log("The answer is 21");
        break;
    default:
        console.log("The answer may be whatever it wants to be. That will not stop me from being who I was born to be!!");
        break;

}//end swtich case statement

console.log("This all worked very well.");

for(let x = 0; x<=10;x++){
    if(x>5){
        console.log(x);
        console.log("X is greater than 5");
    }else{
        console.log(x);
        console.log("X is less than or equal to 5");
    }

}

while(name<10){
    console.log(name);
    name++;
}

for(let i = 0; i<10; i++){
    switch(i+5){
        case 7:
            console.log("The answer is 7.");
            break;
        case 10:
            console.log("The answer is 10.");
            break;
        case 15:
            console.log("The answer is 15.");
            break;
        default:
            console.log("The answer is 7.");
            break;
    }//end switch case statement
    
    if(i>5){
        console.log("This actually ran with a switch case statements!!");
    }

    print("Hi this is my message");
}//end for loop


 */