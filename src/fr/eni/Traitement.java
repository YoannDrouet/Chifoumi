package fr.eni;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(value = "/Traitement")
public class Traitement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Tentative.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Si 0 alors la machine joue pierre
        //Si 1 alors la machine joue papier
        //Si 2 alors la machine joue ciseaux
        int nbAleatoire = new Random().nextInt(3);

        String coupUtilisateur = request.getParameter("jeuUtilisateur");

        switch (nbAleatoire){
            case 0 : request.setAttribute("jeuMachine","Pierre");
                switch (coupUtilisateur){
                    case "Pierre" : request.setAttribute("resultat","Egalité"); break;
                    case "Papier" : request.setAttribute("resultat","Victoire");break;
                    default: request.setAttribute("resultat","Défaite");
                }break;
            case 1 : request.setAttribute("jeuMachine","Papier");
                switch (coupUtilisateur){
                    case "Pierre" : request.setAttribute("resultat","Défaite"); break;
                    case "Papier" : request.setAttribute("resultat","Egalité");break;
                    default: request.setAttribute("resultat","Victoire");
                }break;
            default: request.setAttribute("jeuMachine","Ciseaux");
                switch (coupUtilisateur){
                    case "Pierre" : request.setAttribute("resultat","Victoire"); break;
                    case "Papier" : request.setAttribute("resultat","Défaite");break;
                    default: request.setAttribute("resultat","Egalité");
                }
        }
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Resultat.jsp");
        rd.forward(request,response);
    }
}
