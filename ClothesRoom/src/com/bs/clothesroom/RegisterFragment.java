package com.bs.clothesroom;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.bs.clothesroom.controller.PostController;
import com.bs.clothesroom.controller.UserInfo;

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
import android.widget.TextView;

public class RegisterFragment extends GeneralFragment implements OnClickListener {

	private EditText mUserName;
	private EditText mPassword;
	private Spinner mSex, mAge;
	private EditText mWorking;
	private EditText mEmail;
	private EditText mPhone;
	private EditText mBust;
	private EditText mWaist;
	private EditText mHips;
	private EditText mHeight;
	private EditText mWeight;
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
		mPhone = (EditText) v.findViewById(R.id.phone);
		mBust = (EditText) v.findViewById(R.id.bust);
		mWaist = (EditText) v.findViewById(R.id.waist);
		mHips = (EditText) v.findViewById(R.id.hips);
		mWeight = (EditText) v.findViewById(R.id.weight);
		mHeight = (EditText) v.findViewById(R.id.height);

		mSex.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, new String[] { "M", "F" }));
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
		    String username = mUserName.getText().toString().trim();
		    String password = mPassword.getText().toString().trim();
		    String sex = ((String)mSex.getSelectedItem());/*.getText().toString().trim();*/
		    String age = mAge.getSelectedItem().toString();/*.getText().toString().trim();*/
		    String email = mEmail.getText().toString().trim();
		    String work = mWorking.getText().toString().trim();
		    String phone = mPhone.getText().toString().trim();
		    String bust = mBust.getText().toString().trim();
		    String waist = mWaist.getText().toString().trim();
		    String hips = mHips.getText().toString().trim();
		    String height = mHeight.getText().toString().trim();
		    String weight = mWeight.getText().toString().trim();
            UserInfo info = new UserInfo(username, password, sex, age, phone,
                    email, work, bust, waist, hips, height, weight);
			mPostController.register(info);
		}
	}

}
