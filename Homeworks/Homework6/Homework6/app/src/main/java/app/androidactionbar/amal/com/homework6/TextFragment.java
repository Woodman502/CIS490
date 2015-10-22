package app.androidactionbar.amal.com.homework6;

/**
 * Created by Joe Woodcox on 10/22/2015.
 */
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text= (TextView) view.findViewById(R.id.txt);
        String menu = getArguments().getString("Menu");
        text.setText(menu);
        return view;
    }

}