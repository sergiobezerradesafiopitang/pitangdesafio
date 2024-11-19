import { CarroDto } from "./carroDto";

export class UsuarioDto {

    id_usuario!: number;
    first_name!: string;
    last_name!: string;
    email!: string;
    birthday!: Date;
    login!: string;
    password!: string;
    phone!: string;
    cars: CarroDto[] = [];
    

}