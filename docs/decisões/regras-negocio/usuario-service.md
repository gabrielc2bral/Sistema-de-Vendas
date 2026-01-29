# UsuarioService – Regras de Negócio

## Entrada
- Nome do usuário 
- Email
- Senha (texto puro)
- CPF
- tipo de conta (CLIENTE, VENDEDOR)

## Saída
- Usuário criado


## Regras de Negócio

### RN01 – CPF válido e obrigatório
- O CPF é obrigatório
- O CPF deve ser válido
- Não pode existir outro usuário com o mesmo CPF
  

Erro:
- CPF_INVALIDO
- CPF_JA_CADASTRADO

### RN02 – Email válido e obrigatório
- O Email é obrigatório
- O Email deve ser válido
- Não pode existir outro usuário com o mesmo Email

Erro:
- EMAIL_INVALIDO
- EMAIL_JA_CADASTRADO

### RN03 Nome do usuário válido
- O nome é obrigatório
- O nome não pode ser vazio ou em branco

Erro:
- NOME_OBRIGATORIO

### RN04 CPF imutável
- Não pode ser atualizado.

Erro:
- CPF_IMUTAVEL