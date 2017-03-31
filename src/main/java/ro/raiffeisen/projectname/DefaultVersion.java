package ro.raiffeisen.projectname;

import com.google.appengine.api.modules.ModulesService;
import com.google.appengine.api.modules.ModulesServiceFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@UrlPattern("/GetMajorVersion")
public class DefaultVersion extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*this servlet is usefull to be able to automatically increment versions using the plugin*/
        ModulesService modulesService = ModulesServiceFactory.getModulesService();
        String defaultVersion = modulesService.getDefaultVersion(req.getParameter("module"));
        resp.setContentType("text/plain");
        resp.getWriter().print(defaultVersion);
    }
}