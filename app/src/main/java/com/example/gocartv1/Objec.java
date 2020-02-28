package com.example.gocartv1;




public class Objec {
   String name;
   String price;
   String p_one,p_two,p_three,r_one,r_two,r_three,t_one,t_two,t_three;

    public Objec(String name, String price, String p_one, String p_two, String p_three, String r_one, String r_two, String r_three, String t_one, String t_two, String t_three) {
        this.name = name;
        this.price = price;
        this.p_one = p_one;
        this.p_two = p_two;
        this.p_three = p_three;
        this.r_one = r_one;
        this.r_two = r_two;
        this.r_three = r_three;
        this.t_one = t_one;
        this.t_two = t_two;
        this.t_three = t_three;
    }


    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getP_one() {
        return p_one;
    }

    public String getP_two() {
        return p_two;
    }

    public String getP_three() {
        return p_three;
    }

    public String getR_one() {
        return r_one;
    }

    public String getR_two() {
        return r_two;
    }

    public String getR_three() {
        return r_three;
    }

    public String getT_one() {
        return t_one;
    }

    public String getT_two() {
        return t_two;
    }

    public String getT_three() {
        return t_three;
    }
}