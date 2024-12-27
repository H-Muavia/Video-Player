public class PermissionCheck {

    private boolean isGenralPermissions1Executed = false; // Flag to track if genralPermissions1() was run

    public void genralPermissions1() {
        // Your logic for handling permissions
        System.out.println("genralPermissions1() is executed.");
        isGenralPermissions1Executed = true; // Set flag to true after execution
    }

    public void startApp() {
        if (!isGenralPermissions1Executed) {
            // Check if genralPermissions1() was not executed
            System.out.println("genralPermissions1() was not executed. StartApp() will not run.");
            return;
        }
        // Your logic to start the app
        System.out.println("StartApp() is executed.");
    }

    public static void main(String[] args) {
        PermissionCheck permissionCheck = new PermissionCheck();

        // Uncomment this line to test the successful scenario
        // permissionCheck.genralPermissions1();

        permissionCheck.startApp(); // Will only run if genralPermissions1() was executed
    }
}

