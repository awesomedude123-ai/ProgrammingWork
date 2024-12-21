#include <stdio.h>
#include <stdlib.h>
#include <math.h>

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


    return 0;
}