package com.sri.composition;

//Has a relation. A computer has a mother board,has a case,has a monitor. All are not computers but together make one.

public class Computer {
    private Case theCase;
    private Monitor monitor;
    private MotherBoard motherBoard;

    public Computer(Case theCase, Monitor monitor, MotherBoard motherBoard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherBoard = motherBoard;
    }

    public void powerUp(){
        getTheCase().pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        //Fancy Graphics
        this.monitor.drawPixAt(1200,1500,"Yellow");
    }

    private Case getTheCase() {
        return theCase;
    }

    private Monitor getMonitor() {
        return monitor;
    }

    private MotherBoard getMotherBoard() {
        return motherBoard;
    }
}
