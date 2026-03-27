import java.util.*;

public interface RequestHandling {

    boolean checkForLimit(List<Request> requests, int requestIndex);
}
