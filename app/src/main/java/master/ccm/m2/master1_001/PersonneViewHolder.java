package master.ccm.m2.master1_001;

import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonneViewHolder extends RecyclerView.ViewHolder {
    TextView nomTextView;
    TextView poidsTextView;
    private GestionClick gestionClick;

    public PersonneViewHolder(@NonNull View itemView, final GestionClick gestionClick) {
        super(itemView);

        this.nomTextView=itemView.findViewById(R.id.id_nom_textView_layout_ligne);
        this.poidsTextView=itemView.findViewById(R.id.id_poids_textView_layout_ligne);
        this.gestionClick = gestionClick;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gestionClick.onItemClick(getAdapterPosition());
            }
        });
    }

    public void mettreAJourPersonne(Personne personne) {
        if(Objects.nonNull(personne)) {
            this.nomTextView.setText(personne.getNom());
            this.poidsTextView.setText(Integer.toString(personne.getPoids()));
        }
    }
}
