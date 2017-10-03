package pro.kinect.testapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pro.kinect.testapp.R;
import pro.kinect.testapp.adapters.ItemAdapter;
import pro.kinect.testapp.models.RecyclerItem;

/**
 * Created by Arina on 03.10.2017
 */

public class ListFragment extends Fragment {

    private ArrayList<RecyclerItem> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        initItems();
        recyclerView.setAdapter(new ItemAdapter(items));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    private void initItems(){
        items = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            if (i % 2 == 0){
                items.add(new RecyclerItem(getString(R.string.item_text), RecyclerItem.Type.TypeText));
            } else {
                items.add(new RecyclerItem("//path", RecyclerItem.Type.TypePicture)); // TODO: replace path with true path
            }
        }
    }
}
