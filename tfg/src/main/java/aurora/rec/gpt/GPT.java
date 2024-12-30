/*package aurora.rec.gpt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;*/

/**
 * Test with gpt-turbo.
 * To be used to generate different variations from a single rule text.
 * @author victor
 */
/*public class GPT {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = System.getenv("OPENAI_API_KEY");
    
    public static void main(String[] args) {
        try {
            String response = getChatGPTResponse("Hello, ChatGPT!");
            System.out.println("Response from ChatGPT: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public static String getChatGPTResponse(String message) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set request method and headers
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // JSON payload for OpenAI API
        String jsonInputString = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}],"
                + "\"max_tokens\": 50"
                + "}";

        // Send JSON input
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Get response
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }
}*/