package com.greentickets.batch.config;

import com.greentickets.batch.dao.CalendarDatesDAO;
import com.greentickets.batch.model.CalendarDates;
import com.greentickets.batch.processor.CalendarDatesProcessor;
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
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
public class CalendarDatesBatchConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalendarDatesBatchConfig.class);

    @Bean
    public FlatFileItemReader<CalendarDates> reader(DataSource dataSource) {

        FlatFileItemReader<CalendarDates> reader = new FlatFileItemReader<CalendarDates>();
        reader.setResource(new ClassPathResource("gtfs/calendar_dates.txt"));
        reader.setLineMapper(new DefaultLineMapper<CalendarDates>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"service_id", "date", "exception_type"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<CalendarDates>() {{
                setTargetType(CalendarDates.class);
            }});
        }});

        return reader;

    }

    @Bean
    public ItemProcessor<CalendarDates, CalendarDatesDAO> processor() {
        return new CalendarDatesProcessor();
    }

    @Bean
    public ItemWriter<CalendarDatesDAO> writer(DataSource dataSource, ItemPreparedStatementSetter<CalendarDatesDAO> setter) {
        JdbcBatchItemWriter<CalendarDatesDAO> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setItemPreparedStatementSetter(setter);
        writer.setSql("insert into calendar_dates (service_id, date, exception_type) values (?,?,?)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public ItemPreparedStatementSetter<CalendarDatesDAO> setter() {
        return (item, ps) -> {
            ps.setLong(1, item.getService_Id());

            java.sql.Date d = new java.sql.Date(item.getDate().getTime());
            ps.setDate(2, d);

            ps.setInt(3, item.getException_Type());

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
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<CalendarDates> reader,
                      ItemWriter<CalendarDatesDAO> writer, ItemProcessor<CalendarDates, CalendarDatesDAO> processor) {
        return stepBuilderFactory.get("step1")
                .<CalendarDates, CalendarDatesDAO>chunk(5)
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
