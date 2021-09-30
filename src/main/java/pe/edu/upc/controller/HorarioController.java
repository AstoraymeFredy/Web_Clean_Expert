package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Horario;
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
        obtenerHorarioLimpieza();
    }
   
    public void obtenerHorarioLimpieza () 
    {
    	try {
    		Horario h = hService.obtener(sesion.getPersonalLimpieza().getId_personal_limpieza());
    		this.setHorario(h);
    	}
    	catch (Exception e) {
			Message.messageError("Error en horario " + e.getMessage());
    	}
    }

    public void actualizar () {
    	try {
    		System.out.println(horario.getPersonalLimpieza().getApellidos());
    		hService.actualizar(horario);
            limpiarHorario();
    	}
    	catch(Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
    	}
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