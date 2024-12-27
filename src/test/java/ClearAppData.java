import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ClearAppData {

    public void clearAppData(String deviceId, String appPackage) {
        // Construct the adb command
        String command = "adb -s " + deviceId + " shell pm clear " + appPackage;

        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Capture the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the command to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("App data cleared successfully for package: " + appPackage);
            } else {
                System.err.println("Failed to clear app data for package: " + appPackage);
            }

            // Print the command output
            System.out.println(output);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error occurred while clearing app data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClearAppData appDataClearer = new ClearAppData();

        // Provide your device ID and app package
        String deviceId = "089082529U003239";
        String appPackage = "vidfo.video.player.videoplayer";

        // Clear app data
        appDataClearer.clearAppData(deviceId, appPackage);
    }
}
