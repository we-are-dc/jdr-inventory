package com.jdrinventory.inventory_jdr.ui.character;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jdrinventory.inventory_jdr.R;
import com.jdrinventory.inventory_jdr.ui.character.CharacterDetailsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CharacterListRecyclerViewAdapter extends RecyclerView.Adapter<CharacterListRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mCardTitles = new ArrayList<>();
    private ArrayList<String> mCardReferences = new ArrayList<>();
    private Context mContext;

    public CharacterListRecyclerViewAdapter(ArrayList<String> mCardTitles, ArrayList<String> mCardReferences, Context mContext) {
        Log.i("clickclick", "init constructor");
        this.mCardTitles = mCardTitles;
        this.mCardReferences = mCardReferences;
        this.mContext = mContext;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Log.i("clickclick", "init oncreate view holder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Log.i("clickclick", "onbind view holder");
        holder.cardTitle.setText(mCardTitles.get(position));
        holder.cardReference.setText(mCardReferences.get(position));
        holder.parentLayout.findViewById(R.id.character_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("clickclick", "clicked");
                TextView ref = view.findViewById(R.id.character_reference);
                String characterId = ref.getText().toString();
                mContext.startActivity(
                    new Intent(mContext, CharacterDetailsActivity.class)
                        .putExtra("character_uuid", characterId)
                );

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("clickclick", "get cards size");
        return mCardTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardTitle;
        TextView cardReference;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i("clickclick", "init view holder");
            cardTitle = itemView.findViewById(R.id.character_card_title);
            cardReference = itemView.findViewById(R.id.character_reference);
            parentLayout = itemView.findViewById(R.id.character_details_recycler_content);
        }
    }

}
