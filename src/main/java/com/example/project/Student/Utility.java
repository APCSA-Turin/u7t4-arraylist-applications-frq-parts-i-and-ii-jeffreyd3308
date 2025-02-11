package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        for (int i = 0; i < list.size(); i++) { //sort last name
            int smallest = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getLastName().substring(0, 1).compareTo(list.get(smallest).getLastName().substring(0, 1)) < 0) {
                    smallest = j;
                }
            }
            list.add(i, list.remove(smallest));
        }

        for (int i = 0; i < list.size(); i++) { // sort first names
            int duplicates = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getLastName().equals(list.get(i).getLastName())) {
                    duplicates++;
                }
            }
            for (int k = i; k <= i + duplicates; k++) {
                int smallest = k;
                for (int l = k; l <= i + duplicates; l++) {
                    if (list.get(l).getFirstName().substring(0, 1).compareTo(list.get(smallest).getFirstName().substring(0, 1)) < 0) {
                        smallest = l;
                    }
                }
                list.add(k, list.remove(smallest));
            }
        }

        for (int i = 0; i < list.size(); i++) { // sort gpa
            int duplicates = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getFirstName().equals(list.get(i).getFirstName())) {
                    duplicates++;
                }
            }
            for (int k = i; k <= i + duplicates; k++) {
                int largest = k;
                for (int l = k; l <= i + duplicates; l++) {
                    if (list.get(l).getGpa() > list.get(largest).getGpa()) {
                        largest = l;
                    }
                }
                list.add(k, list.remove(largest));
            }
        }

        return list;
    }

}
