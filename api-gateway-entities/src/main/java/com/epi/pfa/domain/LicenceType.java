package com.epi.pfa.domain;
public enum LicenceType {
    TRIAL("TRIAL"),PAYANT("PAYNAT");
    private final String type;
    private LicenceType(String type){
        this.type=type;
    }
    public String getType() {
        return type;
    }
}
