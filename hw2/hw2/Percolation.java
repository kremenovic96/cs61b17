package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int[][] system;
    int n; // size of system
    WeightedQuickUnionUF sites;
    int TOP,BOTTOM;
    int openSitesNum;
    public Percolation(int N){
        if (N <= 0){
            throw new java.lang.IllegalArgumentException();
        }
        system = new int[N][N];
        n = N;
        sites = new WeightedQuickUnionUF((n*n) + 2);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j ++){
                system[i][j] = 0; // zero means that site is not opened
            }
        }
        TOP = n*n;
        BOTTOM = n*n + 1;
        openSitesNum = 0;
    }
    public void open(int row, int col){
        if ( (n - 1 < row) || (n - 1 < col) || (col< 0) || (row < 0)) {
            throw new IndexOutOfBoundsException();
        }
        if (isOpen(row,col)) return;
        system[row][col] = 1;
        if((row == 0)) {
            sites.union(TOP, rcto1D(row,col));
            if (isOpen(row+1,col)) sites.union(rcto1D(row,col), rcto1D(row+1,col));

        }
        else if (row == n-1){
            sites.union(BOTTOM, rcto1D(row, col));
            if (isOpen(row-1,col)) sites.union(rcto1D(row,col), rcto1D(row-1,col));

        }
        else{
             if (col < n-1){ 
                 if (isOpen(row,col+1)) sites.union(rcto1D(row,col), rcto1D(row,col+1));
                 if (isOpen(row+1,col)) sites.union(rcto1D(row,col), rcto1D(row+1,col));
                 if (isOpen(row-1,col)) sites.union(rcto1D(row,col), rcto1D(row-1,col));
             }
              if(col > 0){
                  if (isOpen(row,col-1)) sites.union(rcto1D(row,col), rcto1D(row,col-1));

              }
        }
        openSitesNum +=1;
    }
    public boolean isOpen(int row, int col){
        if ( (n - 1 < row) || (n - 1 < col) || (col< 0) || (row < 0)) {
            throw new IndexOutOfBoundsException();
        }
        return system[row][col] == 1;
    }
    public boolean isFull(int row, int col){
        if ( (n - 1 < row) || (n - 1 < col) || (col< 0) || (row < 0)) {
            throw new IndexOutOfBoundsException();
        }
        return(sites.connected(TOP, (rcto1D(row,col))));
    }
    public int numberOfOpenSites(){
        return openSitesNum;
    }
    private int rcto1D(int r, int c){
        return c + r * n;
    }
    public boolean percolates(){
        return sites.connected(TOP, BOTTOM);
    }
   // public static void main(String[] args){}

}                       
