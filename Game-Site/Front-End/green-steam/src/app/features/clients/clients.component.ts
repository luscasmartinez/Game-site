import { Component, OnInit } from '@angular/core';
import { PoBreadcrumb, PoNotificationService, PoPageAction, PoTableColumn } from '@po-ui/ng-components';
import { Clients } from './shared/interfaces/clients.model';
import { ClientsService } from './shared/services/clients.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
  actions: Array<PoPageAction> = [
    { label: 'Novo',
      action: this.goToFormClient.bind(this) }
  ];
  breadcrumb: PoBreadcrumb = {
    items: [
      { label: 'Início', link: '/' },
      { label: 'Clientes' }
    ]
  }

  // columns!: Array<PoTableColumn>

  items!: Array<any>;

  clients: Clients = {
    items: [],
    hasNext: false,
    remainingRecords: 0
  }

  constructor(
    private clientsService: ClientsService,
    private poNotificationService: PoNotificationService,
    private router: Router
  ) { }

  ngOnInit(): void {
    //this.setColumns();
    //this.getClients();
    this.listar(); // Funcional
  }

  goToFormClient(): void {
    this.router.navigate(['clients/new'])
  }

  goToFormEdit(id: string): void {
    this.router.navigate(['clients/edit', id])
  }

  columns = [
    { property: 'id', label: 'ID - Clique no Valor para Editar o Cliente', type: 'link', action: (row: string) => this.goToFormEdit(row) },
    { property: 'nome', label: 'Nome' },
    { property: 'email', label: 'E-mail' },
    { property: 'senha', label: 'Senha', visible: false },
    { property: 'data_nascimento', label: 'Data Nascimento', visible: false },
    { property: 'plataformas_possui', label: 'Plataformas' },
    { property: 'genero_preferido', label: 'Gênero Preferido' },
    { property: 'endereco', label: 'Endereço' }
  ]

  isLoading = false;
  hasNextPage = false;
  totalClients!: number;
  textTotalClients!: string;

  listar() {
    this.isLoading = true;
    this.clientsService.get().subscribe({
      next: dados => this.onGetSuccess(dados),
      error: (error: any) => this.poNotificationService.error('Falha ao Retornar Clientes')
    })
  }

  onGetSuccess(dados: any): void {
    this.items = dados;
    this.isLoading = false;
    this.totalClients = this.items.length;
    this.textTotalClients = `Total de Clientes: ${this.totalClients}`;
  }

  // Desativado
  getClients(): void {
    //this.clients.items = [{ id: '213', nome: 'Pablo', email: 'pablo@p.com', senha: '1234',
    //  data_nascimento: '17/16/55', plataformas_possui: 'PC', genero_preferido: 'FPS', endereco: 'Rua'}]
    this.clientsService.get().subscribe({
      next: (clients: Clients) => this.clients.items = clients.items,
      error: (error: any) => this.poNotificationService.error('Falha ao Retornar Clientes')
    })
  }
}
