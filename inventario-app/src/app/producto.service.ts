import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  private URL = 'http://localhost:8080/inventario-app/productos';
  private clientHttp = inject(HttpClient);

  constructor() {}

  obtenerProductoLista(): Observable<Producto[]> {
    return this.clientHttp.get<Producto[]>(this.URL);
  }

  agregarProducto(producto: Producto): Observable<Object> {
    return this.clientHttp.post(this.URL, producto);
  }

  obtenerProductoPorId(idProducto: any): Observable<Producto> {
    return this.clientHttp.get<Producto>(`${this.URL}/${idProducto}`);
  }

  eliminarProductoPorId(idProducto: any): Observable<Producto> {
    return this.clientHttp.delete<Producto>(`${this.URL}/${idProducto}`);
  }
}
