public class overlappingrectangles {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestx= Math.max(x1,Math.min(xCenter,x2));
        int nearesty= Math.max(y1,Math.min(yCenter,y2));
        return Math.sqrt((nearestx-xCenter)* (nearestx-xCenter)+ (nearesty-yCenter)*(nearesty-yCenter))<=radius ;
        
    }
}
