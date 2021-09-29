package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Horario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceimpl.HorarioServiceImpl;
import pe.edu.upc.util.Message;
import pe.edu.upc.util.Sesion;

@Named
@RequestScoped
public class HorarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private HorarioServiceImpl hService;

    private Horario horario;

    @Inject
    private Sesion sesion;

    @PostConstruct
    public void init() {
        this.horario = new Horario();
       // this.obtenerHorarioLimpieza();
        
    }

    public void prueba()
    {
    	try {
    		System.out.println(hService.obtener(sesion.getPersonalLimpieza().getId_personal_limpieza()));
    		this.setHorario(hService.obtener(sesion.getPersonalLimpieza().getId_personal_limpieza()));
        	System.out.println("entrando");
        	System.out.println(sesion.getPersonalLimpieza().getId_personal_limpieza());
    	}
    	catch (Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
    	}
    }
    public void obtenerHorarioLimpieza () 
    {
    	try {
    		this.setHorario(hService.obtener(sesion.getPersonalLimpieza().getId_personal_limpieza()));
    	}
        catch(Exception e) {
			Message.messageError("Error en horario " + e.getMessage());
        }
    }

    public void obtenerHorario (Usuario usuario) 
    {
    	try {
    		this.setHorario(hService.obtener(usuario.getId_usuario()));
    	}
    	catch(Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
    	}
	}
    
    public String registrarHorario () {
        
    	try{
    		hService.registrar(horario);
            limpiarHorario();
           
    	}
    	catch(Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
    	}
    	 return "personal.xhtml";
    }

    public String actualizar () {
    	try {
    		hService.actualizar(horario);
            limpiarHorario();
   
    	}
    	catch(Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
    	}
    	 return "personal.xhtml";
    }

    public void limpiarHorario() {
        this.init();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }



}