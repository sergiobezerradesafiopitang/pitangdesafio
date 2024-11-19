# pitangdesafio

Desafio está na branch "desafio" deste repositório.

O desafio foi criado em um notebook Dell S.O. linux Ubuntu 20.04.6 LTS.
Dividiu-se em duas partes: 
1- Front (Ângular 17.3.11, node v20.16.0, npm 10.8.2)
2- Back  (IntelliJ Community Edition 2024, jdk 17.0.7-amzn, spring 3.3.5, H2 como database)


#Front

Foram criados componentes e services relativos à tarefa em questão compartimentalizando tudo e utilizando Materials para a criação de um formulário,
onde o cliente insere os dados e recebe os resultado em uma áres de texto.
Utilizou-se Expansion Panel e Input e Button como principais UI.

Ao realizar uma requisição, os dados são enviados para o service, e este, realizará a requisição de autenticação no keycloack (devolvendo um token)
e tb encarrega-se-a de "chamar" o endpoint específico para a consulta de dados ou inserção dos mesmos.

![Captura de tela de 2024-11-18 23-52-52](https://github.com/user-attachments/assets/e2b20be6-6112-4ae8-8a86-3d49bf3900ff)


![Captura de tela de 2024-11-18 23-59-02](https://github.com/user-attachments/assets/8d13e3da-991e-4cce-9462-3a87893bbec0)


![Captura de tela de 2024-11-19 00-00-52](https://github.com/user-attachments/assets/d64fcb03-134b-46e2-a493-a8137b5ea09c)


#Back

No back-end foram criadas várias classes procurando-se respeitar o padrão S.O.L.I.D, bem como, um código limpo.
Estão descritos, controladores, entidades, repositórios, services, util, security, config, swagger, dentre outros.
Estas classes são responsáveis por realizar o processamento das requisições feitas pelo front.

#Servidor de Autenticação

Foi utilizado o Keycloak (no docker) como servidor de autenticação e a partir das informações contidas nele, é realizado o processamento de um token.

![Captura de tela de 2024-11-19 00-11-10](https://github.com/user-attachments/assets/c30343a2-b781-4b79-be72-4206a9839261)


![Captura de tela de 2024-11-19 00-13-06](https://github.com/user-attachments/assets/386c056f-938b-4038-b3a4-4c31be97f579)


#Swagger
Os endpoints também podem ser acessados mediante o swagger e uma collection está disponível neste repositório.

![Captura de tela de 2024-11-19 00-17-08](https://github.com/user-attachments/assets/39212ae3-f067-4876-a8c0-4f683e3b90ea)


#Observações e exclarecimentos finais

A aplicação oferece uma gama de possibilidades para divisão de tarefas em múltiplas etapas (Tanto do Front como do Back-end).
As tarefas podem ser divididas no Jira, e variar em número de acordo com o número de participantes da equipe e a agilidade de cada um para entender e
realizar a implementação do solicitado. Pode-se ter divisões com parte da equipe atuando no back e parte no front e cada um comunicando-se com os demais.

Em relação a este desafio, os prints oferecem uma evidência, e o código demonstra o que foi feito.
O intuito era colocar tudo em docker, criar uma imagem e rodar, bem como, a construção do eureka, e api gateway, porém, isto não foi possivel até o presente.
Mas, fica aqui o código e evidências e minha disponibilidade para elucidações futuras caso necessário. 










