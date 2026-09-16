package baekjoon.model;

public class RouteNode {
    public int row; // y 좌표
    public int col; // x 좌표
    public int count;

    public RouteNode(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}