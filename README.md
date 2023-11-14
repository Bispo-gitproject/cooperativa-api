[Pautas.postman_collection.json](https://github.com/Bispo-gitproject/cooperativa-api/files/13351904/Pautas.postman_collection.json)# cooperativa-api

## Descrição

Este projeto Java utiliza o framework Spring Boot e Maven para facilitar o desenvolvimento, teste e implantação. Ele inclui integração com o Swagger para documentação da API e realiza chamadas a uma API externa para preenchimento automático de CEP. A esteira de integração contínua (CI) já está pré-configurada e o repositório utiliza MySQL como banco de dados.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Swagger
- MySQL
- Integração Contínua (CI)

## Controle de Versão

Este projeto segue a metodologia de controle de versão GitFlow. A estrutura de branches é a seguinte:

- `master`: Reflete a última versão de produção.
- `develop`: Branch principal de desenvolvimento.
- `feature/*`: Branches para desenvolvimento de novas funcionalidades.
- `release/*`: Branches para preparar uma nova versão de produção.

- Para este caso apenas esta sendo usado a master e a release, usando todo o gitflow, acesso via terminal do Intellij

# Stress Test com JMeter

Este projeto foi submetido a testes de estresse usando o Apache JMeter para avaliar seu desempenho sob condições de carga extrema. 

Os testes foram realizados com o objetivo de identificar limitações e otimizar o desempenho do sistema.

# Testes com JUnit

Este projeto inclui testes unitários desenvolvidos com JUnit para garantir a qualidade e confiabilidade do código. 

Os testes abrangem várias partes do sistema e são executados automaticamente como parte do processo de integração contínua.

## Estrutura dos Testes

Os testes foram organizados de acordo com as diferentes camadas do projeto:

Testes unitários para serviços.
Testes unitários para controladores.
Testes unitários para repositórios.

- Não conclui a construção dos teste, apenas a service

## Execução dos Testes

Os testes podem ser executados usando a ferramenta como o Postman

# Collections para testes no postman

## Associados
[Associados.postman_collection.json](https://github.com/Bispo-gitproject/cooperativa-api/files/13351919/Associados.postman_collection.json)

## Pautas
[Pautas.postman_collection.json](https://github.com/Bispo-gitproject/cooperativa-api/files/13351920/Pautas.postman_collection.json)

## Votações
[Votação.postman_collection.json](https://github.com/Bispo-gitproject/cooperativa-api/files/13351921/Votacao.postman_collection.json)



