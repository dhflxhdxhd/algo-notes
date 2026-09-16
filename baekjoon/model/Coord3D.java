package baekjoon.model;

public class Coord3D {
    public int z; // 높이
    public int y; // 세로 latitude / row
    public int x; // 가로 longitudes / col
    public int days; // 일수

    public Coord3D(int z, int y, int x, int days) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.days = days;
    }
}
