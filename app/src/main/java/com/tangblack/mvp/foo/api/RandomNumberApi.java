package com.tangblack.mvp.foo.api;

import java.util.Random;

/**
 * Created by tangblack on 2016/4/20.
 */
public class RandomNumberApi
{
	private Random random = new Random();

	public String generate()
	{
		return "" + random.nextInt(50); // 0 ~ 50
	}
}
