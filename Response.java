public class Response {

    private final String response;
    private final int HTTPStatus;

    public Response(String response, int HTTPStatus) {
        this.response = response;
        this.HTTPStatus = HTTPStatus;
    }

    public String getResponse() {
        return response;
    }

    public int getHTTPStatus() {
        return HTTPStatus;
    }

    @Override
    public String toString() {
        return "Response [response=" + response + ", HTTPStatus=" + HTTPStatus + "]";
    }

}
