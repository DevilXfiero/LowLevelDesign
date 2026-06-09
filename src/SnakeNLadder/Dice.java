package SnakeNLadder;

public class Dice {
    int count;

    public Dice(int count) {
        this.count = count;
    }

    public int roll() {
        int total = 0;
        for(int i=0; i<count; i++) {
            total += (int)(Math.random()*6) + 1;
        }
        return total;
    }
}
