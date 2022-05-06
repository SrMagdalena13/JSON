import org.json.JSONObject;
public class Test {
    public static void main(String args[]){
        String cadenaJSON= " { "+
                " \"data\": {"+
                "\"id\": 2,"+
                "       \"email\": \"janet.weaver@reqres.in\","+
                "\"first_name\": [\"Janet\",\"Brown\"],"+
                "\"vivo\": \"false\","+
                "\"avatar\": \"https://reqres.in/img/faces/2-image.jpg\""+
                "},"+
                "\"support\": {"+
                "\"url\": \"https://reqres.in/#support-heading\","+
                "\"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\""+
                "}"+
                "}";
        JSONObject jo = new JSONObject(/*"{ 'abc' : 'def' }"*/ cadenaJSON);
        System.out.println(jo.toString());
    }
}
