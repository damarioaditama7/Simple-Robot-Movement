package com.enigmacamp.oop.model;

public class Position {
    private Integer xAxis;
    private Integer yAxis;

    public Position(Integer xAxis, Integer yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Position getRight() {
        return new Position(this.xAxis + 1, this.yAxis);
    }

    public Position getLeft() {
        return new Position(this.xAxis - 1, this.yAxis);
    }

    public Position getTop() {
        return new Position(this.xAxis, this.yAxis + 1);
    }

    public Position getBottom() {
        return new Position(this.xAxis, this.yAxis - 1);
    }

    @Override
    public String toString() {
        return xAxis+" "+yAxis;
    }
}
