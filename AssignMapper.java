

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 


public class AssignMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	Text Gender = new Text();
	IntWritable one = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] data = value.toString().split(",");
		int i = Integer.parseInt(data[1]);
		if(i==0){ // Condtion for checking only among survived people
			Gender.set(data[4]);
			context.write(Gender, one);
		}
	}
}