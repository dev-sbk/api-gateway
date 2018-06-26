package com.epi.pfa.domain;
public enum State {
    RUNNING("RUNNING"),DOWN("DOWN");
    private final String state;
    private State(String state){
        this.state=state;
    }

    public String getState() {
        return state;
    }
}
