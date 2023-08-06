import { FormControl } from "@angular/forms";

export interface ClientForm {
  id: FormControl<string>;
  nome: FormControl<string>;
  email: FormControl<string>;
  senha: FormControl<string>;
  data_nascimento: FormControl<string>;
  plataformas_possui: FormControl<string>;
  genero_preferido: FormControl<string>;
  endereco: FormControl<string>;
}
