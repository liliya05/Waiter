public class Chef extends User implements Preparation {
    private boolean isItCooked;

    @Override
    public void cook() {
        if (isItCooked) {
            System.out.println("The meal is already cooked.");
            isItCooked = true;
        }
        else {
            System.out.println("The meal is being cooked.");
            isItCooked = false;
        }
    }

    @Override
    public void finishCooking() {
        if (isItCooked) {
            System.out.println("The meal is already cooked.");
        }
        else {
            System.out.println("The meal is ready.");
        }
    }

    @Override
    void switchRoles() {

    }
}
