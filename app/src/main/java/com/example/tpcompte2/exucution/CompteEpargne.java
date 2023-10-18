package com.example.tpcompte2.exucution;

import com.example.tpcompte2.execption.SoldeSuperieur;

public class CompteEpargne  extends Compte{
    private double taux;
    public CompteEpargne(double taux){
        super();
        this.taux = taux;
    }
    public void calculInterets() throws Exception{
        if(Solde<5000) throw new SoldeSuperieur("il faut votre etre superieur de 5000 DH");
        Solde=Solde*(1+this.taux/100);
    }
    public void UpdateSolde() {
        System.out.println("Solde :" +Solde);
    }

    public String toString(){

        return (super.toString());
    }
}