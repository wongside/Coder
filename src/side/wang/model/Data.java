/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package side.wang.model;


/**
 *
 * @author Side
 */
public class Data {
    private char symbol;
    Double prob;//概率
    int codeLength;//码长
    String codeword;
    public Data(){
        this.symbol = ' ';
        this.prob = 0.0;
        this.codeLength = 0;
        this.codeword = "";
    }
    public Data(char symbol, double prob){
        this.symbol = symbol;
        this.prob = prob;
        this.codeLength = 0;
        this.codeword = "";
    }

    public Double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public String getCodeword() {
        return codeword;
    }

    public void setCodeword(String codeword) {
        this.codeword = codeword;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Data{" + "symbol=" + symbol + ", prob=" + prob + ", codeLength=" + codeLength + ", codeword=" + codeword + '}';
    }
    
}
