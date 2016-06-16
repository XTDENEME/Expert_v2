package com.example.ext01d1840.expert;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link xtAnaSayfa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link xtAnaSayfa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class xtAnaSayfa extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    ListView lv;
    String[] haberT = {"Smart City Expo 2016 İstanbul","Dicle Elektrik Dağıtım A.Ş. Dijital Dönüşümde Experteam’i seçti.","Oracle Cloud Day 2016 Ankara’da gerçekleşti"
                        ,"Dördüncü Uluslararası İstanbul Akıllı Şebekeler ve Şehirler Kongresi","Oracle Mrd Day, Experteam’in Altın Sponsorluğunda gerçekleşti."};
    int[] haberI= {R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5};

    public xtAnaSayfa() {

        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters


    public static xtAnaSayfa newInstance(String param1, String param2) {

        xtAnaSayfa fragment = new xtAnaSayfa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.fragment_xt_ana_sayfa, container, false);

        lv = (ListView) rootView.findViewById(R.id.anaView);

        haberAdaptor adapter=new haberAdaptor(getActivity(),haberT,haberI);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Toast.makeText(getActivity(),haberT[pos],Toast.LENGTH_LONG).show();
            }
        });
        return rootView;


    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
