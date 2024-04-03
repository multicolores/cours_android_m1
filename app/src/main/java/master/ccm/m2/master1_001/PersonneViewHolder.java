package master.ccm.m2.master1_001;

import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonneViewHolder extends RecyclerView.ViewHolder {
    TextView nomTextView;
    TextView poidsTextView;

    public PersonneViewHolder(@NonNull View itemView) {
        super(itemView);

        this.nomTextView=itemView.findViewById(R.id.id_nom_textView_layout_ligne);
        this.poidsTextView=itemView.findViewById(R.id.id_poids_textView_layout_ligne);
    }

    public void mettreAJourPersonne(Personne personne) {
        if(Objects.nonNull(personne)) {
            this.nomTextView.setText(personne.getNom());
            this.poidsTextView.setText(Integer.toString(personne.getPoids()));
        }
    }
}
