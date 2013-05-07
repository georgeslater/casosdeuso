/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ude.casosdeuso.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ude.casosdeuso.dao.CasoDeUsoDao;
import edu.ude.casosdeuso.model.CasoDeUso;
/**
 *
 * @author George
 */
public class CasoDeUsoController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/ListCasosDeUso.jsp";
    private static String LIST_CASO_DE_USO = "/ListCasosDeUso.jsp";
    private CasoDeUsoDao dao;

    public CasoDeUsoController() {
        super();
        dao = new CasoDeUsoDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int cduId = Integer.parseInt(request.getParameter("ID"));
            dao.deleteUser(cduId);
            forward = LIST_CASO_DE_USO;
            request.setAttribute("casosDeUso", dao.getAllCasosDeUso());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int cduId = Integer.parseInt(request.getParameter("cduId"));
            CasoDeUso cdu = dao.getCasoDeUsoById(cduId);
            request.setAttribute("casoDeUso", cdu);
        } else if (action.equalsIgnoreCase("listCasosDeUso")){
            System.out.println("Hi");
            forward = LIST_CASO_DE_USO;
            request.setAttribute("casosDeUso", dao.getAllCasosDeUso());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        System.out.println(request);
        view.forward(request, response);
        System.out.println("HI 2");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CasoDeUso cdu = new CasoDeUso();
        cdu.setText(request.getParameter("Text"));      
        cdu.setPositionX(Integer.valueOf(request.getParameter("PositionX")));
        cdu.setPositionY(Integer.valueOf(request.getParameter("PositionY")));
        String cduId = request.getParameter("ID");
        if(cduId == null || cduId.isEmpty())
        {
            dao.addCasoDeUso(cdu);
        }
        else
        {
            cdu.setId(Integer.parseInt(cduId));
            dao.updateCasoDeUso(cdu);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CASO_DE_USO);
        request.setAttribute("casosDeUso", dao.getAllCasosDeUso());
        System.out.println(request);
        view.forward(request, response);
    }
}
