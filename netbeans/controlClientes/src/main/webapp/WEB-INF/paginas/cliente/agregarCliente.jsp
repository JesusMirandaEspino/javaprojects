<div class="modal fade"  id="agregarClienteModal" tabindex="-1" aria-labelledby="agregarClienteLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white" >
                <h5 class="modal-title" id="agregarClienteLabel">Agregar Cliente</h5>
                <button class=" btn-close"  type="button" data-bs-dismiss="modal" aria-label="Close" ></button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST"
                  class="was-valited">
                <div class="modal-body">
                    <div class="form-group mb-3">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="telefono">Telefono</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" id="saldo" name="saldo" required step="any"/>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-secundary"  data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary"  data-bs-dismiss="modal">Guardar</button>
                </div> 
            </form>
            
        </div>
    </div>
</div>