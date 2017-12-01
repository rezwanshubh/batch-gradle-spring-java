package com.barley.batch.processor;

import com.barley.batch.dao.AgencyDAO;
import com.barley.batch.dao.CalendarDAO;
import com.barley.batch.model.Agency;
import com.barley.batch.model.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CalendarProcessor implements ItemProcessor<Calendar, CalendarDAO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyProcessor.class);

    @Override
    public CalendarDAO process(Calendar item) throws Exception {
        LOGGER.info("Processing Record: {}", item);
        CalendarDAO writerSo = new CalendarDAO();
        writerSo.setService_ID(item.getService_Id());
        writerSo.setMonday(item.isMonday());
        writerSo.setTuesday(item.isTuesday());
        writerSo.setWednesday(item.isWednesday());
        writerSo.setThursday(item.isThursday());
        writerSo.setFriday(item.isFriday());
        writerSo.setSaturday(item.isSaturday());
        writerSo.setSunday(item.isSunday());
        writerSo.setStart_date(item.getStart_date());
        writerSo.setEnd_date(item.getEnd_date());

        LOGGER.info("Processed Writer: {}", writerSo);
        return writerSo;
    }
}
