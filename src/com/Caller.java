package com;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Caller {
    public static void main(String[] args) {
        Caller caller = new Caller();
        /* Dummy data to be driven from a CSV file */
        ArrayList<Presenter> presenters = new ArrayList<Presenter>();
        presenters.add(new Presenter("P1", 2, 100));
        presenters.add(new Presenter("P2", 13, 10));
        presenters.add(new Presenter("P3", 4, 900));
        presenters.add(new Presenter("P4", 6, 100));
        presenters.add(new Presenter("P5", 9, 6));
        caller.calculateOptimizedResult(20, presenters);
    }

    void calculateOptimizedResult(int TotalHours, ArrayList<Presenter> presenters) {
        presenters.sort(new Presenter.compareByHoursNeeded());


        ArrayList[] finalSectionalArray = new ArrayList[3];
        finalSectionalArray[0] = new ArrayList<Presenter>();
        finalSectionalArray[1] = new ArrayList<Presenter>();
        finalSectionalArray[2] = new ArrayList<Presenter>();
        int sum = 0;
        int index = 0;
        int sectionalsumTotal = TotalHours / 2;
        int sectionalsum = 0;
        for (Presenter presenter : presenters) {
            if (sum + presenter.hoursNeeded > TotalHours) {
                break;
            } else {
                if (sectionalsum + presenter.hoursNeeded > sectionalsumTotal) {
                    sectionalsum = 0;
                    index++;
                }
                sum += presenter.hoursNeeded;
                sectionalsum += presenter.hoursNeeded;
                finalSectionalArray[index].add(presenter);
            }
        }
        index = 0;
        for (ArrayList<Presenter> parentResult : finalSectionalArray) {
            System.out.println("Section :" + index);
            for (Presenter presenter : parentResult) {
                System.out.println(presenter.name);
            }
            index++;
        }
    }
}
