import { NgModule } from '@angular/core';
import { ClientsComponent } from './clients.component';
import { RouterModule, Routes } from '@angular/router';
import { ClientsFormComponent } from './clients-form/clients-form.component';

const routes: Routes = [
  { path: '', component: ClientsComponent },
  { path: 'new', component: ClientsFormComponent },
  { path: 'edit/:id', component: ClientsFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
