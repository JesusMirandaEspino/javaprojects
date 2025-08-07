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
}
