package com.pctf.algorithm.skills;

public class Random {
    private static final int A = 48271;
    private static final int M = 2147483647;
    private static final int R = M % A;
    private static final int Q = M / A;

    private int state;

    public Random() {
        this.state = (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    public int randomInt() {
        int tempState = A * (state % Q) - R * (state / Q);
        if (tempState >= 0) {
            this.state = tempState;
        } else {
            this.state = tempState + M;
        }
        return this.state;
    }

    public double randomBetween1() {
        return (double) randomInt() / M;
    }
}
