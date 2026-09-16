package baekjoon.model;

public class BoardNode {
    public int row; // y 좌표
    public int col; // x 좌표

    public BoardNode(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "BoardNode{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}