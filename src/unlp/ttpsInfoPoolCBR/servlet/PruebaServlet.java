package unlp.ttpsInfoPoolCBR.servlet;

import unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao;
import unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl;
import unlp.ttpsInfoPoolCBR.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel on 23/11/2014.
 */
@WebServlet(name = "PruebaServlet",
    urlPatterns={"/PruebaServlet"})
public class PruebaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        IUsuarioDao usuarioDao = new UsuarioDaoJPAImpl();
        List<Usuario> usuarioList=new ArrayList<Usuario>();
        try{
            usuarioList = usuarioDao.listar();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        for (Usuario user : usuarioList) {
            out.print(user.getEmail());
        }
        out.close();
    }
}
