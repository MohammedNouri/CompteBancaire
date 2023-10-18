package com.example.tpcompte2.exucution;

public class Versement extends Operation{
    public Versement(double i){
        super(i);
    }
    public String verser(){
        return ("Num d'operation :"+getNumero()+" , "+"Le montant verser :"+montant+" DH "+" , "+"Date d'operation"+dateOperation);

    }
}
