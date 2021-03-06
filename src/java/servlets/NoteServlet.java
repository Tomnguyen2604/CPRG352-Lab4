/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoteServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Note note = new Note();
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String line = br.readLine();
            List<String> lines = new ArrayList<>();
            
            while(line != null){
                lines.add(line);
                line = br.readLine();
                
            }
            note.setTitle(lines.get(0));
            note.setDescription(lines.get(1));
            request.setAttribute("note", note);
            
        }
        catch(IOException a){
            a.printStackTrace();
        }
        String edit = request.getParameter("edit");
        if(edit == null)
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("titleInput");
        String description = request.getParameter("descriptionInput");
        Note note = new Note(title, description);
        note.setTitle(title);
        note.setDescription(description);
        request.setAttribute("note", note);
        
        try{
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
            pw.println(title);
            pw.println(description);
            
            pw.close();
        }
        catch(IOException a){
            a.printStackTrace();
        }
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
    

}
