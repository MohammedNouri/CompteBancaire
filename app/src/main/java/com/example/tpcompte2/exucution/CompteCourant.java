package com.example.tpcompte2.exucution;

import com.example.tpcompte2.execption.MotantNegativeException;
import com.example.tpcompte2.execption.SoldeInsuffisantException;

public class CompteCourant extends Compte {
    private double decouvert;
    public CompteCourant(double decouvert,int c,double solde, StatutDeCompte st){
        super(c,solde,st);
        this.decouvert=decouvert;
    }

    public void retirer(double mt) throws Exception{
        if (mt>(getSolde()+this.decouvert)) throw new SoldeInsuffisantException("Solde de compte est insuffisant");
        if (mt<=0) throw  new MotantNegativeException("Motant est negative");
        if (mt<100 || mt%10!=0)throw new SoldeInsuffisantException("Impossible de exucuter cette operation");
        Solde-=mt;
        if(getSolde()>0){
            this.decouvert=this.decouvert;
        }else {
            this.decouvert+=getSolde();
        }
    }

    @Override
    public void UpdateSolde() {
        System.out.println("Solde :" +Solde);
    }

    public String toString()
    {
        return (super.toString()+" le decouvret :"+this.decouvert);
    }
}
