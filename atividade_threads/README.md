# Documentação: Exemplo Produtor-Consumidor em Java com Threads
Este documento detalha a implementação de um problema clássico de concorrência, o "Produtor-Consumidor", utilizando threads em Java. A solução demonstra como duas threads, uma produtora (T1) e uma consumidora (T2), podem compartilhar dados de forma segura através de uma lista.

## Panorama Geral da Solução
O programa é estruturado em torno de duas threads principais que operam em paralelo e compartilham um recurso comum (uma lista de inteiros):

Thread T1 (Produtora): Adiciona números inteiros a uma lista compartilhada. A thread aguarda se a lista atingir sua capacidade máxima, evitando o consumo excessivo de memória.

Thread T2 (Consumidora): Remove (consome) os números da mesma lista e os imprime no console. A thread aguarda se a lista estiver vazia, evitando tentativas de leitura inválidas.

Para garantir a integridade dos dados e evitar condições de corrida, a solução utiliza os mecanismos de sincronização nativos do Java: a palavra-chave synchronized e os métodos wait() e notify().

## A estrutura do projeto consiste em quatro classes Java:

SharedList.java: Gerencia a lista compartilhada e contém toda a lógica de sincronização.

Producer.java: Implementa a lógica da thread produtora (T1).

Consumer.java: Implementa a lógica da thread consumidora (T2).

Main.java: Ponto de entrada do programa

# Instruções de Implementação e Execução
Para compilar e executar:

Crie os Arquivos:

- SharedList.java
- Producer.java
- Consumer.java
- Main.java

## Copie o Código dos arquivos presentes na pasta da atividade.

## Compile: Abra um terminal e execute o comando de compilação do Java:

    javac *.java


    java Main

## Após isso observe a saída: no console as mensagens das threads T1 e T2 sendo mostradas, perceba como a produtora espera quando a lista está cheia e a consumidora espera quando a lista está vazia, demonstrando a sincronização.