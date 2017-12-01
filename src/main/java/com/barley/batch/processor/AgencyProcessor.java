package com.barley.batch.processor;

import com.barley.batch.dao.AgencyDAO;
import com.barley.batch.model.Agency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class AgencyProcessor implements ItemProcessor<Agency, AgencyDAO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyProcessor.class);

    @Override
    public AgencyDAO process(Agency item) throws Exception {
        LOGGER.info("Processing Record: {}", item);
        AgencyDAO writerSo = new AgencyDAO();
        writerSo.setAgency_ID(item.getAgency_ID());
        writerSo.setAgency_Name(item.getAgency_Name());
        writerSo.setAgency_Url(item.getAgency_Url());
        writerSo.setAgency_Timezone(item.getAgency_Timezone());
        writerSo.setAgency_Phone(item.getAgency_Phone());
        writerSo.setAgency_Lang(item.getAgency_Lang());

        LOGGER.info("Processed Writer: {}", writerSo);
        return writerSo;
    }
}

