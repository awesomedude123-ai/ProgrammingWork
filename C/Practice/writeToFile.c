#include <stdio.h>
#include <stdlib.h>

int main(){

    FILE *fPointer = fopen("employees.txt","r"); //File Mode: R-Read, W-Write, A-Append

    char employee[100];
    //fscanf(fPointer,"%s", employee);
    fgets(employee, 100, fPointer); //Reads line from file
    printf("\nEmployee: %s",employee);

    //fprintf(fPointer,"Jim, Salesman\nPam, Receptionist\nOscar, Accounting"); Writes information to file

    fclose(fPointer);
    return 0;
}