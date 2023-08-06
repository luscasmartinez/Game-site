import { ClientsService } from './../shared/services/clients.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PoBreadcrumb, PoDialogService, PoNotificationService, PoPageEditLiterals } from '@po-ui/ng-components';
import { ClientForm } from '../shared/interfaces/client-form.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../shared/interfaces/client.model';
import { AnyCatcher } from 'rxjs/internal/AnyCatcher';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  clientsForm!: FormGroup;
  operation: string = 'post';
  isLoading: boolean = false;
  title: string = 'Novo Registro';
  customLiterals: PoPageEditLiterals = {
    saveNew: 'Salvar e Novo'
  };

  breadcrumb: PoBreadcrumb = {
    items: [
      { label: 'Início', link: '/' },
      { label: 'Clientes', link: '/clients' },
      { label: 'Novo Registro' }
    ]
  }

  constructor(
    private router: Router,
    private clientsService: ClientsService,
    private poNotificationService: PoNotificationService,
    private activatedRoute: ActivatedRoute,
    private poDialogService: PoDialogService
  ) { }

  ngOnInit(): void {
    this.createForm();
    this.setOperation();
    this.setTitle();
  }

  createForm(): void {
    if (this.operation === 'post') {
      this.clientsForm = new FormGroup<ClientForm>({
        id: new FormControl('', { nonNullable: true }),
        nome: new FormControl('', { nonNullable: true }),
        email: new FormControl('', { nonNullable: true }),
        senha: new FormControl('', { nonNullable: true }),
        data_nascimento: new FormControl('', { nonNullable: true }),
        plataformas_possui: new FormControl('', { nonNullable: true }),
        genero_preferido: new FormControl('', { nonNullable: true }),
        endereco: new FormControl('', { nonNullable: true })
      });
    } else {
      this.getClient();
    }
  }

  setTitle(): void {
    if (this.operation === 'put') {
      this.title = 'Alterar Registro'
      this.customLiterals.saveNew = 'Excluir';
      this.getClient();
    } else {
      this.title = 'Novo Registro';
    }
    this.breadcrumb.items[2].label = this.title;
  }

  setOperation(): void {
    this.operation = this.activatedRoute.snapshot.params['id'] ? 'put' : 'post';
    console.log(this.operation);
  }

  cancel(): void {
    this.router.navigate(['clients'])
  }

  save(isSaveAndNew: boolean): void {
    this.isLoading = true;
    this.operation === 'post' ? this.post(isSaveAndNew) : this.put(isSaveAndNew);
  }

  onSaveSuccess(response: Client, isSaveAndNew: boolean): void {
    this.isLoading = false;
    isSaveAndNew ? this.clientsForm.reset() : this.router.navigate(['clients']);
    this.poNotificationService.success(`Cliente Incluído com Sucesso: ${response.nome}`);
  }

  onSaveError(error: any): void {
    this.isLoading = false;
    this.poNotificationService.error('Falha ao salvar registro.');
  }

  getClient(): void {
    this.isLoading = true;
    this.clientsService.getById(this.activatedRoute.snapshot.params['id']).subscribe({
      next: (client: Client) => this.onGetSuccess(client),
      error: (error: any) => this.onGetError(error)
    });
  }

  onGetSuccess(client: Client): void {
    this.isLoading = false;
    this.clientsForm = new FormGroup<ClientForm>({
      id: new FormControl(client.id, { nonNullable: true }),
      nome: new FormControl(client.nome, { nonNullable: true }),
      email: new FormControl(client.email, { nonNullable: true }),
      senha: new FormControl(client.senha, { nonNullable: true }),
      data_nascimento: new FormControl(client.data_nascimento, { nonNullable: true }),
      plataformas_possui: new FormControl(client.plataformas_possui, { nonNullable: true }),
      genero_preferido: new FormControl(client.genero_preferido, { nonNullable: true }),
      endereco: new FormControl(client.endereco, { nonNullable: true })
    })
  }

  onGetError(error: any): void {
    this.isLoading = false;
    this.poNotificationService.error('Falha ao retornar serviço.')
  }

  post(isSaveAndNew: boolean): void {
    this.clientsService.post(this.clientsForm.value).subscribe({
      next: response => this.onSaveSuccess(response, isSaveAndNew),
      error: error => this.onSaveError(error)
    });
  }

  put(isSaveAndNew: boolean): void {
    this.clientsService.put(this.clientsForm.value).subscribe({
      next: response => this.onSaveSuccess(response, isSaveAndNew),
      error: error => this.onSaveError(error)
    });
  }

  saveOrDelete(): void {
    if (this.operation === 'post') {
      this.save(true);
    } else {
      this.confirmDelete()
    }
  }

  confirmDelete(): void {
    this.poDialogService.confirm({
      title: 'Excluir Cliente',
      message: 'Confirma Exclusão? \nEssa ação não pode ser desfeita.',
      confirm: this.delete.bind(this)
    });
  }

  delete(): void {
    this.isLoading = true;
    this.clientsService.delete(this.activatedRoute.snapshot.params['id']).subscribe({
      next: () => this.onDeleteSuccess(),
      error: () => this.onDeleteError()
    });
  }

  onDeleteSuccess(): void {
    this.router.navigate(['clients']);
    this.poNotificationService.success('Registro Excluido com Sucesso.')
  }

  onDeleteError(): void {
    this.isLoading = false;
    this.router.navigate(['clients']);
    this.poNotificationService.success('Registro Excluido com Sucesso.')
  }
}
