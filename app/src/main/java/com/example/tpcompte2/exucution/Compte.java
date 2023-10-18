package com.example.tpcompte2.exucution;

import com.example.tpcompte2.execption.MotantNegativeException;
import com.example.tpcompte2.execption.SoldeInsuffisantException;

import java.util.ArrayList;

public class Compte  {
    private int code;
    protected double Solde;
    protected StatutDeCompte status;
    public static int cmpt;
    public ArrayList<Operation> ListOperation = new ArrayList<>();
    public Compte(){
        this.code=++cmpt;
        this.Solde=100;
        this.status=StatutDeCompte.CREATED;
    }
    public Compte(int c,double solde, StatutDeCompte st){
        this.code=c;
        this.Solde=solde;
        this.status=st;
    }
    //getters and Setters
    public double getSolde(){return this.Solde;}
    public void setSolde(double solde){this.Solde=solde;}
    public int getCode(){
        return this.code;
    }
    public  void verser(double mt) throws Exception{
        if (mt<0)throw new MotantNegativeException("Motant negative");
        this.Solde+=mt;}
    public void retirer(double mt) throws Exception{
        if (mt>this.Solde) throw new SoldeInsuffisantException("Solde de compte est insuffisant ");
        if (mt<=0) throw new MotantNegativeException("Motant negative");
        if (mt<100)throw new SoldeInsuffisantException("Impossible de exucuter cette operation");
        this.Solde-=mt;
    }
    public static void verement(double mt,Compte c1,Compte c2) throws Exception {
        c1.retirer(mt);
        c2.verser(mt);
    }
    public double ViewSolde(){
        return this.Solde;
    }
    public  void UpdateSolde(){}

    public ArrayList<Operation> HistoriqueCompte(Operation e){
        ListOperation.add(e);
        return ListOperation;
    }
    public double totalVersement() {
        double totalver=0;
        for (Operation e : ListOperation) {
            if (e instanceof Versement) {
                totalver+=e.getMontant();
                e.verser();
            }
        }
        return totalver;
    }
    public double totalRetrait() {
        double totalret=0;
        for (Operation e : ListOperation) {
            if (e instanceof Retrait) {
                totalret+=e.getMontant();
                e.retirer();
            }
        }
        return totalret;
    }
    public String toString(){
        return ("Code de compte : "+this.code+" , "+"Solde de compte : "+this.Solde+" , "+" Status : "+this.status);
    }

}
