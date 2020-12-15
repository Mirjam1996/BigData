package stubs;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountMyReducer extends Reducer<Text, Text, Text, IntWritable> {

  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO implement
     */
	  String csv = "";
	  int count = 0;
		for(Text value : values) {
			
			if(csv.length()>0){
				csv += ", ";
				
			} csv += value.toString();
			count++;
	}
		
		/*
		 * Call the write method on the Context object to emit a key
		 * and a value from the reduce method. 
		 */
		context.write(key, new IntWritable(count));

  }
}