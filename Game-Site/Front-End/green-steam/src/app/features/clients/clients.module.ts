import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientsComponent } from './clients.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ClientsRoutingModule } from './clients-routing.module';
import { ClientsFormComponent } from './clients-form/clients-form.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ClientsComponent, ClientsFormComponent],
  imports: [
    CommonModule,
    SharedModule,
    ClientsRoutingModule,
    ReactiveFormsModule
  ]
})
export class ClientsModule { }
