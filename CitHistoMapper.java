package stubs;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class CitHistoMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

	
	@Override
	
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

		/*
		 * 
		 */
	     String [] citation = value.toString().split(",");
		 int citationcount = Integer.parseInt(citation[1]);
		 context.write(new IntWritable(citationcount), new IntWritable(1));
		 
 	    
  }
}
