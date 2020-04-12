package site.morn.boot.message;


import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import site.morn.bean.annotation.Function;
import site.morn.boot.message.annotation.MessageTopic;
import site.morn.test.TestUser;

@Slf4j
@Component
@MessageTopic("userData")
public class TestUserMessageHandler {

  @Function("add")
  public void addUser(@Payload TestUser user, BroadcastMessageHeaders headers) {
    Assert.assertNotNull(headers);
    log.info("Message id {}", headers.getId());
    Assert.assertNotNull(user);
    log.info("Add user: {}", user.getUsername());
  }

  @Function("update")
  public void updateUser(@Payload List<TestUser> users, BroadcastMessageHeaders headers) {
    Assert.assertNotNull(headers);
    log.info("Message id {}", headers.getId());
  }
}
