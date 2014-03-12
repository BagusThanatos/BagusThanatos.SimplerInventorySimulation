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
public class Customer {
    String name;
    int arrivalTime;
    int jumMobil;
    

    public Customer(String name,int arrivalTime,int jumMobil){
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.jumMobil=jumMobil;
        
    }

    public void setName(String n){
        this.name = n;
    }

    public void arrive(int tm){
        this.arrivalTime = tm;
        
    }

    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public String getName(){
        return this.name;
    }
    public int getJumMobil(){
        return this.jumMobil;
    }
}
