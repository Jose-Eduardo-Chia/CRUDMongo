
package conexcionjavamongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Conexion(){
        try{
            Mongo mongo = new Mongo("localhost",27017);
            BaseDatos = mongo.getDB("base_de_datos_602");
            coleccion = BaseDatos.getCollection("Base_de_datos_602");
            System.out.println("Coneccion exitosa");
            }catch(UnknownHostException ex){
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public boolean Insertar(String equipo){
        document.put("equipo",equipo);
        coleccion.insert(document);
        return true;
    }
    
    public void Mostrar(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    public boolean Actualizar(String equipoViejo,String equipoNuevo){
        
        document.put("equipo", equipoViejo);
        BasicDBObject documetNew = new BasicDBObject();
        documetNew.put("equipo", equipoNuevo);
        coleccion.findAndModify(document, documetNew);
        return true;
    }
    
    public boolean Eliminar(String equipo){
        document.put("equipo", equipo);
        coleccion.remove(document);  
        return true;
    }
}
