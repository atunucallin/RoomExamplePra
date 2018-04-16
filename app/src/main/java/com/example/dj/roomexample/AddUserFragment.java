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
public class AddUserFragment extends Fragment {

    private Button bnSave;
    private EditText Id, Name, Email;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_user, container, false);

        bnSave = view.findViewById(R.id.bn_save_contacts);
        Id = view.findViewById(R.id.bn_contact_id);
        Name = view.findViewById(R.id.bn_name);
        Email = view.findViewById(R.id.bn_email);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(Id.getText().toString());
                String name = Name.getText().toString();
                String email = Email.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User added succesfully", Toast.LENGTH_SHORT).show();
                Id.setText("");
                Name.setText("");
                Email.setText("");
            }
        });

        return view;
    }

}
