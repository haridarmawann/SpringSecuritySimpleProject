package Java.Spring.Authentication.demo;

public class AuthenticationReponse {

    private String response;

    public AuthenticationReponse() {
    }

    public AuthenticationReponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
