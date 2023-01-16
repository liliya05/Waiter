public class Chef extends User implements Cookable{
    protected String userName;
    protected String userPassword;

    Chef() {
        this.userName = null;
        this.userPassword = null;
    }

    Chef(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    void switchRoles(int ans) {

    }

    @Override
    public void cook() {

    }

    @Override
    public void finishCooking() {

    }
}
