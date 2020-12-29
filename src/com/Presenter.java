package com;

import java.util.Comparator;

public class Presenter {
    public static Object compareByHoursNeeded;
    String name;
    int hoursNeeded;
    int cost;

    public Presenter(String name, int hoursNeeded, int cost) {
        this.name = name;
        this.hoursNeeded = hoursNeeded;
        this.cost = cost;
    }
    static class compareByCost implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Presenter p1 = (Presenter) o1;
            Presenter p2 = (Presenter) o2;
            if (p1.cost == p2.cost) {
                return 0;
            } else if (p1.cost > p2.cost) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    static class compareByHoursNeeded implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Presenter p1 = (Presenter) o1;
            Presenter p2 = (Presenter) o2;
            if (p1.hoursNeeded == p2.hoursNeeded) {
                return 0;
            } else if (p1.hoursNeeded > p2.hoursNeeded) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
