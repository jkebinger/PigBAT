package com.kebinger.pigbat;

import java.io.IOException;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.Tuple;

public class BYTES_TO_INT extends EvalFunc<Integer> {

	@Override
	public Integer exec(Tuple input) throws IOException {
		DataByteArray byteArray = (DataByteArray) input.get(0);
		int offset = 0;
		if (input.size() > 1) {
			offset = (Integer) input.get(1);
		}
		return Bytes.toInt(byteArray.get(), offset);
	}

}
