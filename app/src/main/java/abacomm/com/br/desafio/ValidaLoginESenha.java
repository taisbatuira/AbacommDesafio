package abacomm.com.br.desafio;

public class ValidaLoginESenha {

    private static final String LOGIN = "abacomm";
    private static final String SENHA = "1234";

    private String login;
    private String senha;

    public ValidaLoginESenha(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean temPermissao() {
        return login.equals(LOGIN) && senha.equals(SENHA);
    }
}
