package master.ccm.m2.master1_001;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneViewHolder> {
    private List<Personne> personnes;


    public PersonneAdapter(List<Personne> personnes) {
        this.personnes = personnes;
    }

    @NonNull
    @Override
    public PersonneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ligne_recycler_view_personne, parent, false);

        return new PersonneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonneViewHolder holder, int position) {
        holder.mettreAJourPersonne(personnes.get(position));

    }

    @Override
    public int getItemCount() {
        return personnes.size();
    }
}