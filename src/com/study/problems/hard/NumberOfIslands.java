package com.study.problems.hard;

class NumberOfIslands {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int islands = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {

                if(grid[r][c] == '1') {
                    islands++;
                    searchAndMark(r, c, grid);
                }

            }
        }

        return islands;
    }

    public static void searchAndMark(int r, int c, char[][] grid) {

        if(grid[r][c] == '1') {
            grid[r][c] = 'x';

            if(r > 0) {
                searchAndMark(r - 1, c, grid);
            }

            if(r < grid.length - 1) {
                searchAndMark(r + 1, c, grid);
            }

            if(c > 0) {
                searchAndMark(r, c - 1, grid);
            }

            if(c < grid[0].length - 1) {
                searchAndMark(r, c + 1, grid);
            }
        }
    }
}
