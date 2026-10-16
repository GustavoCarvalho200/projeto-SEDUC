# Simulador Fundeb – Municípios do Pará

Programa em Java, executado no terminal, que lê dados do Fundeb/FNDE dos municípios do Pará a partir de um arquivo CSV e exibe a situação de cada município, o **top 3 maiores Fundebs** e o **maior e o menor Fundeb** do estado.

Projeto Livre da disciplina de Programação Orientada a Objetos (CESUPA).

## Motivação

O Fundeb distribui recursos para a educação básica com base no número de matrículas e em pesos diferentes para cada etapa e modalidade de ensino. Este projeto reúne esses dados em um programa simples, que permite consultar e comparar a situação dos municípios paraenses.

## Funcionalidades

- Leitura do CSV de dados do Fundeb/FNDE com a biblioteca Apache Commons CSV.
- Identificação automática das colunas de matrículas totais e de receita pelo nome do cabeçalho (ignora acentos, aspas e quebras de linha).
- Listagem de todos os municípios com código, nome, total de matrículas e receita prevista.
- Ranking dos 3 municípios com maior receita prevista do Fundeb.
- Identificação do município com o maior e do município com o menor Fundeb.
- O Governo do Estado, que aparece no CSV como uma linha própria, é removido da análise por não ser município.

## Tecnologias

- Java 21
- Maven
- Apache Commons CSV 1.14.1
- JUnit Jupiter 5.10.2 (testes)

## Como rodar

**Pré-requisitos:** JDK 21 ou superior e Maven instalados.

Com o terminal aberto na pasta do projeto (a que contém o `pom.xml`):

```bash
mvn compile exec:java -Dexec.mainClass=App
```

O programa lê o arquivo `csv/versao_que_vamos_usar_completo.csv`, que precisa estar dentro da pasta do projeto.

## Exemplo de saída

```
Código: <código do município>
Nome: <nome do município>
Matrículas: <total de matrículas>
Receita prevista: <valor>
----------------------
...
===== TOP 3 MAIORES FUNDEBS =====
1. <município> - R$ ...
2. <município> - R$ ...
3. <município> - R$ ...
===== MAIOR E MENOR FUNDEB =====
Maior: <município> - R$ ...
Menor: <município> - R$ ...
```

> Substitua pelos valores reais da execução (um print do terminal também funciona).

## Formato do CSV

- Separador de colunas: `;`
- Codificação: UTF-8
- A primeira linha é o cabeçalho.
- Coluna 2: nome do município. Coluna 3: código do município.
- O total de matrículas e a receita do Fundeb são localizados pelo nome da coluna.

## Estrutura do projeto

```
.
├── pom.xml
├── csv/        # dados de entrada
├── src/        # código-fonte
└── test/       # testes JUnit
```

| Classe | Responsabilidade |
|---|---|
| `App` | Ponto de entrada: lê o CSV, lista os municípios e exibe o top 3 e o maior/menor Fundeb |
| `LeitorCSV` | Lê o CSV e cria os objetos `Municipio` |
| `Municipio` | Dados do município: código, nome, total de matrículas e receita prevista |
| `Matricula` | Quantidade de alunos associada a uma modalidade (ainda não usada pelo `App`) |
| `ModalidadeEnsino` | Nome da modalidade e seu fator de ponderação (ainda não usada pelo `App`) |
| `CalculoFundeb` | Cálculo de matrículas ponderadas e do repasse (ainda não usada pelo `App`) |
| `Indicador` | Indicador por município (média de alunos por matrícula) (ainda não usada pelo `App`) |
| `Relatorio` | Reúne municípios e exibe o relatório (ainda não usada pelo `App`) |

## Testes

Os testes usam JUnit 5 e ficam na pasta `test/`.

```bash
mvn test
```

## Fonte dos dados

Dados do Fundeb/FNDE referentes aos municípios do Pará (arquivo `versao_que_vamos_usar_completo.csv`).

> Complete com o link da fonte oficial e o ano de referência.

## Estado atual e próximos passos

O projeto está em desenvolvimento. Já funcionam a leitura do CSV, a listagem dos municípios, o top 3 e o maior/menor Fundeb. Ainda estão em andamento:

- Consulta interativa de um município pelo menu do terminal.
- Integração das classes de matrícula, modalidade, cálculo, indicador e relatório ao fluxo principal.
- Cálculo do repasse por município com o valor por aluno e os pesos de cada modalidade.
- Novos indicadores, como valor médio por aluno e comparação com a média estadual.

## Limitações

- O ranking usa a receita total prevista, o que favorece os municípios maiores. Uma comparação mais justa seria pelo valor por aluno.
- Os valores exibidos vêm do CSV e são estimativas, não substituem os cálculos oficiais do FNDE.

## IA'S
Claude Sonnet 5.5	Lógica de ranking e indicadores	Sugeriu indicadores para o projeto (valor médio por aluno e diferença para a média estadual), escreveu o trecho de ordenação para o top 3 e para o maior/menor Fundeb e apontou um bug no método buscar do LeitorCSV.	Execução do programa com o CSV real, conferência do top 3 e do maior/menor com os dados do arquivo, remoção do Governo do Estado da análise e ajuste do código ao padrão do projeto.

Claude Sonnet 5.5	Documentação e README	Auxiliou na estruturação e na redação do README.md, incluindo as instruções de execução, e o atualizou conforme o código e o pom.xml do projeto.	Validação dos comandos de execução, preenchimento do exemplo de saída, da fonte dos dados e da equipe e ajuste dos textos ao estado real do projeto.

## Equipe

- Kaio Ryan da Silva Paiva
- Gustavo Azevedo Carvalho
- Daniel Orlando Cerpa da Silva Filho
- Arthur Picanço
