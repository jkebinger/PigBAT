package com.kebinger.pigbat;

import java.io.IOException;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.Tuple;

public class BYTES_TO_STRING extends EvalFunc<String> {

	@Override
	public String exec(Tuple input) throws IOException {
		// arguments are byte array, length of string to read, and then offset (reversing from bytes method)
		DataByteArray byteArray = (DataByteArray) input.get(0);
		int length = (Integer) input.get(1);
		int offset = 0;
		if (input.size() > 2) {
			offset = (Integer) input.get(2);
		}
		return Bytes.toString(byteArray.get(), offset, length);
	}

}
