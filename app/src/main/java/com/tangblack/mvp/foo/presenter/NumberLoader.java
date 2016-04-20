package com.tangblack.mvp.foo.presenter;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.SystemClock;
import com.tangblack.mvp.foo.api.RandomNumberApi;

/**
 * Created by tangblack on 2016/4/20.
 */
public class NumberLoader extends AsyncTaskLoader<String>
{
	private RandomNumberApi api = new RandomNumberApi();

	public NumberLoader(Context context)
	{
		super(context);
	}

	@Override
	protected void onStartLoading()
	{
		super.onStartLoading();
	}

	@Override
	public String loadInBackground()
	{
		SystemClock.sleep(1000);
		return api.generate();
	}
}
