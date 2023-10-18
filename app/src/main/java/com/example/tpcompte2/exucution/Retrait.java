package com.example.tpcompte2.exucution;

public class Retrait extends Operation{
    double t=0;
    public Retrait(double i){
        super(i);
    }
    public String retirer(){
        return ("Num d'operation :"+getNumero()+" , "+"Le montant retirer :"+montant+" DH "+" , "+"Date d'operation"+dateOperation);
    }
}
