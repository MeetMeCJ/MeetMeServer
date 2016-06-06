package hibernate;
// Generated 14-abr-2016 17:10:06 by Hibernate Tools 4.3.1

import org.json.JSONObject;




/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {
    
     private String telefono;
     private String nick;
     private String token;
     private String descripcion;
     private String ultimaconexion;
     private String verconexion;
     private String privacidad;
     private String email;
     private String facebook;
     private String twitter;
     private String nacimiento;
     private String nacionalidad;
     
                        

    public User() {
    }

	
    public User(String telf, String token) {
        this.telefono = telf;
        this.token = token;
    }

    public User(String telefono, String nick, String token, String descripcion, String ultimaconexion, String verconexion, String privacidad, String email, String facebook, String twitter, String nacimiento, String nacionalidad) {
        this.telefono = telefono;
        this.nick = nick;
        this.token = token;
        this.descripcion = descripcion;
        this.ultimaconexion = ultimaconexion;
        this.verconexion = verconexion;
        this.privacidad = privacidad;
        this.email = email;
        this.facebook = facebook;
        this.twitter = twitter;
        this.nacimiento = nacimiento;
        this.nacionalidad = nacionalidad;
    }
   
   
    public String getTelf() {
        return this.telefono;
    }
    
    public void setTelf(String telf) {
        this.telefono = telf;
    }
    public String getNick() {
        return this.nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUltimaconexion() {
        return this.ultimaconexion;
    }
    
    public void setUltimaconexion(String ultimaconexion) {
        this.ultimaconexion = ultimaconexion;
    }
    public String getVerconexion() {
        return this.verconexion;
    }
    
    public void setVerconexion(String verconexion) {
        this.verconexion = verconexion;
    }
    public String getPrivacidad() {
        return this.privacidad;
    }
    
    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
    public JSONObject getJSON(){
        JSONObject result = new JSONObject();
        result.put("token", token);
        result.put("telephone", telefono);
        result.put("nick", nick);
        result.put("description", descripcion);
        result.put("last", ultimaconexion);
        result.put("see", ultimaconexion);
        result.put("privacy", privacidad);
        result.put("facebook", facebook);
        result.put("twitter", twitter);
        result.put("nationality", nacionalidad);
        result.put("email", email);
        result.put("birth", nacimiento);
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "telefono=" + telefono + ", nick=" + nick + ", token=" + token + ", descripcion=" + descripcion + ", ultimaconexion=" + ultimaconexion + ", verconexion=" + verconexion + ", privacidad=" + privacidad + ", email=" + email + ", facebook=" + facebook + ", twitter=" + twitter + ", nacimiento=" + nacimiento + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
    
}

