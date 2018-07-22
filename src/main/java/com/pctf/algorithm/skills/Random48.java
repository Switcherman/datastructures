package com.pctf.algorithm.skills;

public class Random48 {
    public static final long A = 25_214_903_917L;
    public static final long B = 48;
    public static final long C = 11;
    public static final long M = (1L << B);
    public static final long MASK = M - 1;

    private long state;

    public Random48() {
        this.state = System.nanoTime() & MASK;
    }

    public int randomInt() {
        return next(32);
    }

    public double randomBetween0And1() {
        return ((long) (next(26)) << 27) + next(27) / (double) (1L << 53);
    }

    private int next(int bits) {
        state = (A * state + C) & MASK;
        return (int) (state >>> (B - bits));
    }
}
