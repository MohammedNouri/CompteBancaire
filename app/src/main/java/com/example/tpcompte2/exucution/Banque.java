package com.example.tpcompte2.exucution;

import java.util.ArrayList;
import com.example.tpcompte2.execption.CompteExiste;
public class Banque {
    ArrayList<Compte> Listecompte = new ArrayList<>();
    public String NomBanque;
    public Banque(String b){
        this.NomBanque=b;
    }
    public int IndiceCompte(int code){
        for (int i=0;i<Listecompte.size();i++){
            if (Listecompte.get(i).getCode() == code){
                return i;
            }
        }
        return-1;
    }


    public boolean Ajouter(Compte C) throws Exception{
        int f = IndiceCompte(C.getCode());
        if (f==-1){
            Listecompte.add(C);
            return true;
        }else {
            throw new CompteExiste("Compte est deja existe");
        }
    }
    public  void supprimer(int code) throws Exception  {
        for (int i=0;i<Listecompte.size();i++){
            if (Listecompte.get(i).getCode()==code){
                Listecompte.remove(i);
            }
            throw new CompteExiste("ce compte n'existe pas!!");
        }

    }
    public void supprimer(Compte C) throws Exception{
        int f = IndiceCompte(C.getCode());
        if(f!=-1){
            Listecompte.remove(f);
        }
        else {
            throw new CompteExiste("Ce compte n'existe pas!!");
        }
    }
    public  int nombreDesComptesCourant(){
        int cmpt=0;
        for (int i=0;i<Listecompte.size();i++){
            if(Listecompte.get(i) instanceof CompteCourant){
                cmpt++;
            }
        }
        return cmpt;
    }
    public void afficer(){
        for (int i=0;i<Listecompte.size();i++){
            System.out.println(Listecompte.get(i));
        }
    }


}
