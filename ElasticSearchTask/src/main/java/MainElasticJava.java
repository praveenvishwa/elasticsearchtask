import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MainElasticJava{


	public static void  main(String args[])throws IOException, SchedulerException, InterruptedException {
	
		
		
		
		
		
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_0f_issue =sdf.parse("2021-06-05");
		Date date_0f_return =sdf.parse("2021-06-12");/*
		
		/*  LocalDate date = LocalDate.now();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		  String text = date.format(formatter);
		  LocalDate parsedDate = LocalDate.parse(text); 
		  parsedDate.of(2021, 06, 05); */
		 
		  
		//  parsedDate date_of_issue = ("2021 05 06");
		
		
	     JobDetail jd = JobBuilder.newJob(MyJobTriggering.class).build();
		 
		 Trigger t = TriggerBuilder.newTrigger().withIdentity("Crone Trigger")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)
					.repeatForever()).build();
			
	     Scheduler s = StdSchedulerFactory.getDefaultScheduler();
			
			s.start();
			s.scheduleJob(jd ,t);
			
          
				
	}
	
	

private static JobBuilder newJob(Class<MyJobTriggering> class1) {
	// TODO Auto-generated method stub
	return null;
}


	
}
