package org.rent.bucket;

import java.util.Date;

import org.rent.utils.Constants;
import org.rent.utils.DateUtil;


public class BucketImpl implements FileName,KeyName {

	@Override
	public String keyName() {
		return DateUtil.format(new Date(), Constants.TD_DATE_TIME_FORMAT_NO_SECONDS);
	}

	@Override
	public String fileName(String fileName) {
	    return String.valueOf(DateUtil.getUtcTime())+ fileName;	
	}

}
