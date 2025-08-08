import { Component, inject } from '@angular/core';
import { ProductoService } from '../producto.service';
import { Producto } from '../producto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.component.html',
  styleUrl: './producto-lista.component.scss',
})
export class ProductoListaComponent {
  productos: Producto[] = [];

  private productoService = inject(ProductoService);
  private router = inject(Router);

  ngOnInit(): void {
    this.obtenerProductos();
  }

  obtenerProductos(): void {
    this.productoService.obtenerProductoLista().subscribe({
      next: (datos) => {
        this.productos = datos;
      },
      error: (error) => {
        console.log('Error al obtener Productos', error);
      },
    });
  }

  editarProducto(idProducto: any) {
    this.router.navigate(['editar-producto', idProducto]);
  }

  eliminarProducto(idProducto: any) {
    this.productoService.eliminarProductoPorId(idProducto).subscribe({
      next: (datos) => {
        this.obtenerProductos();
      },
      error: (error) => {
        console.log('Error al intentar eliminar el producto', error);
      },
    });
  }
}
