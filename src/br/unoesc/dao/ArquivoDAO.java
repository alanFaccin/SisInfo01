package br.unoesc.dao;

import java.util.List;
import org.json.JSONObject;
import br.unoesc.model.Arquivo;
import br.unoesc.model.GenericObject;


public interface ArquivoDAO {
	
    String insert(Arquivo file);

    String remove(int codigo);

    String update(Arquivo file);

    List<Arquivo> getlinhas();
    
    Arquivo getLinha(int codigo);
    
    JSONObject getJsonObject(Arquivo line);
    
    List<GenericObject> getSalariosEscolaridade();
    
    List<GenericObject> getNfilhosValorGasto();

}
