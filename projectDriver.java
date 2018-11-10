/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_csc311;

/**
 *
 * @author awdsa
 */
public class projectDriver {

    //Method that generates an array of Patients for simulation already sorted by their Arrival Time
    public static Patient[] patientGen() {
        Patient[] result = new Patient[15];
        result[0] = new Patient("Patient 1", "1/6/7", "Small cut", 0, 2);
        result[1] = new Patient("Patient 2", "2/9/7", "Small cut", 5, 5);
        result[2] = new Patient("Patient 3", "3/29/7", "Small cut", 6, 1);
        result[3] = new Patient("Patient 4", "6/30/7", "Small cut", 7, 19);
        result[4] = new Patient("Patient 5", "6/2/7", "Small cut", 10, 15);
        result[5] = new Patient("Patient 6", "8/4/7", "Small cut", 11, 11);
        result[6] = new Patient("Patient 7", "8/11/7", "Small cut", 12, 6);
        result[7] = new Patient("Patient 8", "1/6/7", "Small cut", 16, 4);
        result[8] = new Patient("Patient 9", "2/3/7", "Small cut", 20, 8);
        result[9] = new Patient("Patient 10", "2/14/7", "Small cut", 21, 17);
        result[10] = new Patient("Patient 11", "5/30/7", "Small cut", 22, 17);
        result[11] = new Patient("Patient 12", "9/7/7", "Small cut", 26, 9);
        result[12] = new Patient("Patient 13", "11/16/7", "Small cut", 30, 5);
        result[13] = new Patient("Patient 14", "12/22/7", "Small cut", 31, 14);
        result[14] = new Patient("Patient 15", "3/1/7", "Small cut", 32, 20);

        return result;

    }

    public static void main(String args[]) {
        Patient[] patients = patientGen();
        priorityQueue queue = new priorityQueue(15);

        //Current minutes in the hour of simulation and amount of patients attended
        int minutes = 0;
        int served = 0;
        int index = 0;
        int end = 0;
        boolean busy = false;
        //Loop will continue until an hour has elapsed or 15 patients have been served
        while (minutes < 60 && served < 15) {
            //Print statement helps check what iteration the program is in
            //System.out.println("CURRENT TIME IS: "+minutes);

            //This is for adding patients into the queue
            for (; index < 15; index++) {

                Patient curr_pat = patients[index];

                if (curr_pat.getArr() == minutes) {
                    queue.insert(curr_pat);

                    //This print statements help check the queue is being added accordingly
                    //System.out.println("\n"+curr_pat.getName()+" HAS BEEN ADDED TO THE QUEUE");
                    //System.out.println("THERE ARE "+queue.size()+" PATIENT(S) IN THE QUEUE\n");
                }

                if (curr_pat.getArr() > minutes) {
                    break;
                }
            }

            //This is for dealing with patiens who are next in being attended
            if (busy == false && !(queue.isEmpty())) {
                Patient next_pat = queue.remove();
                busy = true;
                end = minutes + 2;
                next_pat.setAtt(minutes);
                System.out.println("We have served " + (served + 1) + " patients today\n" + next_pat);
                served++;
            }

            //After two minutes have elapsed the room is free to be used again
            if (minutes == end) {
                busy = false;
            }
            minutes++;
        }
    }

}
