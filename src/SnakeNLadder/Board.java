package SnakeNLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board (int size, int noOfSnakes, int noOfLadders) {
        initializeBoard(size);
        addSnakesAndLadders(noOfSnakes, noOfLadders);
    }
    public void initializeBoard(int size) {
        cells = new Cell[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void addSnakesAndLadders(int noOfSnakes, int noOfLadders) {
        for(int i=0; i<noOfSnakes; i++) {
            int startPosition = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int endPosition = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(startPosition > endPosition) {
                cells[startPosition/cells.length][startPosition%cells.length].setJump(new Jump(startPosition, endPosition));
            }
        }

        for(int i=0; i<noOfLadders; i++) {
            int startPosition = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int endPosition = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(startPosition < endPosition) {
                cells[startPosition/cells.length][startPosition%cells.length].setJump(new Jump(startPosition, endPosition));
            }
        }
    }


}
