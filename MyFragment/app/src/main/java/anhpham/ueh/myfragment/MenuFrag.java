package anhpham.ueh.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Arrays;



public class MenuFrag extends ListFragment 
{
    ListView listView;
    @NonNull
    IFagmentClickListener itemfragment;
        String[] menus={"Astronaut", "UFO", "Alien"};
    private View list;

    public  interface IFagmentClickListener 
    {
        public void onMenuItemClick (int position);
    }
    @Override
    public  void onAttach(Context context) {
        super.onAttach(context);
        try { itemfragment = (IFagmentClickListener) context;}
        catch (ClassCastException e) {e.printStackTrace();}
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag,container,false);
        ListView noteList =view.findViewById(android.R.id.list);
        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.menu_frag,(new ArrayList<String>(Arrays.asList(menus))));

        noteList.setAdapter(listadapter);
        return view;
    }
}
