/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort1;

import java.util.Comparator;

/**
 *
 * @author bli
 */
public class RemainderComparator implements Comparator<Integer> {

    private int n;
    private int sign;
    
    public RemainderComparator(int n, boolean ascending) {
        this.n = n;
        this.sign = ascending ? 1 : -1;
    }

    @Override
    public int compare(Integer i1, Integer i2) {
        return sign * ((i1 % n) - (i2 % n));
    }

    // @Override
    public int compare_alt(Integer i1, Integer i2) {
        // Calculate the remainders of the two integers when divided by n
        int remainder1 = i1 % n;
        int remainder2 = i2 % n;

        // Compare the remainders
        if (remainder1 < remainder2) {
            return -1 * sign;  // Return -1 for ascending, 1 for descending
        } else if (remainder1 > remainder2) {
            return 1 * sign;   // Return 1 for ascending, -1 for descending
        } else {
            return 0;  // Return 0 if they are equal
        }
    }

}
