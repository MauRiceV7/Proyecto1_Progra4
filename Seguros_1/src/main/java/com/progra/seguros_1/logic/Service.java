package com.progra.seguros_1.logic;

import java.util.HashMap;

public class Service {
    public static Service uniqueService;
    
    public static Service instance(){
        if(uniqueService == null){
            uniqueService = new Service();
        }
        return uniqueService;
    }
    
    HashMap<String,Usuario> usuarios;
    HashMap<String,Poliza> poliza;

    public static Service getUniqueService() {
        return uniqueService;
    }

    public static void setUniqueService(Service uniqueService) {
        Service.uniqueService = uniqueService;
    }

    public HashMap<String, Poliza> getPoliza() {
        return poliza;
    }

    public void setPoliza(HashMap<String, Poliza> poliza) {
        this.poliza = poliza;
    }
    
    
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Service(){
        
        usuarios = new HashMap();
        //poliza = new HashMap();
        Usuario u1 =  new Usuario("111","uno","Jairo","61187234","jairoisaac20@gmail.com","1111111",1);
        Usuario admin =  new Usuario("444","1","Mau","67878754","mau20@gmail.com","321312",2);
        usuarios.put("111", u1);
        usuarios.put("222", new Usuario("222","dos","cesar","61187234","jairoisaac20@gmail.com","1111111",1));
        usuarios.put("333", new Usuario("333","tres","andres","61187234","jairoisaac20@gmail.com","1111111",1));
        usuarios.put("444",admin);
         
         
        //poliza.put("1", new Poliza("111","222","1","lamborgini",1220,u1));
//                    private String fecha;
//    private String placa;
//    private String numero;
//    private String Auto;
//    private float valor;
//    private Usuario usuario;
    }
     public Usuario usuarioFind(String cedula,String clave) throws Exception{
        if (usuarios.get(cedula)!=null && usuarios.get(cedula).getClave() != null ) return usuarios.get(cedula);
        else throw new Exception("Usuario no existe");
    }  
}
