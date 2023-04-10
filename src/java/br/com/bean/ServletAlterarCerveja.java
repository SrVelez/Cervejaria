/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.controle.Cerveja;
import br.com.modelo.ManterCerveja;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arTTh
 */
public class ServletAlterarCerveja extends HttpServlet {

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
            Cerveja ce = new Cerveja();
                 ManterCerveja mc = new ManterCerveja();
                 
            int codigo = Integer.parseInt(request.getParameter("codigo"));
                String a_nome=request.getParameter("nome");
                String a_tipo=request.getParameter("tipo"); 
                int a_teor= Integer.parseInt(request.getParameter("teor"));
                int a_ano= Integer.parseInt(request.getParameter("ano")); 
                String a_marca=request.getParameter("marca");
                
                
                 
                 
                   try {
                   ce.setCodigo(codigo);
                   ce.setNome(a_nome);
                   ce.setTipo(a_tipo);
                   ce.setTeor(a_teor);
                   ce.setAno(a_ano);
                   ce.setMarca(a_marca);
                  
                   mc.editarCerveja(ce);
                   RequestDispatcher rd = 
                    request.getRequestDispatcher("listar.jsp");
                    rd.forward(request, response);}
               catch(Exception e){
                   out.println("erro");
        }
                
        }
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
        processRequest(request, response);
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
