package com.flow.pooling.dao.test;

import com.flow.pooling.config.WebConfig;
import com.flow.pooling.dao.AgentHostRepo;
import com.flow.pooling.domain.AgentHost;
import com.flow.pooling.domain.HostType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gyfirim on 25/04/2017.
 *
 * @Copyright fir.im
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfig.class)
public class AgentHostRepoTest {

    @Autowired
    private AgentHostRepo agentHostRepo;

    @Test
    public void could_save_load_agent_host() {
        AgentHost host = new AgentHost("mac-001", "192.168.1.1", HostType.FIR_MAC);

        /* check possible to save to database */
        agentHostRepo.save(host);
        Assert.assertNotNull(host.getId());

        /* update agent host obj */
        host.setMeaningfulId();
        agentHostRepo.save(host);

        /* load by id */
        AgentHost loaded = agentHostRepo.findOne(host.getId());
        Assert.assertEquals(loaded, host);
        Assert.assertNotNull(loaded.getMeaningfulId());

        /* load by meaningful id */
        loaded = agentHostRepo.findByMeaningfulId(host.getMeaningfulId());
        Assert.assertEquals(loaded, host);
        Assert.assertNotNull(loaded.getMeaningfulId());
    }

    @After
    public void after() {
        agentHostRepo.deleteAll();
    }
}
