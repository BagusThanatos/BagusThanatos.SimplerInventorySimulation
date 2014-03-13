/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// this file's for testing purposes only.. Will be deleted when we're sure nothing's mwrong with this simulation >.<
package bagusthanatos.simplerinventorysimulation;

/**
 *
 * @author BagusThanatos
 */
public class Main2 {
    public static void main(String[] ar){
    Simulator s=new Simulator(20,40);
    for (int i=1;i<=50;i++){
                Customer c;
                int mobil= (int)(Math.random()*58);
                c= new Customer(i+"",i,mobil);
                s.addEvent(new Event(c,c.getArrivalTime()));
            }
    Event e= s.getNextEvent();
    while(e!=null){
                    s.setClock(e.getTime());
                    s.inHoldCost(s.hitungHC(s.getStock()));
                    Customer c= e.getCustomer();
                   
                    if (s.getStock()<c.getJumMobil()) {
                        s.inShortCost(s.hitungShortageCost(c.jumMobil-s.getStock()));
                        s.deStock(s.getStock());
                        
                    }
                    else {
                        s.deStock(c.getJumMobil());
                    }
                   System.out.print(c.getJumMobil()+";");
                   s.checkStock();
                   s.reCountCost();
                   e=s.getNextEvent();
                   System.out.print(c.getJumMobil()+";");
                   System.out.print(s.getHC());
                   System.out.print(";");
                   System.out.print(s.getSC());
                   System.out.print(";");
                   System.out.print(s.getTotalCost());
                   System.out.print(";"+s.getStock());
                   System.out.println("");
                }
    
    }
}
