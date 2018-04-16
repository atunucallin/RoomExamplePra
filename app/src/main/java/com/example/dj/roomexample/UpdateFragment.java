package com.example.dj.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText update_id, update_name, update_email;
    private Button bn;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update, container, false);

        update_id  = view.findViewById(R.id.bn_update_id);
        update_name = view.findViewById(R.id.bn_update_name);
        update_email = view.findViewById(R.id.bn_update_email);
        bn = view.findViewById(R.id.bn_update);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(update_id.getText().toString());
                String name = update_name.getText().toString();
                String email = update_email.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User updated", Toast.LENGTH_SHORT).show();
                update_id.setText("");
                update_name.setText("");
                update_email.setText("");
            }
        });




        return view;
    }

}
