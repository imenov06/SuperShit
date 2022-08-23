package Table;


import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Table {
    public char[][] table;
    final char SIGN_EMPTY = '.';
    final char SIGN_BOARD = '#';
    final char SIGN_SNAKE = '*';
    final char SIGN_FOOD = '+';
    static int counter = 0;


    public int[] POSITION = new int[2];
    public static Scanner scan = new Scanner(System.in);

    public Table() {
        this.table = new char[12][12];
    }

    public int getX(int[] arr) {
        return arr[1];
    }

    public int getY(int[] arr) {
        return arr[0];
    }

    public void initTable() {
        // заполняем массив пустыми клетками и задаем границы
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < (table.length); j++) {
                table[i][j] = SIGN_EMPTY;
                table[0][j] = SIGN_BOARD;
                table[j][0] = SIGN_BOARD;
                table[(table.length - 1)][j] = SIGN_BOARD;
                table[j][(table.length - 1)] = SIGN_BOARD;
            }
        }
    }


    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    public void startPos() {
        Random rand = new Random();
        int x = rand.nextInt(1, 12);
        int y = rand.nextInt(1, 12);
        POSITION[0] = y;
        POSITION[1] = x;
        table[y][x] = SIGN_SNAKE;

    }
    public void setFood(){
        Random rand = new Random();
        int x = rand.nextInt(1, 12);
        int y = rand.nextInt(1, 12);
        table[y][x]= SIGN_FOOD;
    }

    public void moveDown() {
        if (table[POSITION[0] + 1][POSITION[1]] == '+') {
            counter += 1;
        }
        if (table[POSITION[0] + 1][POSITION[1]] != '#') {

            table[POSITION[0]][POSITION[1]] = SIGN_EMPTY;
            POSITION[0] += 1;
            table[POSITION[0]][POSITION[1]] = SIGN_SNAKE;
        }
    }

    public void moveUp() {
        if (table[POSITION[0] - 1][POSITION[1]] == '+') {
            counter += 1;
        }
        {
            if (table[POSITION[0] - 1][POSITION[1]] != '#') {

                table[POSITION[0]][POSITION[1]] = SIGN_EMPTY;
                POSITION[0] -= 1;
                table[POSITION[0]][POSITION[1]] = SIGN_SNAKE;
            }
        }
    }

    public void moveRight() {
        if (table[POSITION[0]][POSITION[1] + 1] == '+') {
            counter += 1;
        }
        if (table[POSITION[0]][POSITION[1] + 1] != '#') {

            table[POSITION[0]][POSITION[1]] = SIGN_EMPTY;
            POSITION[1] += 1;
            table[POSITION[0]][POSITION[1]] = SIGN_SNAKE;
        }
    }

    public void moveLeft() {
        if (table[POSITION[0]][POSITION[1] - 1] == '+') {
            counter += 1;
        }
        if (table[POSITION[0]][POSITION[1] - 1] != '#') {

            table[POSITION[0]][POSITION[1]] = SIGN_EMPTY;
            POSITION[1] -= 1;
            table[POSITION[0]][POSITION[1]] = SIGN_SNAKE;
        } else System.out.println("Нельзя выйти за границу");
    }

    public static void move() {
        String n;
        Table x = new Table();
        x.initTable();
        x.startPos();

        System.out.println("Введите комманду (u,d,l,r,close)");
        while (true) {
            System.out.println("Counter " + counter);
            x.setFood();
            System.out.println();
            x.printTable();

            n = scan.next();

            if (Objects.equals(n, "u")) {
                x.moveUp();
            }
            if (Objects.equals(n, "r")) {
                x.moveRight();
            }
            if (Objects.equals(n, "l")) {
                x.moveLeft();
            }
            if (Objects.equals(n, "d")) {
                x.moveDown();
            }
            if (Objects.equals(n, "close")) {
                break;
            }

        }
    }


    public static void main(String[] args) {
        move();
    }
}

