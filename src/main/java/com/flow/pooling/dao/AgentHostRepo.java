package com.flow.pooling.dao;

import com.flow.pooling.domain.AgentHost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gy@fir.im on 25/04/2017.
 *
 * @Copyright fir.im
 */

@Repository
public interface AgentHostRepo extends MongoRepository<AgentHost, String> {

    AgentHost findByMeaningfulId(String meaningfulId);
}
