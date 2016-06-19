package start;

public class ColorThreshold {
    private float black = 0;
    private float white = 0;

    private float blackWhiteThreshold = 0;
    

    public ColorThreshold() {
    }
    
    public ColorThreshold(float black, float white) {
        this.black = black;
        this.white = white;
        blackWhiteThreshold = (black + white) / 2;
    }
    
    public float getBlack(){
        return black;
    }
    
    public void setBlack(float black){
        this.black = black;
        if(this.black != 0 && this.white != 0){
            blackWhiteThreshold = (black + white) / 2;
        }
    }
    
    public float getWhite() {
        return white;
    }
    
    public void setWhite(float white) {
        this.white = white;
        if(this.black != 0 && this.white != 0){
            blackWhiteThreshold = (black + white) / 2;
        }
    }
    
    public float getBlackWhiteThreshold() {
        return blackWhiteThreshold;
    }
    
    public void setBlackWhiteThreshold(float blackWhiteThreshold) {
        this.blackWhiteThreshold = blackWhiteThreshold;
    }
}
