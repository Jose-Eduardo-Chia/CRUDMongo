
package conexcionjavamongo;


public class ConexcionJavaMongo {


    public static void main(String[] args) {
        Conexion conec = new Conexion();
       // conec.Insertar("Leon");
        conec.Mostrar();
       // conec.Actualizar("AlfaSoftware", "Chivas");
       // conec.Mostrar();
       conec.Eliminar("Chivas");
       conec.Mostrar();
                
    }
    
}
