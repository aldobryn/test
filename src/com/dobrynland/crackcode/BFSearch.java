package com.dobrynland.crackcode;

/**
 * Created by Alexandra on 08.07.2017.
 */
public class BFSearch {

    final int WALL = -1;
    final int BLANK = -2;
    final int START = 0;
    final int PATH = -3;
    int m;
    int n;

    public BFSearch(){
        m = 8;
        n = 8;
    }

    public BFSearch(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public void printArr(int arr[][]){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (arr[i][j]) {
                    case -1:
                        System.out.format("%3c", '#');
                        break;
                    case -2:
                        System.out.format("%3c", '0');
                        break;
                    case -3:
                        System.out.format("%3c", '*');
                        break;
                    case 0:
                        System.out.format("%3c", '-');
                        break;
                    default:
                        System.out.format("%3d", arr[i][j]);
                }
            }
            System.out.println();
        }
    }


    public boolean search(int x1, int y1, int x2, int y2, int searchArray[][]) {
        int proceedArray[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchArray[i][j] == WALL) {
                    proceedArray[i][j] = WALL;
                } else {
                    proceedArray[i][j] = BLANK;
                }
            }
        }

        proceedArray[x1][y1] = START;

        searchArray[x1][y1] = 1;
        proceed(x1, y1, x2, y2, proceedArray);
        searchArray[x2][y2] = 1;
        getPath(x2, y2, searchArray, proceedArray);

        printArr(searchArray);



        return true;
    }

    public void getPath(int currX, int currY, int searchArray[][], int proceedArray[][]) {
        int curr =  proceedArray[currX][currY] - 1;
        if(curr == -1){
            return;
        }
        if(searchArray[currX][currY] != 1){
            searchArray[currX][currY] = PATH;
        }


        //top
        if(currY > 0 && proceedArray[currX][currY-1] != WALL &&  proceedArray[currX][currY-1] == curr ) {
            getPath(currX, currY - 1, searchArray, proceedArray);
        }
        //left
        else if(currX > 0 && proceedArray[currX-1][currY] != WALL && proceedArray[currX-1][currY] == curr){
            getPath(currX-1, currY, searchArray, proceedArray);
        }
        //bottom
        else if(currY < n - 1 && proceedArray[currX][currY+1] != WALL && proceedArray[currX][currY+1] == curr){
            getPath(currX, currY+1, searchArray, proceedArray);
        }
        //right
        else if(currX < m - 1 && proceedArray[currX+1][currY] != WALL && proceedArray[currX+1][currY] == curr){
            getPath(currX+1, currY, searchArray, proceedArray);
        }
    }

    public void proceed(int currX, int currY, int finishX, int finishY, int proceedArray[][]) {
        if(currX == finishX && currY == finishY)
            return;

        int curr = proceedArray[currX][currY];
        curr++;
        //top
        if(currY > 0 && proceedArray[currX][currY-1] != WALL && proceedArray[currX][currY-1] != START){
            if(proceedArray[currX][currY-1] == BLANK || proceedArray[currX][currY-1] > curr) {
                proceedArray[currX][currY - 1] = curr;
                proceed(currX, currY - 1, finishX, finishY, proceedArray);
            }
        }
        //left
        if(currX > 0 && proceedArray[currX-1][currY] != WALL && proceedArray[currX-1][currY] != START){
             if(proceedArray[currX-1][currY] == BLANK || proceedArray[currX-1][currY] > curr) {
                 proceedArray[currX - 1][currY] = curr;
                 proceed(currX - 1, currY, finishX, finishY, proceedArray);
             }

        }
        //bottom
        if(currY < n - 1 && proceedArray[currX][currY+1] != WALL && proceedArray[currX][currY+1] != START){
             if(proceedArray[currX][currY+1] == BLANK || proceedArray[currX][currY+1] > curr){
                 proceedArray[currX][currY+1] = curr;
                 proceed(currX, currY + 1, finishX, finishY, proceedArray);
             }
        }
        //right
        if(currX < m - 1 && proceedArray[currX+1][currY] != WALL && proceedArray[currX+1][currY] != START){
             if(proceedArray[currX+1][currY] == BLANK || proceedArray[currX+1][currY] > curr){
                 proceedArray[currX+1][currY] = curr;
                 proceed(currX+1, currY, finishX, finishY, proceedArray);
             }
        }
    }

    public static void main(String[] args) {
        BFSearch search = new BFSearch(8, 9);
        int searchArray[][] =
                {{0, 0, -1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, -1, -1, -1, -1, -1, 0, 0, -1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        search.search(6, 3, 0, 3, searchArray);


    }
}
