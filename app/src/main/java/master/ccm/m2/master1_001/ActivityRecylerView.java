package master.ccm.m2.master1_001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityRecylerView extends AppCompatActivity {

    private RecyclerView recyclerViewPersonne;
    private TextView monTextView;
    private List<Personne> lesPersonnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);

        this.recyclerViewPersonne=findViewById(R.id.id_recyclerview_personne_list);
        this.monTextView=findViewById(R.id.id_textView_recyclerview);

        this.lesPersonnes = initListPersonnes(100);
        PersonneAdapter monAdapter=new PersonneAdapter(this.lesPersonnes, itemClickListener);
        this.recyclerViewPersonne.setAdapter(monAdapter);
        this.recyclerViewPersonne.setLayoutManager(new LinearLayoutManager(this));
    }


    public static List<Personne> initListPersonnes(int nombre) {
        List<Personne> personnes = new ArrayList<>();
        Random random = new Random();
        String[] noms = {"Dupont", "Durand", "Martin", "Bernard", "Thomas", "Robert", "Richard", "Petit", "Dubreuil", "Lefebvre"};
        String[] prenoms = {"Jean", "Pierre", "Paul", "Jacques", "Marie", "Julien", "Nicolas", "Julie", "Christine", "Sophie"};
        for (int i = 0; i < nombre; i++) {
            String nom = noms[random.nextInt(noms.length)];
            String prenom = prenoms[random.nextInt(prenoms.length)];
            int poids = random.nextInt(100) + 50; // poids aléatoire entre 50 et 150 kg
            Personne personne = new Personne(nom, prenom, poids);
            personnes.add(personne);
        }
        return personnes;
    }

    public void onClickQuitterDecouverteRecycler(View view) {
        finish();
    }


    GestionClick itemClickListener = new GestionClick() {
        @Override
        public void onItemClick(int position) {
            monTextView.setText(lesPersonnes.get(position).getNom());
            Toast.makeText(ActivityRecylerView.this, "Cliqué sur position" + Integer.toString(position), Toast.LENGTH_SHORT).show();
        }
    };
}
