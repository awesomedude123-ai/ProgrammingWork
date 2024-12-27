#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
    double num1;
    double num2;
    char op;

    printf("Enter first number: ");
    scanf("%lf",&num1);
    printf("Enter an operator: ");
    scanf(" %c",&op);
    printf("Enter second number: ");
    scanf("%lf",&num2);

    if(op=='+'){
        printf("Answer: %f",num1+num2);
    }else if(op=='-'){
        printf("Answer: %f",num1-num2);
    }else if(op=='*'){
        printf("Answer: %f",num1*num2);
    }else if(op=='/'){
        printf("Answer: %f",num1/num2);
    }else{
        printf("Error: Invalid operator. Use +, -, *, or /");
    }

    return 0;
}