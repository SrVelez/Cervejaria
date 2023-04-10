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
public class ServletEditarCerveja extends HttpServlet {

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
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            Cerveja ce = new Cerveja();
            
             try {
                   ManterCerveja mc = new ManterCerveja();
                   ce = mc.pesquisar(codigo);
                   RequestDispatcher rd = 
                    request.getRequestDispatcher("form_editar.jsp");
                    rd.forward(request, response);}
             
             catch(Exception e){

                       }
             
             
             String msg = "";
                
		if (ce == null) {

			msg = "Não foram encontrados registros.";
			RequestDispatcher enviar = request
					.getRequestDispatcher("listar.jsp");
			enviar.forward(request, response);

		} else {
			request.setAttribute("Acodigo", ce.getCodigo());
                        request.setAttribute("Anome", ce.getNome());
			request.setAttribute("Atipo", ce.getTipo());
                        request.setAttribute("Ateor", ce.getTeor());
                        request.setAttribute("Aano", ce.getAno());
                         request.setAttribute("Amarca", ce.getMarca());
			
                        RequestDispatcher listar = request
					.getRequestDispatcher("form_editar.jsp");
			listar.forward(request, response);
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
