package workerapp.managers;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

/**
 * Created by Andrii Mozharovskyi on 29.09.2015.
 */
public abstract class InterruptibleWorkersManager implements WorkersManager {
    @Override
    public abstract void addWorkers(int amount);

    @Override
    public abstract int activeWorkers();

    public abstract void stopWorkers(int amount);

    @SuppressWarnings({"unchecked"})
    protected <T> T getTargetObject(Object proxy, Class<T> targetClass) throws Exception {
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            return (T) ((Advised)proxy).getTargetSource().getTarget();
        } else {
            return (T) proxy; // expected to be cglib proxy then, which is simply a specialized class
        }
    }
}
