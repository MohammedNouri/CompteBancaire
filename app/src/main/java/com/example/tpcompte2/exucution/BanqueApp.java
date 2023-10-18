package com.example.tpcompte2.exucution;

import com.example.tpcompte2.execption.CompteExiste;

public class BanqueApp {
    public static void main(String[] args) throws Exception {
        Compte c1 = new CompteCourant(15,14,5000,StatutDeCompte.CREATED);
        Compte c2 =new CompteCourant(16,15,4000,StatutDeCompte.SUSPUNDED);
        Compte c3 =new CompteCourant(17,18,48888,StatutDeCompte.BLOCKED);
        Compte c4 =new CompteCourant(18,20,48888,StatutDeCompte.BLOCKED);
        Banque b1 = new Banque("BMCE");
        b1.Ajouter(c1);
        b1.Ajouter(c2);
        b1.Ajouter(c3);
        try{
            b1.supprimer(c4);
        }catch (CompteExiste e){
            System.out.println(e.getMessage());
        }
        b1.afficer();
        System.out.println(c1.getCode());
        System.out.println(b1.IndiceCompte(15));
        b1.supprimer(c4);


        System.out.println("Le nombre est :"+b1.nombreDesComptesCourant());
        System.out.println("Les comptes crée sur BMCE sont :");
        b1.afficer();


    }
}
