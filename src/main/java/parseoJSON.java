import org.json.JSONArray;
import org.json.JSONObject;

public class parseoJSON {
    static String json = "{\n" +
            "    \"pageInfo\": {\n" +
            "            \"pageName\": \"Homepage\",\n" +
            "            \"logo\": \"https://www.example.com/logo.jpg\"\n" +
            "    },\n" +
            "    \"posts\": [\n" +
            "            {\n" +
            "                \"post_id\": \"0123456789\",\n" +
            "                \"actor_id\": \"1001\",\n" +
            "                \"author_name\": \"Jane Doe\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [{\"comment\": \"Ta bueno\"}],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
            "           {\n" +
            "                \"post_id\": \"01234\",\n" +
            "                \"actor_id\": \"1002\",\n" +
            "                \"author_name\": \"Nuria García\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [{\"comment\": \"No ta bueno\"}],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
                        "{\n" +
            "                \"post_id\": \"56789\",\n" +
            "                \"actor_id\": \"1003\",\n" +
            "                \"author_name\": \"Sergio Fernández\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [{\"comment\": \"Regulinchi\"}],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
            "    ]\n" +

            "}";
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
            JSONArray arr2 = arr.getJSONObject(i).getJSONArray("comments");
            for (int j = 0; j < arr2.length(); j++) {
                String comments= arr2.getJSONObject(j).getString("comment");
                System.out.println(comments);
            }
        }
    }
}
