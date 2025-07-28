package gm.Tareas.controlador;

import gm.Tareas.modelo.Tarea;
import gm.Tareas.servicio.TareaServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexControlador implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private TareaServicio tareaServicio;

    @FXML
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea, Integer> IdTareaColumna;

    @FXML
    private TableColumn<Tarea, String> NombreTareaColumna;

    @FXML
    private TableColumn<Tarea, String>ResponsableColumna;

    @FXML
    private TableColumn<Tarea, String>EstatusColumna;

    private final ObservableList<Tarea> tareaLista = FXCollections.observableArrayList();

    @FXML
    private TextField nombreTareaTexto;

    @FXML
    private TextField responsableTareaTexto;

    @FXML
    private TextField estatusTareaTexto;

    private Integer IdTareaInterno;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas(){
        IdTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idtarea"));
        NombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("NombreTarea"));
        ResponsableColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        EstatusColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }


    private void listarTareas(){
        logger.info("Ejecutando listado");
        tareaLista.clear();
        tareaLista.addAll( tareaServicio.listarTareas() );
        logger.info(tareaLista.toString());
        tareaTabla.setItems(tareaLista);
    }

    public void agregarTarea(){
        if(nombreTareaTexto.getText().isEmpty()){
            mostrarMensaje("Error de validacion", "Debe proporcionar una tarea");
            nombreTareaTexto.requestFocus();
            return;
        }else{
            var tarea = new Tarea();
            tarea.setIdtarea( null );
            recolectarInformacionFormulario(tarea, "Tarea Guardada");
        }
    }



    public void cargarTareaFormulario(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if( tarea != null ){
            IdTareaInterno = tarea.getIdtarea();
            nombreTareaTexto.setText(tarea.getNombreTarea());
            responsableTareaTexto.setText(tarea.getResponsable());
            estatusTareaTexto.setText(tarea.getEstatus());
        }
    }


    public void modificarTarea(){

        if(IdTareaInterno == null){
            mostrarMensaje("Error de validacion", "Debe seleccionar una tarea");
            return;
        }else{
            if(nombreTareaTexto.getText().isEmpty()){
                mostrarMensaje("Error de validacion", "Debe proporcionar una tarea");
                nombreTareaTexto.requestFocus();
                return;
            }else{
                var tarea = new Tarea();
                recolectarInformacionFormulario(tarea, "Tarea Modificada");
            }
        }
    }


    public void eliminarTarea(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();

        if(tarea == null){
            mostrarMensaje("Error de validacion", "Debe seleccionar una tarea");
            return;
        }else{
            IdTareaInterno = tarea.getIdtarea();
            if(nombreTareaTexto.getText().isEmpty()){
                mostrarMensaje("Error de validacion", "Debe proporcionar una tarea");
                return;
            }else{

                if(IdTareaInterno != null) tarea.setIdtarea( IdTareaInterno );
                tareaServicio.eliminarTarea(tarea);

                mostrarMensaje("Informacion", "Tarea Eliminada");
                LimpiarFormulario();
                listarTareas();
            }
        }
    }


    private void mostrarMensaje(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }


    private void recolectarInformacionFormulario(Tarea tarea, String mensajeTipo){


        if(IdTareaInterno != null) tarea.setIdtarea( IdTareaInterno );

        tarea.setNombreTarea( nombreTareaTexto.getText() );
        tarea.setResponsable( responsableTareaTexto.getText() );
        tarea.setEstatus( estatusTareaTexto.getText() );

        tareaServicio.guardarTarea(tarea);
        mostrarMensaje("Informacion", mensajeTipo);
        LimpiarFormulario();
        listarTareas();
    }

    public void LimpiarFormulario(){
        IdTareaInterno = null;
        nombreTareaTexto.clear();
        responsableTareaTexto.clear();
        estatusTareaTexto.clear();

    }

}
