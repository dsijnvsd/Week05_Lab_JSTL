/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author awarsyle
 */
public class ShoppingListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String action = (String)request.getParameter("action");
            String username = (String)request.getParameter("username");
          
            if(action != null){
                    session.invalidate();
                    session = request.getSession();
                    request.setAttribute("logoutMessage", "You have successfully logged out");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);  
            }
            else{
                if(username == null){
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);               
                }
                else{
                        getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);               
                }
            }
//                getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);  
//                
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();  
          String action = (String)request.getParameter("action");
           ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");
          

         switch (action){
             case "register":
                 String username = request.getParameter("username");
                 if(username != null && !username.equals("")){
                 request.setAttribute("invalid", false); 
                 session.setAttribute("username", username);
                 getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);}
                  else{
                 request.setAttribute("invalid", true); 
                 getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        }
                 break;
             case "add":
                 String item = (String)request.getParameter("item");
                 if(item != null && item != ""){
                      request.setAttribute("isAddEmpty", false);
                     if(itemList != null ){
                         itemList = new ArrayList();     
                     }
                    itemList.add(item);
                    session.setAttribute("itemList", itemList);
                    getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);
                 }
                 else{
                     request.setAttribute("isAddEmpty", true);
                      session.setAttribute("itemList", itemList);
                     getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);
                 }
                 break;
             case "delete":
                 String delete = request.getParameter("delete");
                 
                 if(delete != null && delete != ("")){
                 request.setAttribute("isDeleteEmpty", false);
                 itemList.remove(delete);
                 session.setAttribute("itemList", itemList);
                       getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);
                 }
                 else{  
                     request.setAttribute("isDeleteEmpty", true);
                     getServletContext().getRequestDispatcher("/WEB-INF/Shoppinglist.jsp").forward(request, response);
               
                 }
//                 
         }
        }
       
             } 
        
    

