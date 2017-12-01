package com.greentickets.batch.config;

import com.greentickets.batch.dao.AgencyDAO;
import com.greentickets.batch.model.Agency;
import com.greentickets.batch.processor.AgencyProcessor;
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
public class AgencyBatchConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyBatchConfig.class);

    @Bean
    public FlatFileItemReader<Agency> reader(DataSource dataSource) {

        FlatFileItemReader<Agency> reader = new FlatFileItemReader<Agency>();
        reader.setResource(new ClassPathResource("gtfs/agency.txt"));
        reader.setLineMapper(new DefaultLineMapper<Agency>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"agency_id", "agency_name", "agency_url", "agency_timezone", "agency_phone", "agency_lang"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Agency>() {{
                setTargetType(Agency.class);
            }});
        }});
        return reader;

    }

    @Bean
    public ItemProcessor<Agency, AgencyDAO> processor() {
        return new AgencyProcessor();
    }

    @Bean
    public ItemWriter<AgencyDAO> writer(DataSource dataSource, ItemPreparedStatementSetter<AgencyDAO> setter) {
        JdbcBatchItemWriter<AgencyDAO> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setItemPreparedStatementSetter(setter);
        writer.setSql("insert into agency (agency_id, agency_name, agency_url, agency_timezone, agency_phone, agency_lang) values (?,?,?,?,?,?)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public ItemPreparedStatementSetter<AgencyDAO> setter() {
        return (item, ps) -> {
            ps.setString(1, item.getAgency_ID());
            ps.setString(2, item.getAgency_Name());
            ps.setString(3, item.getAgency_Url());
            ps.setString(4, item.getAgency_Timezone());
            ps.setString(5, item.getAgency_Phone());
            ps.setString(6, item.getAgency_Lang());
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
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Agency> reader,
                      ItemWriter<AgencyDAO> writer, ItemProcessor<Agency, AgencyDAO> processor) {
        return stepBuilderFactory.get("step1")
                .<Agency, AgencyDAO>chunk(5)
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
