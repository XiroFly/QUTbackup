package javas;

public class PasswordCheckUserBean {
    private String pwhead;

    private String pwtail;
    private String pw;
  public String getPw(){
      return pw;
  }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getpwhead() {
        return pwhead;
    }

    public void setpwhead(String pwhead) {
        this.pwhead = pwhead;
    }

    public String getPwtail() {
        return pwtail;
    }

    public void setPwtail(String pwtail) {
        this.pwtail = pwtail;
    }

    public boolean validate(String pwhead, String pwtail,String pw) {
        if (pw.equals(pwhead+pwtail))
            return true;
        else
            return false;
    }

    public void isOk() {

    }
}
