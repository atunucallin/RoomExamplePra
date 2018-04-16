package com.example.dj.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button bnAddUser, bnReadUser, bnDelete, bnUpdate;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        bnAddUser = view.findViewById(R.id.bn_add_contact);
        bnAddUser.setOnClickListener(this);
        bnReadUser = view.findViewById(R.id.bn_view_contact);
        bnReadUser.setOnClickListener(this);
        bnDelete = view.findViewById(R.id.bn_delete_contact);
        bnDelete.setOnClickListener(this);
        bnUpdate = view.findViewById(R.id.bn_update_contact);
        bnUpdate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bn_add_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.bn_view_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.bn_delete_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.bn_update_contact:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
