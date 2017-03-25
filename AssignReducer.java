import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AssignReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	IntWritable count = new IntWritable();
	
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int s = 0;
		for (IntWritable value : values) {
			s=s+value.get();
		}
		count.set(s);
		context.write(key, count);
	}
}
