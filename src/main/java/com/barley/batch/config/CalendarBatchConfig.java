package com.barley.batch.config;

import com.barley.batch.dao.AgencyDAO;
import com.barley.batch.dao.CalendarDAO;
import com.barley.batch.model.Agency;
import com.barley.batch.model.Calendar;
import com.barley.batch.processor.AgencyProcessor;
import com.barley.batch.processor.CalendarProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class CalendarBatchConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalendarBatchConfig.class);


    @Bean
    public FlatFileItemReader<Calendar> reader(DataSource dataSource) {

        FlatFileItemReader<Calendar> reader = new FlatFileItemReader<Calendar>();
        reader.setResource(new ClassPathResource("gtfs/calendar.txt"));
        reader.setLineMapper(new DefaultLineMapper<Calendar>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"service_id", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"
                        , "sunday", "start_date", "end_date"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Calendar>() {{
                setTargetType(Calendar.class);
            }});
        }});
        return reader;

    }

    @Bean
    public ItemProcessor<Calendar, CalendarDAO> processor() {
        return new CalendarProcessor();
    }

    @Bean
    public ItemWriter<CalendarDAO> writer(DataSource dataSource, ItemPreparedStatementSetter<CalendarDAO> setter) {
        JdbcBatchItemWriter<CalendarDAO> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setItemPreparedStatementSetter(setter);
        writer.setSql("insert into Calendar (service_id, monday, tuesday, wednesday, thursday, friday, saturday" +
                ", sunday, start_date, end_date) values (?,?,?,?,?,?,?,?,?,?)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public ItemPreparedStatementSetter<CalendarDAO> setter() {
        return (item, ps) -> {
            ps.setLong(1, item.getService_ID());
            ps.setBoolean(2, item.isMonday());
            ps.setBoolean(3, item.isTuesday());
            ps.setBoolean(4, item.isWednesday());
            ps.setBoolean(5, item.isThursday());
            ps.setBoolean(6, item.isFriday());
            ps.setBoolean(7, item.isSaturday());
            ps.setBoolean(8, item.isSunday());

            java.sql.Date sDate = new java.sql.Date(item.getStart_date().getTime());
            ps.setDate(9, sDate);

            java.sql.Date eDate = new java.sql.Date(item.getEnd_date().getTime());
            ps.setDate(10, eDate);
        };
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1, JobExecutionListener listener) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Calendar> reader,
                      ItemWriter<CalendarDAO> writer, ItemProcessor<Calendar, CalendarDAO> processor) {
        return stepBuilderFactory.get("step1")
                .<Calendar, CalendarDAO>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
