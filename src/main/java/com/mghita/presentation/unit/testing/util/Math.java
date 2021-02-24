package com.mghita.presentation.unit.testing.util;

public class Math {

    public double sum(double left, double right) {
        return left + right;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
