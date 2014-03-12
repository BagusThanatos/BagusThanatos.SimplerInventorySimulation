/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bagusthanatos.simplerinventorysimulation;

/**
 *
 * @author BagusThanatos
 */
public class Event implements Comparable{
    private int time;
    Customer c;
    
    public Event(Customer c, int t){
        this.c=c;
        this.time=t;
    }
    public Customer getCustomer(){
        return this.c;
    }
    
    public int getTime(){
        return this.time;
    }
    @Override
    public int compareTo(Object ob){
        Event e = (Event) ob;
        if(this.time < e.getTime()){
            return -1;
        }
        if(this.time > e.getTime()){
            return 1;
        }
        return 0;
    }
}
