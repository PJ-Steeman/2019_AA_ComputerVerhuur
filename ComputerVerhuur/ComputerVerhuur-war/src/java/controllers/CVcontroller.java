/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Computers;
import beans.Users;
import beans.Momenten;
import beans.OpvragenRemote;
import beans.ToevoegenRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
/**
 * @author Jonas Michiels en Pieter-Jan Steeman
 */
public class CVcontroller extends HttpServlet {

    @EJB private OpvragenRemote obean;
    @EJB private ToevoegenRemote tbean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("student");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        //if (request.isUserInRole("student")){
            //request.getSession().setAttribute("student", 1);
            //gotoPage("overzicht.jsp",request,response);
        //}
        }
    }

    private void gotoPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
    }
    
    @Override
    public void init(){
        //List<Object> compLijst = obean.opvragenComp();
        //getServletContext().setAttribute("computers", compLijst);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Logger logger = Logger.getLogger(getClass().getName());
        String submitIn = (String) request.getParameter("submitKnop");
        String[] submitSoort = submitIn.split("-");
        List<Object> compLijst;
        List<Object> resLijst;
        List<Object> momLijst;
        
        String unaam = request.getUserPrincipal().getName();
        
        if (request.isUserInRole("docent")){
                    request.getSession().setAttribute("rol", "docent");
                    request.getSession().setAttribute("richting", obean.opvragenRichting(unaam));
                    request.getSession().setAttribute("naam", unaam);
        }
        if (request.isUserInRole("student")){
                    request.getSession().setAttribute("rol", "student");
                    request.getSession().setAttribute("richting", obean.opvragenRichting(unaam));
                    request.getSession().setAttribute("naam", unaam);
        }
        if (request.isUserInRole("extern")){
                    request.getSession().setAttribute("rol", "extern");
                    request.getSession().setAttribute("naam", unaam);
        }
        //request.getSession().setAttribute("rol", "docent");
        //request.getSession().setAttribute("rol", "student");
        //request.getSession().setAttribute("rol", "extern");
        
        int compSerie;
        int compAank;
        int compHuur;
        
        switch(submitSoort[0]){
            case "Overzicht": 
                String uid = request.getUserPrincipal().getName();
                Users user = (Users) obean.opvragenUser(uid);
                String richtinguser = user.getURichting();
                request.getSession().setAttribute("richting", richtinguser);
                
                compLijst = obean.opvragenComp();
                getServletContext().setAttribute("computers", compLijst);
                
                gotoPage("overzicht.jsp", request, response);
                break;
                
            case "Info":
                int id = Integer.parseInt(submitSoort[1]);
                System.out.println(id);
                Computers comp = (Computers) obean.opvragenCompById(id);
                request.getSession().setAttribute("compinfo", comp);
                request.getSession().setAttribute("compId", id);
                gotoPage("info.jsp", request, response);
                
            case "Nieuwe Computer":
                compSerie = Integer.parseInt(request.getParameter("SerieNr"));
                compAank = Integer.parseInt(request.getParameter("Aankoop"));
                compHuur = Integer.parseInt(request.getParameter("Huur"));
                String richting = (String) request.getSession().getAttribute("richting");
                tbean.toevoegenComp(request.getParameter("Naam"), request.getParameter("Omsch"), request.getParameter("Lokaal"), richting, compSerie, compAank, compHuur);
                
                compLijst = obean.opvragenComp();
                getServletContext().setAttribute("computers", compLijst);
                
                gotoPage("overzicht.jsp", request, response);
                break;
                
            case "Wijzig Computer":
                compSerie = Integer.parseInt(request.getParameter("SerieNr"));
                compAank = Integer.parseInt(request.getParameter("Aankoop"));
                compHuur = Integer.parseInt(request.getParameter("Huur"));
                tbean.wijzigComp((int) request.getSession().getAttribute("compId"), request.getParameter("Naam"), request.getParameter("Omsch"), request.getParameter("Lokaal"), compSerie, compAank, compHuur);
                compLijst = obean.opvragenComp();
                getServletContext().setAttribute("computers", compLijst);
                
                gotoPage("overzicht.jsp", request, response);
                break;
                
            case "Bekijk Momenten":
                momLijst = obean.opvragenMom((int) request.getSession().getAttribute("compId"));
                request.getSession().setAttribute("momLijst", momLijst);
                gotoPage("resOverzicht.jsp", request, response);
                break;
                
            case "Nieuw Moment":
                tbean.toevoegenMoment(request.getParameter("Van"), request.getParameter("Tot"), (int) request.getSession().getAttribute("compId"));
                momLijst = obean.opvragenMom((int) request.getSession().getAttribute("compId"));
                request.getSession().setAttribute("momLijst", momLijst);
                gotoPage("resOverzicht.jsp", request, response);
                break;
                
            case "Bekijk Vrije Momenten":
                momLijst = obean.opvragenVrijeMom((int) request.getSession().getAttribute("compId"));
                request.getSession().setAttribute("momLijst", momLijst);
                gotoPage("reserveer.jsp", request, response);
                break;
                
            case "Reserveer":
                String keuzeIn = (String) request.getParameter("keuzeKnop");
                String[] keuze = keuzeIn.split("-");

                tbean.reserveer(0, unaam, Integer.parseInt(keuze[1]));
                gotoPage("overzicht.jsp", request, response);
                break;
                
            case "Vraag prijs":
                String keuzeInp = (String) request.getParameter("keuzeKnop");
                String[] keuzep = keuzeInp.split("-");
                
                request.getSession().setAttribute("moment", Integer.parseInt(keuzep[1]));
                
                int prijs = obean.opvragenPrijs(Integer.parseInt(keuzep[1]));
                request.getSession().setAttribute("prijs", prijs);
                gotoPage("prijs.jsp", request, response);
                break;
                
            case "Bevestig Reservatie":
                tbean.reserveer(1, unaam, (int) request.getSession().getAttribute("moment"));
                gotoPage("overzicht.jsp", request, response);
                break;
                
            case "Annuleer":
                gotoPage("overzicht.jsp", request, response);
                break;
                
            case "Afmelden":
                request.getSession().invalidate();
                gotoPage("login.jsp", request, response);
                break;
                
            case "Opnieuw Aanmelden":
                request.getSession().invalidate();
                gotoPage("login.jsp", request, response);
                break;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
