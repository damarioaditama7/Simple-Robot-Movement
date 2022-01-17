package com.enigmacamp.oop.model;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction turnRight() {
        return Direction.values()[(this.ordinal() + 1) % Direction.values().length];
    }

    public Direction turnLeft() {
        return Direction.values()[(this.ordinal() + 3) % Direction.values().length];
    }
}
