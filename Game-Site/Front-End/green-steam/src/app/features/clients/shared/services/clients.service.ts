import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Clients } from '../interfaces/clients.model';
import { Client } from '../interfaces/client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(
    private httpClient: HttpClient
  ) { }

  get(sort?: string): Observable<any> {
    const parameters = new HttpParams()
      .append('SORT', sort ? sort : 'Nome')
    return this.httpClient.get<Clients>('http://localhost:8080/clientes', { params: parameters })
  }

  post(body: Client): Observable<any> {
    return this.httpClient.post<Clients>('http://localhost:8080/clientes', body)
  }

  getById(id: string): Observable<any> {
    return this.httpClient.get(`${'http://localhost:8080/clientes'}/${id}`)
  }

  put(body: Client): Observable<Client> {
    return this.httpClient.put<Client>(`${'http://localhost:8080/clientes'}/${body.id}`, body);
  }

  delete(id: string): Observable<any> {
    return this.httpClient.delete<any>(`${'http://localhost:8080/clientes'}/${id}`);
  }
}
