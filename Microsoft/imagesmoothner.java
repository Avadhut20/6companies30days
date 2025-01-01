public class imagesmoothner {
    public int[][] imageSmoother(int[][] img) {
        int rows=img.length;
        int cols= img[0].length;
        int result[][]=new int[rows][cols]; 
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[i][j]=calcavg(img,i,j,rows,cols);
            }
        }
        return result;
    }
    public int calcavg(int img[][],int r,int c, int rows,int cols){
        int top= Math.max(0,r-1);
        int bottom=Math.min(rows,r+2);
        int left=Math.max(0,c-1);
        int right=Math.min(cols,c+2);
        int count=0;
        int total=0;
        for(int row=top;row<bottom;row++){
            for(int col=left;col<right;col++){
                total+=img[row][col];
                count++;
            }
        }
        return total/count;
    }
}
