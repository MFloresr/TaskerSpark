import static spark.Spark.*;

public class Tasker {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}

