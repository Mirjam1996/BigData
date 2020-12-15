package stubs;
//import javax.ws.rs.GET;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class CitationHistogramJob extends Configured implements Tool {

  public static void main(String[] args) throws Exception {

	  int exitCode = ToolRunner.run(new Configuration(), new CitationHistogramJob(), args);
	  System.exit(exitCode);
   
    }

    public int run(String[] args) throws Exception {
    	 
        if (args.length != 2) {
          System.out.printf("Usage: %s [generic options] <input dir> <output dir>\n", getClass().getSimpleName());
          return -1;
           }
        //Configuration conf = new Configuration();
        //conf.setBoolean("caseSensitive", false);
        Job job = new Job(getConf());
        job.setJarByClass(CitationHistogramJob.class);
        job.setJobName("CitationHistogramJob");

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        job.setMapperClass(CitHistoMapper.class);
        job.setReducerClass(CitHistoReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
       
        
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        
        boolean success = job.waitForCompletion(true);
        System.exit(success ? 0 : 1);
           return 0;
  }
}

