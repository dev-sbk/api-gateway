package com.epi.pfa.domain;
public enum Gender {
     MALE("MALE"),FEMALE("FEMALE");
     private final String gender;
     private Gender(String gender){
         this.gender=gender;
     }

    public String getGender() {
        return gender;
    }
}
