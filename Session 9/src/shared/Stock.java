package shared;

import com.google.gson.Gson;

import java.io.Serializable;

public class Stock implements Serializable {
    private String symbol;
    private int value;

    public Stock(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
