package stubs;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CitHistoReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

  public void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO implement
     */
	 
	  int count = 0;
		for(IntWritable value : values) {
			
			count += value.get();
			
	}
		
		/*
		 * Call the write method on the Context object to emit a key
		 * and a value from the reduce method. 
		 */
		context.write(key, new IntWritable(count));

  }
}