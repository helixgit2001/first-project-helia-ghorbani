package ir.ac.kntu;

import java.util.*;

public class Customer {
    private String name;
    private String nationalCode;
    private ArrayList<Consignment>cart=new ArrayList<Consignment>();

    public Customer() {
    }

    public Customer(String name, String nationalCode) {
        this.name = name;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public ArrayList<Consignment> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Consignment> cart) {
        this.cart = cart;
    }

    public void cart(Consignment consignment){
        cart.add(consignment);
        discount();

    }

    public void discount(){
            if (cart.size()>5){
                for (int i=5;i<cart.size();i++){
                    cart.get(i).setPrice(cart.get(i).getPrice()*0.9);
                }
            }
    }


    @Override
    public String toString() {
        return "Customer:" +"\n" +
                "name= " + name + "\n" +
                "nationalCode= " + nationalCode ;
    }




}
