# Estrutura das Branches

```
main: Branch principal e estável.
feature/<nome-da-feature>: Para novas funcionalidades.
```

## Prazo para Último Commit e PR

- O padrão da equipe é de até no máximo, **domingo 19h**, para que o ter tempo de juntar as features sem quebrar e mergear na `main`. 
- **Domingo às 23h** o código final deve estar pronto para ser submetido à branch `main` (Produção).

## Processo de Code Review

- Todo código deve passar por revisão de pelo menos 1 (um) developer antes de ser aceito o Pull Request na branch `main`.
- O revisor deve fornecer feedback detalhado para o Dev responsável pela Task avaliada.
- **Responsabilidade:** O dono da task é responsável por testar e corrigir problemas no seu código. Pull Requests que “quebrarem” a API terão como responsáveis tanto o dono da task quanto quem aprovou.

## Processo de Pull Request

- Os Pull Requests devem estar detalhados com as principais funcionalidades adicionadas, bem como problemas encontrados no código e como foram resolvidos/contornados.

### Checklist obrigatório antes de abrir um PR:

- [ ] Código foi revisado
- [ ] Testes de fluxo foram executados

## Tempo Esperado para Aprovação

- O tempo esperado para aprovação de um PR é de **24 horas**.
- Qualquer Dev pode aprovar um PR, mas é necessário que siga as responsabilidades.
