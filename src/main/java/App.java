import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    static private ArrayList<Tasca> listatascas=new ArrayList<Tasca>();
    public static void main(String[] args) {
        HashMap<String,ArrayList<Tasca>> tascas = new HashMap<String, ArrayList<Tasca>>();

        tascas.put("tascas", listatascas);

        get("/tascas", (req, res) -> new ModelAndView(tascas,"index.mustache"), new MustacheTemplateEngine());

        post("/tascas", (req, res) ->{
            String[] tareascompletadas = req.queryParamsValues("anteriores");
            for (Tasca tasca: listatascas ){
                tasca.setMarcado(false);
            }
            if(tareascompletadas !=null){
                for(int i = 0; i<tareascompletadas.length;i++) {
                    for (Tasca tasca : listatascas) {
                        if (tasca.getTarea().equals(tareascompletadas[i])) {
                            tasca.setMarcado(true);
                        }
                    }
                }
            }
            String nuevaTasca = req.queryParams("tasca");
            if(!nuevaTasca.equals("")){
                listatascas.add(new Tasca(req.queryParams("tasca")));
                tascas.put("tascas",listatascas);
            }
            res.redirect("/tascas");
            return null;
        });
    }
}

