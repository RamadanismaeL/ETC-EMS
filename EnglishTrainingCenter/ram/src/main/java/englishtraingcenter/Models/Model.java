/**
 * @author Ramadan ismaeL
 */

package englishtraingcenter.Models;

import englishtraingcenter.Views.ViewsFactory;

public class Model {
    private static Model modelLogin;
    private final ViewsFactory viewsFactory;
    private final ConexaoDAO connect;

    private Model() {
        this.viewsFactory = new ViewsFactory();
        this.connect = new ConexaoDAO();
    }

    public static synchronized Model getInstance() {
        if(modelLogin == null) {
            modelLogin = new Model();
        }

        return modelLogin;
    }

    public ViewsFactory getViewsFactory() {return this.viewsFactory;}
        public ConexaoDAO getConexaoDAO() {return this.connect;}
}
