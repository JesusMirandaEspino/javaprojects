<%@ include file="empleados/cabecero.jsp"%>

<%@ include file="empleados/navegacion.jsp"%>

<div class="container"   >

    <div class="text-center" style="margin:30px;">
        <h2>Agregar Empleado</h2>
    </div>


    <div class="container" >
        <form>
            <div class="mb-3">
                <label for="nombre" class="form-label">Email address</label>
                <input type="text" class="form-control" id="nombre" required="true">
            </div>
            <div class="mb-3">
                <label for="departamento" class="form-label">Departamento</label>
                <input type="text" class="form-control" id="departamento">
            </div>
            <div class="mb-3">
                <label for="salario" class="form-label">Salario</label>
                <input type="number" step="any" class="form-control" id="salario">
            </div>
            <div class="text-center" >
                <button type="submit" class="btn btn-warning sm-3">Agregar</button>
                <a href="/empleados" class="btn btn-danger " >Regresar</a>
            </div>

        </form>

    </div>

</div>





<%@ include file="empleados/pie-pagina.jsp"%>

