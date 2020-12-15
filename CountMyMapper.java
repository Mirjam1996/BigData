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

public class CountMyMapper extends Mapper<LongWritable, Text, Text, Text> {

	
	@Override
	
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

	
		 String[] citation = value.toString().split(",");
		 context.write(new Text(citation[1]), new Text(citation[0]));
		 
 	    
  }
}
