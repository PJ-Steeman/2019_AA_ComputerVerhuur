/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Computers;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CVcontroller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CVcontroller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String submitIn = (String) request.getParameter("submitKnop");
        String[] submitSoort = submitIn.split("-");
        List<Object> compLijst;
        int compSerie;
        int compAank;
        int compHuur;
        switch(submitSoort[0]){
            case "Overzicht": 
                request.getSession().setAttribute("docent", 1);
                request.getSession().setAttribute("richting", "E/ICT");
                
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
                //tbean.toevoegenComp(request.getParameter("Naam"), request.getParameter("Omsch"), request.getParameter("Lokaal"), richting, compSerie, compAank, compHuur);
                
                compLijst = obean.opvragenComp();
                getServletContext().setAttribute("computers", compLijst);
                
                gotoPage("overzicht.jsp", request, response);
                break;
            case "Wijzig Computer":
                compSerie = Integer.parseInt(request.getParameter("SerieNr"));
                compAank = Integer.parseInt(request.getParameter("Aankoop"));
                compHuur = Integer.parseInt(request.getParameter("Huur"));
                //tbean.wijzigComp((int) request.getSession().getAttribute("compId"), request.getParameter("Naam"), request.getParameter("Omsch"), request.getParameter("Lokaal"), compSerie, compAank, compHuur);
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
