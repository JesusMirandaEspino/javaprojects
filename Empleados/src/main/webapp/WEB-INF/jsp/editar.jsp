<%@ include file="comunes/cabecero.jsp"%>

<%@ include file="comunes/navegacion.jsp"%>

<div class="container"   >

    <div class="text-center" style="margin:30px;">
        <h2>Editar Empleado</h2>
    </div>


    <div class="container" >
        <form action="/empleados/editar" modelAttribute="empleadoForma" method="post">
            <input type="hidden"  name="idEmpleado"  value="${empleado.idEmpleado}">
            <div class="mb-3">
                <label for="nombreEmpleado" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombreEmpleado" name="nombreEmpleado"
                       required="true" value="${empleado.nombreEmpleado}">
            </div>
            <div class="mb-3">
                <label for="departamento" class="form-label">Departamento</label>
                <input type="text" class="form-control" id="departamento" name="departamento"
                       value="${empleado.departamento}">
            </div>
            <div class="mb-3">
                <label for="sueldo" class="form-label">Sueldo</label>
                <input type="number" step="any" class="form-control"  id="sueldo" name="sueldo"
                       value="${empleado.sueldo}">
            </div>
            <div class="text-center" >
                <button type="submit" class="btn btn-warning sm-3">Guardar</button>
                <a href="/empleados" class="btn btn-danger " >Regresar</a>
            </div>

        </form>

    </div>

</div>





<%@ include file="comunes/pie-pagina.jsp"%>

