package org.ranjani.optus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SubscriptionServiceImpl implements SubscriptionService
{

	private static final String TRUNCATED = " ... (truncated) ... ";

	/**
	 * Truncate the given String to the given integer length by replacing the middle portion with " ... (truncated) ... "
	 * @param orderDetails - String which has to be truncated
	 * @param len - int to which the String has to be limited to
	 * @return String - truncated string upto the given length
	 */
	public String truncate(String orderDetails, int len)
	{
		String trunc = orderDetails;		
		
		int total = orderDetails.length();
		if (StringUtils.isEmpty(orderDetails))
		{
			trunc = "";
		}
		//Case where total is 200, and 2nd parameter is 5, then you ignore the 2nd parameter and truncate to 1+21+1
		else if ((len <= 21) && (total > 21))
		{
			trunc = orderDetails.substring(0,1).concat(TRUNCATED).concat(orderDetails.substring(total-1, total));
		}	
		else if ((total > len+21) || ((total > len) && (len > 21)))
		{
			int mid = (len-21)/2;
			
			//If the 2nd parameter is an even number say 24, then 24-21 = 3, mid = 3/2 = 1, so then it will be 1+21+1 = 23, while it should actually be 24.
			//To handle this, we have assumed to take 1 extra value from the beginning.
			if (len % 2 != 0) 
			{
				trunc = orderDetails.substring(0, mid).concat(TRUNCATED).concat(orderDetails.substring(total-mid, total));
			}
			else
			{
				trunc = orderDetails.substring(0, mid+1).concat(TRUNCATED).concat(orderDetails.substring(total-mid, total));
			}
		}				
	
		return trunc;
	}
}
