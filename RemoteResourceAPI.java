public class RemoteResourceAPI {

    Response getResponse(Request request) {
        String response = "Received new request" + request;
        return new Response(response, 200);
    }
}
