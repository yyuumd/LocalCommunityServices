package c.group24.localcommunityservices;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.database.DatabaseReference;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class OpportunityFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference mDatabase;
    private Menu menuRef;



    public OpportunityFragment() {
        // Required empty public constructor
       // setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_opportunity, container, false);

        //junk items (for right now) for list.
        String[] items = {"Do something", "Do something else", "Another thing"};

        mRecyclerView = view.findViewById(R.id.oppsRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new MyAdapter(items);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
