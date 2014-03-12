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
public class BagusThanatosSimplerInventorySimulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Simulator[] s=new Simulator[4];
        s[0]=new Simulator(20,40);
        s[1]=new Simulator(30,60);
        s[2]=new Simulator(40,70);
        s[3]= new Simulator(10,50);
        double[] avg = {0.0,0.0,0.0,0.0};
        
        for (int x=1;x<=50;x++){
            System.out.println("Percobaan ke-"+x+":");
            for(int i=0;i<4;i++) {
                s[i].init();
            }
            
            for (int i=1;i<=50;i++){
                Customer c;
                int mobil= (int)(Math.random()*58);
                c= new Customer(i+"",i,mobil);
                for (int j=0;j<4;j++){
                    s[j].addEvent(new Event(c,c.getArrivalTime()));
                }
            }
           
            Event e;
            for (int i=0;i<4;i++){
                e=s[i].getNextEvent();
                while(e!=null){
                    s[i].setClock(e.getTime());
                    s[i].inHoldCost(s[i].hitungHC(s[i].getStock()));
                    Customer c= e.getCustomer();
                   
                    if (s[i].getStock()<c.getJumMobil()) {
                        s[i].inShortCost(s[i].hitungShortageCost(c.jumMobil-s[i].getStock()));
                        s[i].deStock(s[i].getStock());
                        
                    }
                    else {
                        s[i].deStock(c.getJumMobil());
                    }
                    s[i].checkStock();
                    s[i].reCountCost();
                    e=s[i].getNextEvent();
                   System.out.print(c.getJumMobil()+",");
                }
                
                if (i==0) System.out.print("Total cost [20,40]:");
                else if (i==1) System.out.print("Total cost [30,60]:");
                else if (i==2) System.out.print("Total cost [40,70]:");
                else if (i==3) System.out.print("Total cost [10,50]:");
                System.out.println(s[i].getTotalCost());
                
            }
            
            for (int i=0;i<4;i++) avg[i]+=s[i].getTotalCost();
        }
        System.out.println("AVG [20,40]: "+avg[0]/50);
        System.out.println("AVG [30,60]: "+avg[1]/50);
        System.out.println("AVG [40,70]: "+avg[2]/50);
        System.out.println("AVG [10,50]: "+avg[3]/50);
    }
    
}
