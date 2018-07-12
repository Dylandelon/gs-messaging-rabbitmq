package hello;

import java.util.concurrent.CountDownLatch;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements ChannelAwareMessageListener {

    private CountDownLatch latch = new CountDownLatch(1);

//    public void receiveMessage(String message) {
//        System.out.println("Received <" + message + ">");
//        latch.countDown();
//    }
@Override
public void onMessage(Message message, Channel channel) throws Exception {
    try {
        System.out.println("Received <" + message + ">");
        //具体业务
//        amqpSiteServiceImpl.doWithSite(new String(message.getBody(), "UTF-8"));

//手动应答，告诉rabbitmq我业务执行完成，消息可以丢弃了
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        logger.info("站点同步成功！");
        System.out.println("Received <" + new String(message.getBody()) + ">");
    } catch (Exception e) {
        throw new RuntimeException("站点同失败！！" + e);
    }
}
    public CountDownLatch getLatch() {
        return latch;
    }

}
