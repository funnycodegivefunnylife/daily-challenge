package leetcode.challenge.leetcode_2127;

import java.util.ArrayList;
import java.util.List;

class Employee {
    int id;
    List<Integer> favorite;
}

class Solution {
    public int maximumInvitations(int[] favorite) {
        int result = 0;

        Employee[] employees = new Employee[favorite.length];

        for (int i = 0; i < favorite.length; i++) {
            Employee employee = new Employee();
            employee.id = i;
            employee.favorite = new ArrayList<>();
            employees[i] = employee;

        }

        for (int i = 0; i < favorite.length; i++) {
            employees[favorite[i]].favorite.add(i);
        }

        return result;
        
    }
}