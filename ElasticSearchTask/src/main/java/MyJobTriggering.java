import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public  class MyJobTriggering implements Job {
	

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		        RestHighLevelClient client = new RestHighLevelClient(
			    RestClient.builder(new HttpHost("localhost", 9200, "http")));

		for(int i =0; i<=10; i++) {
			 
		
		 String[] firstname = {"praveen","santosh","amit","vivek"};
		 String[] lastname =  {"vishwa","kumar","rathor","yadav"};
		 String[] books = {"maths","english","physics","scie"};
		 Integer[] date_of_issue = {21-06-12,21-06-23,21-06-13,21-06-13};
		 Integer[] date_of_return = {21-06-19,21-06-30,21-06-20,21-06-20};
	     Integer[] fine = {40,60,70,80};
		 
		 String first_name = firstname[new Random().nextInt(firstname.length)];
		 String last_name =  lastname[new Random().nextInt(lastname.length)];
		 String book_name = books[new Random().nextInt(books.length)];
		 Integer issue_date = date_of_issue[new Random().nextInt(date_of_issue.length)];
		 Integer return_date = date_of_return[new Random().nextInt(firstname.length)];
		 Integer due_fine = fine[new Random().nextInt(fine.length)];
		
		IndexRequest indexRequest_one = new IndexRequest("library_system");
		ElasticDummydata dummydata_one = new ElasticDummydata(first_name, last_name, book_name, issue_date, return_date, due_fine);
		indexRequest_one.id("000");
		try {
			indexRequest_one.source(new ObjectMapper().writeValueAsString(dummydata_one), XContentType.JSON);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IndexResponse indexResponse;
		try {
			indexResponse = client.index(indexRequest_one, RequestOptions.DEFAULT);
			System.out.println("response id: "+indexResponse.getId());
			System.out.println("response name: "+indexResponse.getResult().name());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("The current Time is:" + new Date());
		
		
        if (i == 10) {
            System.out.println("Application Terminates");
            System.exit(0);
        }
        
		}
	}
	
	
	

}
//cnt shio r


