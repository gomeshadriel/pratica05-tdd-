# RESPOSTAS

1. No Ciclo 1 usamos return 70. Por que isso é aceitável no TDD? O que
obrigou a escrever a soma de verdade?

    É uma trapaça aceitavel por que é a resposta que esperamos que o teste dê, assim podemos testar sem a necessidade de criar o código. Isso é aceitavel por que como o proprio nome ja diz no TDD o desenvolvimento é orientado pelos testes.

2. No Ciclo 3, por que testar com 69 e 70, e não com 50 e 90?

    Isso se chama análise de valor limite, foi feito assim para testar se o desenvolvedor utilizou as condicionais certas no código, por exemplo utilizar >70 ao invés de >=70 excluiria o aluno que tirou a nota mínima que no caso 70, seria um falso negativo.

3. No Ciclo 4, o que mudou na refatoração? Como você teve certeza de
que não quebrou nada?

    A criação das constante centraliza o valor em um único lugar, o que facilita para manutençoes e evita ter que escrever várias vezes. Tive certeza que não quebrou por que ela não alterou o comportamento da classe.

4. No Ciclo 8, por que alteramos os testes antes de mudar o código?

    Por que o TDD se basea no desenvolvimento a partir do teste, com os testes novos nós tivemos novos "critérios de aceite" e foi com base nesses critérios que a refatoraçao foi feita.

5. Qual ciclo foi o mais difícil para você, e por quê?

    O ciclo final, por que a refatoraçao foi grande e eu estou fazendo isso as 01:02 da madrugada rsrs.