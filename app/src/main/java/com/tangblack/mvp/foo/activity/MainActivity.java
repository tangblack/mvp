package com.tangblack.mvp.foo.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tangblack.mvp.R;
import com.tangblack.mvp.foo.presenter.NumberLoader;

public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<String>
{
	private static final int LOADER_ID_ONE = 1;
	private static final int LOADER_ID_TWO = 2;

	private TextView numberTextView;
	private Button button;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		numberTextView = (TextView) findViewById(R.id.numberTextView);
		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				getLoaderManager().getLoader(LOADER_ID_ONE).forceLoad(); // 手動按下按鈕，觸發 Loader 去強迫更新。
			}
		});

		getLoaderManager().initLoader(LOADER_ID_ONE, null, this);
		getLoaderManager().initLoader(LOADER_ID_TWO, null, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}



	// Implement LoaderCallbacks:
	@Override
	public Loader<String> onCreateLoader(int id, Bundle args)
	{
		// 建立 Loader 回傳。
		switch (id)
		{
			case LOADER_ID_ONE:
				return new NumberLoader(this);

			case LOADER_ID_TWO:
				return new NumberLoader(this);

			default:
				throw new RuntimeException("Non-support id=" + id);
		}
	}

	@Override
	public void onLoadFinished(Loader<String> loader, String data)
	{
		// 收到 Loader 發出的更新，更新對應的 GUI。
		switch (loader.getId())
		{
			case LOADER_ID_ONE:
				numberTextView.setText(data);
				break;

			case LOADER_ID_TWO:
				break;

			default:
				break;
		}
	}

	@Override
	public void onLoaderReset(Loader<String> loader)
	{
		// 收到 Loader 停止的訊號。
		switch (loader.getId())
		{
			case LOADER_ID_ONE:
				break;

			case LOADER_ID_TWO:
				break;

			default:
				break;
		}
	}
}
