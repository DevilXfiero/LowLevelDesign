package SnakeNLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public Game() {
        this.board = new Board(10, 5, 3);
        this.dice = new Dice(1);
        addPlayers();
    }

    public void addPlayers() {
        players = new LinkedList<>();
        players.add(new Player("Player1", 0));
        players.add(new Player("Player2", 0));
    }

    public void startGame() {

        while(winner == null) {
            Player currentPlayer = players.removeFirst();
            players.addLast(currentPlayer);
            int diceValue = dice.roll();

            int newPos = currentPlayer.currentPosition + diceValue;
            newPos = jumpCheck(newPos);
            currentPlayer.currentPosition = newPos;

            System.out.println("Player " + currentPlayer.id + " rolled " + diceValue + " and moved to position " + currentPlayer.currentPosition);

            if(newPos >= board.cells.length*board.cells.length - 1) {
                winner = currentPlayer;
            }

        }
        System.out.println("Player " + winner.id + " wins the game!");
    }

    public int jumpCheck(int position) {

        int len = board.cells.length;

        if(position > len*len - 1) {
            return position;
        }
        Jump jump = board.cells[position/len][position%len].getJump();
        if(jump != null) {
            String jumpBy = jump.startPosition > jump.endPosition ? "Snake" : "Ladder";
            System.out.println("Player " + jumpBy + " from " + jump.startPosition + " to " + jump.endPosition);
            return position + board.cells[position/len][position%len].getJump().endPosition;
        }
        return position;
    }



}
