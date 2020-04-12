package site.morn.boot.message;

import java.io.SerializablePermission;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;
import site.morn.boot.message.support.AnnotationBroadcastMessageHandler;
import site.morn.boot.message.support.BroadcastMessageBuilder;

/**
 * 注解消息处理者单元测试
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnotationBroadcastMessageHandlerTest {

  @Autowired
  private AnnotationBroadcastMessageHandler<?> messageHandler;

  @Test
  public void handleMessage() {
    // 创建消息数据
    SerializablePermission yourData = new SerializablePermission("master");
    // 构建消息
    Message<SerializablePermission> message = BroadcastMessageBuilder.withPayload(yourData)
        .setTopic("permissionData")
        .setType("add")
        .setErrorChannelName("errorChannel")
        .setReplyChannelName("replyChannel")
        .setTag("developer")
        .setHeader("customHead", "foo").build();
    try {
      messageHandler.handleMessage(message);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }

  }
}