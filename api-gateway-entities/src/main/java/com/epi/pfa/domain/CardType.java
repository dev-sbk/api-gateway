package com.epi.pfa.domain;
public enum CardType {
    MASTERCARD("MASTERCARD"),VISA("VISA");
    private final String type;
    private CardType (String type){
        this.type=type;
    }
    public String getType() {
        return type;
    }
}
