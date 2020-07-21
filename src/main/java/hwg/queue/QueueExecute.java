package hwg.queue;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hwg
 * @Date: Create in 2020/7/9
 * 队列测试
 */
@Component
@Order(1)
public class QueueExecute {
    /**
     * 队列长度
     */
    private  int QUEUE_LENGTH = 10000*10;
    /**
     * 阻塞队列
     */
    private BlockingQueue queue = new LinkedBlockingQueue(QUEUE_LENGTH);

    public Object poll() throws InterruptedException {
       return queue.poll(30, TimeUnit.SECONDS);
    }

    public void put(Object obj){
        try {
            queue.put(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
