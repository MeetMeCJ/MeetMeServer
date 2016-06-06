/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

/**
 *
 * @author Admin
 */
import hibernate.User;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

/**
 *
 * @author izv
 */
public class GestorUser {
    
    /**
     * Metodo que guarda en la base de datos a un usuario
     * 
     *@param usuario Usuario que se va a registrar en nuestra base de datos
     */
    public static void registerUser (User usuario){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session sesion = factory.openSession();
        sesion.beginTransaction();
        sesion.save(usuario);
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }

    /**
     * Metodo para consultar informacion de un usuario a partir de su token
     * 
     * @param token Elemento identificador unico de cada usuario
     * @return Usuario en forma de json, false en caso de no existir
     */
    public static JSONObject getUserByToken (String token) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session sesion = factory.openSession();
        sesion.beginTransaction();
        
        String hql = "from User where token = :token";
        Query q = sesion.createQuery(hql);
        q.setString("token", token);
        
        List<User> usuarios = q.list();
        sesion.getTransaction().commit();
        
        sesion.flush();
        sesion.close();

        JSONObject obj = new JSONObject();
        if (!usuarios.isEmpty()) {
            obj.put("r",usuarios.get(0).getJSON());
        } else {
            obj.put("r", false);
        }
        return obj;
    }
    
    /**
     * Metodo para consultar informacion de un usuario a partir de su telefono
     * 
     * @param tlf Elemento identificador unico de cada usuario
     * @return Usuario en forma de json, false en caso de no existir
     */
    public static JSONObject getUserByTlf(String tlf){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session sesion = factory.openSession();
        sesion.beginTransaction();        
     
        User u= (User) sesion.get(User.class, tlf);
        
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
        
        JSONObject obj = new JSONObject();
        if (u != null) {
            obj = u.getJSON();
        } else {            
            obj.put("r", false);
        }
        return obj;
    }
    
    /**
     * Metodo para actualizar la informacion en la base de datos de un usuario
     * 
     * @param newUser Nuevos datos del usuario
     * @param tlf Telefono del usuario que vamos a modificar
     */
   public static void updateUser(String tlf, User newUser) {
       
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = 
                new StandardServiceRegistryBuilder().
                   applySettings(configuration.getProperties());

        SessionFactory factory = configuration.buildSessionFactory(builder.build());       
        Session sesion = factory.openSession();
        sesion.beginTransaction();

        User user = (User) sesion.get(User.class, tlf);        
       
        user.setDescripcion(newUser.getDescripcion());
        user.setEmail(newUser.getEmail());
        user.setFacebook(newUser.getFacebook());
        user.setNacimiento(newUser.getNacimiento());
        user.setNacionalidad(newUser.getNacionalidad());
        user.setNick(newUser.getNick());
        user.setPrivacidad(newUser.getPrivacidad());
        user.setTwitter(newUser.getTwitter());        
        user.setVerconexion(newUser.getVerconexion());
        user.setUltimaconexion(newUser.getUltimaconexion());

        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }
}
