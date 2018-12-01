package c.group24.localcommunityservices;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ProfileFragment extends Fragment {

    private ImageView image;
    private EditText name, age, work, phone, email;
    private LinearLayout past_activities;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        View view = inflater.inflate(R.layout.user_layout, container, false);

        image = view.findViewById(R.id.profile_pic);
        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        work = view.findViewById(R.id.work);
        phone = view.findViewById(R.id.phone);
        email = view.findViewById(R.id.email);
        past_activities = view.findViewById(R.id.user_activities);


        load_data();

        return view;
    }

    private void load_data() {


    }
}
