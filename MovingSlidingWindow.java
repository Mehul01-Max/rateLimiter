import java.util.List;

public class MovingSlidingWindow implements RequestHandling {

    private int windowSize;
    private int requestLimit;

    public MovingSlidingWindow(int windowSize, int requestLimit) {
        this.windowSize = windowSize;
        this.requestLimit = requestLimit;
    }

    @Override
    public boolean checkForLimit(List<Request> requests, int requestIndex) {
        int count = 0;
        for (int i = Math.max(0, requestIndex - windowSize + 1); i <= requestIndex; i++) {
            if (requests.get(i).getResolvedStatus() != 429) {
                count++;
            }
        }
        return count <= requestLimit;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public int getRequestLimit() {
        return requestLimit;
    }

    public void setRequestLimit(int requestLimit) {
        this.requestLimit = requestLimit;
    }

}
