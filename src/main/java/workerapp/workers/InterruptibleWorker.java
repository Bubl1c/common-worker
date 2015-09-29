package workerapp.workers;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public abstract class InterruptibleWorker implements Worker {
    private boolean isInterrupted;

    @Override
    public abstract void start();

    public void interrupt() {
        this.isInterrupted = true;
    }

    public boolean isInterrupted() {
        return this.isInterrupted;
    }
}
