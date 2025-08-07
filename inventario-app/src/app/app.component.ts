import { Component } from '@angular/core';
import { ProductoListaComponent } from './producto-lista/producto-lista.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  imports: [RouterModule],
})
export class AppComponent {
  title = 'inventario-app';

  // run app cd /d E:\PAGINASDISEÑOWEB\java\proyectos\inventario-app
}
