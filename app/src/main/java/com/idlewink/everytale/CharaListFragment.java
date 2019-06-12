package com.idlewink.everytale;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CharaListFragment extends Fragment {

    private RecyclerView mCharaRecyclerView;
    private CharaAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chara_list, container, false);

        mCharaRecyclerView = (RecyclerView) view.findViewById(R.id.chara_recycler_view);
        mCharaRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        updateUI();

        return view;
    }

    public void updateUI() {
        CharaSingleton charaSingleton = CharaSingleton.get(getActivity());
        List<Character> characters = charaSingleton.getCharacters();
        if (mAdapter == null) {
            mAdapter = new CharaAdapter(characters);
            mCharaRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCharacters(characters);
            mAdapter.notifyDataSetChanged();
        }
    }

    //--------- CHARACTER HOLDER
    private class CharaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Character mCharacter;
        private ImageView mThumbnail;
        private TextView mNameTextView;

        public CharaHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_chara, parent, false));
            itemView.setOnClickListener(this);
            mNameTextView = (TextView) itemView.findViewById(R.id.character_name);
            mThumbnail = (ImageView) itemView.findViewById(R.id.chara_id);
        }

        public void bind(Character character) {
            mCharacter = character;
            mNameTextView.setText(mCharacter.getName());
            mThumbnail.setImageResource(mCharacter.getThumbnail());
        }

        @Override
        public void onClick(View v) {

        }
    }


    //--------- ADAPTER

    private class CharaAdapter extends RecyclerView.Adapter<CharaHolder> {

        private List<Character> mCharacters;

        public CharaAdapter(List<Character> characters) { mCharacters = characters; }

        @NonNull
        @Override
        public CharaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CharaHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CharaHolder holder, int i) {
            Character character = mCharacters.get(i);
            holder.bind(character);
        }

        @Override
        public int getItemCount() {
            return mCharacters.size();
        }

        public void setCharacters(List<Character> Character) {
            mCharacters = Character;
        }
    }
}
