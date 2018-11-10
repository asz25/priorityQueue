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
public class Patient {
    
    private String name,birth,condition;
    private int arr_t,att_t,urgency;

    //Constructor
    public Patient(String name, String birth, String condition, int arr_t, int att_t, int urgency) {
        this.name = name;
        this.birth = birth;
        this.condition = condition;
        this.arr_t = arr_t;
        this.att_t = att_t;
        this.urgency = urgency;
    }
    
    //Constructor for when attended time is not specified
    public Patient(String name, String birth, String condition, int arr_t, int urgency) {
        this.name = name;
        this.birth = birth;
        this.condition = condition;
        this.arr_t = arr_t;
        att_t = 999;
        this.urgency = urgency;
    }

    //Getter methods
    public int getArr() {
        return arr_t;
    }
    
    public String getName()
    {
        return name;
    }

    public int getAtt() {
        return att_t;
    }

    public int getUrg() {
        return urgency;
    }
    
    //Set method for arrival time
    public void setAtt(int time){
        att_t =time;
    }
    
    public String toString()
    {
        String message="";
        message+="Name:" +name+"\nBirth Date: "+birth+"\nCondition: "+condition;
        //999 is a specified value for when the patient has not been attended yet, it modifies the String accordingly
        if(att_t==999)
        {
            message+= "\nAttended: None\nUrgency: "+urgency+"\n";
        }
        
        //If statements format the times so that an extra zero is added to the string when its below 10
        if(arr_t<10)
        {
            message+= "\nArrival: 6:0"+arr_t+"PM";
        }
        
        else
            message+="\nArrival: 6:"+arr_t+"PM";
        
        if(att_t<10)
        {
            message+= "\nAttended: 6:0"+att_t+"PM\nUrgency: "+urgency+"\n";
        }
        
        else
        {
            message+= "\nAttended: 6:"+att_t+"PM\nUrgency: "+urgency+"\n";
        }
        return message;
    }
    
    
}
