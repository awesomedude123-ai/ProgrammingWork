#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>


void greet(char name[],int age){
    printf("Hi %s. You are %d\n",name,age);
}

int cube(int num){
    return num*num*num;
}

int max(int num1, int num2, int num3){
    //&& and -- || or -- == equals to -- != not equals to
    if(num1>num2){
        if(num1>num3){
            return num1;
        }else{
            return num3;
        }
    }else if(num2>num3){
        return num2;
    }else{
        return num3;
    }
}

struct Student{
    char name[50];
    char major[50];
    int age;
    double gpa;
};

int main(){


    //Example
    char characterName[] = "Tom"; 
    int characterAge = 65;
    char *character = "JOHN"; //acts as a pointer so we can change the whole value

    printf("THis is the main method\n");
    printf("There was once a man named %s\n",characterName);
    printf("he was %d years old.\n",characterAge);
    printf("%s\n",character);
    characterAge = 30;
    characterName[0] = 'J'; //Acts like a character array so need to change individuals indices
    character = "TOM"; 
    printf("He really liked the name %s\n",characterName);
    printf("But he did not like the age %d. \n",characterAge);
    printf("%s\n",character);


    //data types
    /*
    int age = 40;
    double gpa = 3.5;
    char grade = 'A';
    char phrase[] = "My name is Cool";
    char *p = "Hello";
    float f = 0.8f;
    */

    //printf
    printf("Hello World \" cool\nhere" );
    printf("My favorite %s is %d\n","number", 500);
    printf("My favorite %s is %f\n","number",500.5067);
    printf("%f\n",9.0+4.0);
    printf("%f\n",9.0-4.0); 
    printf("%f\n",9.0*4.0);
    printf("%f\n",9.0/4.0);
    printf("%d\n",5/4);//integer division
    printf("%d\n",6%4);
    printf("%f\n",5.0/4);//Does normal division

    //NEED TO INCLUDE THE MATH.H PART IN THE INCLUDE STATEMENT
    /**
     * This is blocked comments
     */
    printf("%f\n",pow(2,3));//2^3 needs to be a float
    printf("%f\n",sqrt(4));
    printf("%f\n",ceil(36.356));
    printf("%f\n",floor(36.6));

    //Constants
    const int NUM = 5;//Normaly all capital
    printf("%d\n",NUM);
    //num = 8; Does not work
    printf("%d\n",NUM);

    //Getting User Input
    
    int age;
    printf("Enter your age: ");
    scanf("%d", &age);//Input is type of data we are inputting and the variable we are inputting in. & is a pointer, points the value to the variable
    printf("\nNumber: %d", age);

    double gpa;
    printf("\nEnter your gpa: ");
    scanf("%lf", &gpa);
    printf("\nGPA: %f", gpa);

    char grade;
    printf("\nEnter your grade: ");
    scanf(" %c", &grade);
    printf("\nGrade: %c", grade);

    char name[20];
    printf("\nEnter your name: ");
    scanf("%s", name); //& not needed for string or array of characters. ONLY grabs characters upto the first space
    printf("\nName: %s", name);
    scanf("%*c"); //Gets rid of the new line character that is given as input
    printf("\nEnter your full Name: ");
    fgets(name,20, stdin);//Gets line of characters and stroes in string var,limit,location of input
    printf("\nName: %s", name);

    //Arrays
    int luckyNumbers[] = {4, 8, 15, 16, 23, 42};
    /** 
    int luckyNumbers[10];
    luckyNumbers[1]=80;
    luckyNumbers[0] --> equals -1 which is default or null value
    printf("%d",luckyNumbers[1]);
    printf("%d", luckyNumbers[1]);
    **/
    luckyNumbers[1]=200;
    printf("\n%d", luckyNumbers[1]);


    //Function
    greet(name,age);
    int cubeResult = cube(5);
    printf("\n%d",cubeResult);


    //IF Statements

    printf("\n%d",max(2,3,4));


    //SWITCH Statements

    switch(grade){
        case 'A':
            printf("\nExcellent Grade");
            break;
        case 'B':
            printf("\nGood Grade");
            break;
        case 'C':
            printf("\nAverage Grade");
            break;
        case 'D':
            printf("\nBelow Average Grade");
            break;
        case 'F':
            printf("\nBad Grade");
            break;
        default:
            printf("\nInvalid Grade");
    }

    //Struct
    struct Student student1;
    student1.age = 22;
    student1.gpa = 3.2;
    strcpy(student1.name, "Jim"); //Since we created an array with size 50, we need to strcpy to insert the name into array form
    strcpy(student1.major,"Business");

    struct Student student2;
    student2.age = 20;
    student2.gpa = 2.5;
    strcpy(student2.name, "Pam"); //Since we created an array with size 50, we need to strcpy to insert the name into array form
    strcpy(student2.major,"Art");

    printf("%f",student1.gpa);
    printf("%s",student2.name);

    //Loops
    int index = 1;
    while(index<=5){
        printf("\n%d", index);
        index++;
    }

    do{
        printf("\n%d",index);
        index++;
    }while(index<=0);

    for(int i = 0; i<=5; i++){
        printf("\n%d",i);
    }

    for(int i=0;i<6;i++){
        printf("\n%d",luckyNumbers[i]);
    }

    

    //2-D Arrays
    int numbers1[3][2] = {
        {1,2},
        {3,4},
        {5,6}
    };

    for(int i=0;i<3; i++){
        for(int j=0;j<2;j++){
            printf("\n%d",numbers1[i][j]);
        }
    }

    //Physcial Memory
    printf("\n%p", &age); //%p is physical memory address or pointer. & gets the pointer or physical memory address
    printf("\n%p", &gpa); 
    printf("\n%p", &grade); 
    int age1 = age;
    printf("\n%p", &age1); //&age1 --> pointer data type
    int * pAge = &age;
    double * pGpa = &gpa; //these are pointer variables. Data type needs to be same as variable we are using in &. 
    char * pGrade = &grade;
    printf("\n%p", pAge); //%p is physical memory address or pointer
    printf("\n%p", pGpa); 
    printf("\n%p", pGrade); 

    printf("\n%d",*pAge);//Dereferencing pointers --> Getting the value or information from memory location using pointer
    printf("\n%f",*pGpa);
    printf("\n%c",*pGrade);

    return 0;
}

//Function
