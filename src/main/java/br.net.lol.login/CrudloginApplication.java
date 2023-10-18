package br.net.lol.login;

import java.io.Serializable
  
public class Login implements Serializable {
  private String login;
  private String senha;

  public Login() {
    super();
  }

  public Login(String login, String senha) {
    super();
    this.login = login;
    this.senha = senha;
  }

  public String getLogin() {
    return login;
  }

  public void getLogin(String login) {
    this.login = login;
  }

    public String getSenha() {
    return senha;
  }

  public void getSenha(String senha) {
    this.senha = senha;
  }
  
}
