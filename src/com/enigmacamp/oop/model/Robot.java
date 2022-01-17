package com.enigmacamp.oop.model;

import java.io.*;

public class Robot {
    final static File file = new File("checkpoint.txt");
    private Direction direction;
    private Position position;

    public Robot() {
    }

    public Robot(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public  void write(String input) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            bw.append(input);
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void read()throws IOException{
        String[] textArr = new String[3];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (true){
                String textFile = br.readLine();
                if(textFile==null) break;
                textArr = textFile.split(" ");
                this.direction = Direction.valueOf(textArr[0]);
                this.position = new Position(Integer.parseInt(textArr[1]),Integer.parseInt(textArr[2]));
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public void moves(String commands) {
        try {
            String[] commandsArr = commands.split("");

            for (String command : commandsArr) {
                move(command);
                write(this.toString());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void move(String commandString) {
        try {
            Command command = Command.valueOf(commandString);

            switch (command) {
                case A:
                    forward();
                    break;
                case R:
                    direction = direction.turnRight();
                    break;
                case L:
                    direction = direction.turnLeft();
                    break;
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void forward() {
        if (this.direction == Direction.EAST) {
            position = position.getRight();
        } else if (this.direction == Direction.NORTH) {
            position = position.getTop();
        } else if (this.direction == Direction.WEST) {
            position = position.getLeft();
        } else if (this.direction == Direction.SOUTH) {
            position = position.getBottom();
        } else {
            System.out.println("Wrong direction!!!");
        }
    }

    @Override
    public String toString() {
        return direction+" "+position;
    }
}
