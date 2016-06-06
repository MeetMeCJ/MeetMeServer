/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import hibernate.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    class Informacion {
        public String texto;

        public Informacion() {
        }

        public Informacion(String texto) {
            this.texto = texto;
        }
    }    
    
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
        
        String op = request.getParameter("op");
        String action = request.getParameter("action");
        
        String tlf = request.getParameter("tlf");
        String token = request.getParameter("token");
        String nick = request.getParameter("nick");
        String description = request.getParameter("description");
        String last = request.getParameter("last");
        String see = request.getParameter("see");
        String privacy= request.getParameter("privacy");
        String facebook = request.getParameter("facebook");
        String twitter = request.getParameter("twitter");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String nationality = request.getParameter("nationality");
        
        //String telefono, String nick, String token, String descripcion, String ultimaconexion, String verconexion, String privacidad, String email, String facebook, String twitter, String nacimiento, String nacionalidad
       User user = new User (tlf, nick, token, description, last, see, privacy, email, facebook, twitter, birth, nationality);
        
        Informacion destino=handle(op,action,tlf,token,user);        
        
        try (PrintWriter out = response.getWriter()) {            
            if(destino.texto!=null)
                out.println(destino.texto);
            else
                out.println("error en process request");
        }
    }
    
    public Informacion handle(String op,String accion,String tlf,String token, User user){
        Informacion destino=new Informacion("error1 en handle");        
        switch(op){
            case "consulta":
                destino=handleConsulta(accion,tlf,token);
                break;
            case "alta":
                destino=handleAlta(accion,tlf,token,user);
                break;
            default:
                destino= new Informacion("error en handle");
        }
        return destino;
    }
    
    public Informacion handleConsulta(String accion,String tlf,String token){
        Informacion destino=null;
        JSONObject obj=null;
        switch(accion){
            case "tlf":
                obj=gestor.GestorUser.getUserByTlf(tlf);
                destino=new Informacion(obj.toString());
                break;
            case "token":
                obj=gestor.GestorUser.getUserByToken(token);
                destino=new Informacion(obj.toString());
                break;
            default:
                destino= new Informacion("error en handleconsulta");
        }
        return destino;
    }

     public Informacion handleAlta(String accion,String tlf,String token, User user){
        Informacion destino=null;
        JSONObject obj=null;
        switch(accion){
            case "registrar":                
                User u=new User(tlf, "", token, "I'm using meetme", "", "todos", "amigo","","","","","");
                gestor.GestorUser.registerUser(u);
                break;
            case "actualizar":                
                gestor.GestorUser.updateUser(tlf,user);
                break;
            default:
                destino= new Informacion("error en handlealta");
        }
        return destino;
    }   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
