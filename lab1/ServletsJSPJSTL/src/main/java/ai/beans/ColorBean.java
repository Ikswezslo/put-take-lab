package ai.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private boolean borders;

    public boolean isBorders() {
        return borders;
    }

    public void setBorders(boolean borders) {
        this.borders = borders;
    }
    
    public String getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public ColorBean() {
    }
}
