package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = CommsISearchConfiguration.class)
public class AmqpTest {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        String siteData = "{" +
                "\"TYPE\": 11," +
                "\"DATA\":{" +
                "\"HASCHILDREN\":\"true\"," +
                "\"OPERTIME\":\"\"," +
                "\"CRTIME\":\"2017-06-14 19:22:05\"," +
                "\"MEDIATYPE\":\"1\"," +
                "\"TRUENAME\":\"刘珍华\"," +
                "\"ISSUBSCRIBE\":\"1\"," +
                "\"STATUS\":\"0\"," +
                "\"DATAPATH\":\"chengdushi1\"," +
                "\"MPID\":\"89011234567890\"," +
                "\"SCHEDULE\":\"0\"," +
                "\"CHNLOUTLINETEMP\":\"641\"," +
                "\"ISDISTRIBUTABLE\":\"1\"," +
                "\"SITENAME\":\"成都市\"," +
                "\"OUTLINETEMPLATE\":\"250\"," +
                "\"ATTRIBUTE\":\"PUBLISHLIMIT=&PUBSTARTDATE=\"," +
                "\"CHNLDATAPATH\":\"chengdushi2\"," +
                "\"PUBLISHPRO\":\"1\"," +
                "\"SITEORDER\":\"188\"," +
                "\"CLASSIFICATIONID\":\"95\"," +
                "\"SITEID\":\"176\"," +
                "\"LASTMODIFYTIME\":\"2017-08-31 16:00:35\"," +
                "\"SITETYPE\":\"4\"," +
                "\"VIEWINFOID\":\"111\"," +
                "\"DETAILTEMPLATE\":\"446\"," +
                "\"SITEDESC\":\"成都市\"," +
                "\"ISMOBILE\":\"0\"," +
                "\"PARENTID\":\"0\"," +
                "\"ISPUSHABLE\":\"1\"," +
                "\"CRUSER\":\"dev\"" +
                "}" +
                "}";

        rabbitTemplate.convertAndSend("site", "dev.gov.site.createormodify", siteData);
    }
}
