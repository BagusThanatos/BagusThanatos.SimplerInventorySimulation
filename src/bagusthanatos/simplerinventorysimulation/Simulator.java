/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bagusthanatos.simplerinventorysimulation;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author BagusThanatos
 */
public class Simulator {
    Queue<Event> ListCust = new LinkedList<>();
    private int clock,maxS, minS,stock;
    // di sini shortage cost didefinisikan sebagai pemasukan yang hilang karena tidak bisa melayani pelanggan
    // kami mendefinisikan bahwa jika jumlah pesanan kurang dari stok, maka
    // shortage cost akan bertambah sebanyak (jumlah pesanan - stok)*harga per Item
    private double holdingCost,totalCost,shortageCost,orderingCost;
    private final int perH=7,perI=80,perSetup=10;// merupakan kelipatan 100K, untuk membuat perhitungan lebih simple
    public Simulator(int min, int max){
        this.maxS=max;
        this.minS=min;
    }
    public void init(){
        this.clock=0;
        this.stock=this.maxS;
        this.holdingCost=0.0;
        this.orderingCost=0.0;
        this.shortageCost=0.0;
        this.totalCost=0.0;
        this.ListCust.clear();// just to make sure..
    }
    public int getClock(){
        return this.clock;
    }
    public double getTotalCost(){
        return this.totalCost;
    }
    public void inHoldCost(double i){
        this.holdingCost+=i;
    }
    public void inShortCost(double i){
        this.shortageCost+=i;
    }
    public void inOrderCost(double i){
        this.orderingCost+=i;
    }
    public int hitungHC(int jumMobil){
        return jumMobil*this.perH;
    }
    public int hitungOrderCost(int jumMobil){
        return this.perI*jumMobil+this.perSetup;
    }
    public int hitungShortageCost(int jumMobil){
        return this.perI*jumMobil;
    }
    public void reCountCost(){
        this.totalCost=this.orderingCost+this.holdingCost+this.shortageCost;
    }
    public void setClock(int c){
        this.clock=c;
    }
    public void addEvent(Event e){
        this.ListCust.add(e);
    }
    public void checkStock(){
        if (this.stock<this.minS){
            this.inOrderCost(hitungOrderCost(this.maxS-this.stock));
            this.reCountCost();
            this.stock=this.maxS;
        }
    }
    public void deStock(int jumMobil){
        this.stock-=jumMobil;
    }
    public int getStock(){
        return this.stock;
    }
    public void restock(int a){
        this.stock+=a;
    }
    public Event getNextEvent(){
        Event a=this.ListCust.peek();
        if (a!= null) return this.ListCust.remove();
        else return null;
    }
    // for testing only!!
    public double getHC(){
        return this.holdingCost;
    }
    public double getSC(){
        return this.shortageCost;
    }
}
