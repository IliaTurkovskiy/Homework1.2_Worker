public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String failed);
    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;

    }

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != 33) {
                callback.onDone("Task " + i + " is done");
            }
        }
    }

    public void startError() {
        errorCallback.onError("\n" + "Task " + 33 + " is failed");
    }
}
