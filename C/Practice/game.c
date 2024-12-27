#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main(){

    int secretNumber = 5;
    int guess;
    int guessCount = 0;
    int guessLimit = 3;
    int outOfGuesses = 0;

    while(guess!=secretNumber && outOfGuesses==0){
        if(guessCount<guessLimit){
            printf("Guess the secret number: ");
            scanf("%d",&guess);
            guessCount++;
        }else{
            outOfGuesses=1;
        }

    }

    if(guess==secretNumber){
        printf("Congratulations, you guessed the secret number!\n");
    }else{
        printf("Sorry, you ran out of guesses. The secret number was %d\n", secretNumber);
    }


    return 0;
}