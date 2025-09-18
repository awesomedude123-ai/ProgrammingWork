# include <stdio.h>
# include <stdlib.h>
# include <stdbool.h>
# include "Functions.h"


int add(int x, int y){
    return x+y;
}

int multiply(int x, int y){
    return x * y;
}

int noParams(){
    return 10;
}

int main(){

    char *name = "Sri";
    int age = 18;
    const float gpa = 4.0;
    char lastInital = 'M';
    age=add(age,3);
    printf("My name is %s %c. My age is %d and my gpa is %f \n", name,lastInital,age,gpa);
    printf("%d\n", noParams());
    printf("%d\n",cube(2));
    int newAge = age++;
    
    printf("PostFix %d %d", newAge, age);

    int oldAge = ++age;
    printf("PreFix %d %d", oldAge, age);

    printf(oldAge < 15 ? "Cool" : "Not Cool");

    if(oldAge<15){
        printf("Cool");
    }else{
        printf("Not Cool\n");
    }

    printf("SizeOf(Char) = %zu\n", sizeof(char));
    printf("SizeOf(Char *) = %zu\n", sizeof(char*));
    printf("SizeOf(Int) = %zu\n", sizeof(int));
    printf("SizeOf(bool) = %zu\n", sizeof(bool));
    printf("SizeOf(Float) = %zu\n", sizeof(float));
    printf("SizeOf(Double) = %zu\n", sizeof(double));

    return 0;
}
