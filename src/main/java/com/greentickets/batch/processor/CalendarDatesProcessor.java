package com.greentickets.batch.processor;

import com.greentickets.batch.dao.CalendarDAO;
import com.greentickets.batch.dao.CalendarDatesDAO;
import com.greentickets.batch.model.Calendar;
import com.greentickets.batch.model.CalendarDates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CalendarDatesProcessor implements ItemProcessor<CalendarDates, CalendarDatesDAO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalendarDatesProcessor.class);

    @Override
    public CalendarDatesDAO process(CalendarDates item) throws Exception {
        LOGGER.info("Processing Record: {}", item);
        CalendarDatesDAO writerSo = new CalendarDatesDAO();
        writerSo.setService_Id(item.getService_Id());
        writerSo.setDate(item.getDate());
        writerSo.setException_Type(item.getException_Type());


        LOGGER.info("Processed Writer: {}", writerSo);
        return writerSo;
    }
}
