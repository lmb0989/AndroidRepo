package com.bs.clothesroom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterFragment extends GeneralFragment implements OnClickListener {

	private EditText mUserName;
	private EditText mPassword;
	private Spinner mSex, mAge;
	private EditText mWorking;
	private EditText mEmail;
	private Button mRegister,mLogin;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.register, container, false);
		mUserName = (EditText) v.findViewById(R.id.username);
		mPassword = (EditText) v.findViewById(R.id.password);
		mSex = (Spinner) v.findViewById(R.id.sex);
		mAge = (Spinner) v.findViewById(R.id.age);
		mEmail = (EditText) v.findViewById(R.id.email);
		mWorking = (EditText) v.findViewById(R.id.work);

		mSex.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, new String[] { "男", "女" }));
		Integer ages[] = new Integer[40];
		for (int i = 0; i < ages.length; i++) {
			ages[i] = i + 1;
		}
		mAge.setAdapter(new ArrayAdapter<Integer>(getActivity(),
				android.R.layout.simple_list_item_1, ages));
		mAge.setSelection(19, true);
		mLogin = (Button) v.findViewById(R.id.login);
		mRegister = (Button) v.findViewById(R.id.register);
		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
		return v;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onClick(View v) {
		final long id = v.getId();
		if (id == R.id.login) {
			GeneralActivity.startLogin(getActivity());
			getActivity().finish();
		} else if (id == R.id.register) {
			
		}
	}

}