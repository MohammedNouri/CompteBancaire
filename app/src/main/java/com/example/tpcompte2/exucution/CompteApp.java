package com.example.tpcompte2.exucution;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CompteApp {
    public static void main(String[] args) throws IOException {
        ArrayList<Compte> comptes = new ArrayList<>();
        Compte c1 = new Compte();
        Compte c2 = new Compte();
        Compte c3 = new Compte();
        Compte c4 = new Compte();
        CompteCourant cm1 = new CompteCourant(150,14,5000,StatutDeCompte.CREATED);
        cm1.setSolde(2000);
        comptes.add(c1);
        comptes.add(c2);
        comptes.add(c3);
        comptes.add(c4);
        Operation op1 = new Retrait(600);
        Operation op2 = new Versement(200);
        Operation op3 = new Retrait(400);
        Operation op4 = new Versement(700);
        c1.HistoriqueCompte(op3);
        c1.HistoriqueCompte(op2);
        c1.HistoriqueCompte(op1);
        c1.HistoriqueCompte(op4);
        c2.HistoriqueCompte(op2);
        c3.HistoriqueCompte(op3);
        c4.HistoriqueCompte(op4);
 /*       for (int i = 0; i < comptes.size(); i++) {
            System.out.println(comptes.get(i).toString());
            System.out.println("Information de votre Compte :");
            System.out.println(comptes.get(i).getCode());
            System.out.println("Totale de versement : " + comptes.get(i).totalVersement() + " DH ");
            System.out.println("Totale de Retairait: " + comptes.get(i).totalRetrait() + " DH  ");
            System.out.println();
        }*/
        PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\hp\\AndroidStudioProjects\\TpCompte2\\app\\src\\main\\java\\com\\example\\tpcompte2\\exucution\\clientBancaire.txt"));
        for (int i = 0; i < comptes.size(); i++) {
            double v = 0;
            double t = 0;
            out.println(comptes.get(i).toString());
            out.println("Information de votre Compte :");
            for (Operation e : comptes.get(i).ListOperation) {
                if (e instanceof Retrait) {
                    out.println(e.retirer());
                } else {
                    out.println(e.verser());
                }
            }
            out.println("Total de versement :" + comptes.get(i).totalVersement() + " DH ");
            out.println("Total de Retairait :" +comptes.get(i).totalRetrait() + " DH  ");
            out.println();

        }
        out.close();


    }
}
