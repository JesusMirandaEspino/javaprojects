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
            recolectarInformacionFormulario(tarea);
        }
    }


    public void modificarTarea(){

    }


    public void eliminarTarea(){

    }

    public void limpiarTarea(){

    }


    private void mostrarMensaje(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }


    private void recolectarInformacionFormulario(Tarea tarea){
        tarea.setNombreTarea( nombreTareaTexto.getText() );
        tarea.setResponsable( responsableTareaTexto.getText() );
        tarea.setEstatus( estatusTareaTexto.getText() );

        tareaServicio.guardarTarea(tarea);
        mostrarMensaje("Informacion", "Tarea Guardada");
        LimpiarFormulario();
        listarTareas();
    }

    private void LimpiarFormulario(){
        nombreTareaTexto.clear();
        responsableTareaTexto.clear();
        estatusTareaTexto.clear();

    }

}
