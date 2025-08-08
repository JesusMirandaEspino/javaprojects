import { Component, inject } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-producto',
  imports: [FormsModule],
  templateUrl: './editar-producto.component.html',
  styleUrl: './editar-producto.component.scss',
})
export class EditarProductoComponent {
  producto: Producto = new Producto();
  idProducto!: any;

  private productoServicio = inject(ProductoService);
  private enrutador = inject(Router);
  private ruta = inject(ActivatedRoute);

  ngOnInit() {
    this.idProducto = this.ruta.snapshot.params['idProducto'];
    this.getProducto();
  }

  onSubmit() {
    this.guardarProducto();
  }

  guardarProducto() {
    this.productoServicio.agregarProducto(this.producto).subscribe({
      next: (datos: any) => {
        this.irListaProductos();
      },
      error: (error: any) => {
        console.log(error);
      },
    });
  }

  getProducto() {
    this.productoServicio.obtenerProductoPorId(this.idProducto).subscribe({
      next: (data) => {
        this.producto = data;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  irListaProductos() {
    this.enrutador.navigate(['productos']);
  }
}
