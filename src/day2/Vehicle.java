package day2;

public class Vehicle {
    private int horizontalPosition;
    private int verticalPosition;
    private int aim;

    public Vehicle(){
        horizontalPosition = 0;
        verticalPosition = 0;
        aim = 0;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public int getProductCoordinate() {
        return horizontalPosition * verticalPosition;
    }

    public void adjustVertical(int delta){
        aim += delta;
    }

    public void adjustHorizontal(int delta){
        horizontalPosition += delta;
        verticalPosition += aim * delta;
    }
}
