import { Component, inject } from '@angular/core';
import { ProductoService } from '../producto.service';
import { Producto } from '../producto';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.component.html',
  styleUrl: './producto-lista.component.scss',
})
export class ProductoListaComponent {
  productos: Producto[] = [];

  private productoService = inject(ProductoService);

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
}
