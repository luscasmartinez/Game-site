export interface Client {
  id: string; // Assumindo que o UUID é representado como uma string
  nome: string;
  email: string;
  senha: string;
  data_nascimento: string;
  plataformas_possui: string;
  genero_preferido: string;
  endereco: string;
}
