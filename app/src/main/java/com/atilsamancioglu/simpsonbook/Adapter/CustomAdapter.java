package com.atilsamancioglu.simpsonbook.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.atilsamancioglu.simpsonbook.Model.Simpson;
import com.atilsamancioglu.simpsonbook.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Simpson> {
/*Biz özelleştirilmiş yani customize edilmiş bir adaptör oluşturmak için bir sınıf oluştururuz ve
 ArrayAdapter'a extend ederiz.ArrayAdapter ın tagleri arasına da bu adaptörün neyi adapte edeceğini 
 yani neyi göstereceğini yazarız.Array adapter'a extend ettikten sonra bize bir View döndüren getView 
 dında bir metod override ettirir.
 Biz belki uygulamamızın farklı aktivitelerinde farklı farklı listelerde farklı şeyleri listeleyeceğiz
 Farklı custom adapterler farklı contexlerde çalışacağından biz burda context'i constructor'a yazıyoruz
 biz bunu yazmasak da çalışır ama custom adapteri kullanacağımız activity de contexti alacaktık
 bu da kod fazlalığına sebep olurdu...*/
   


    private ArrayList<Simpson> simpsons;
    private Activity context;

    public CustomAdapter(ArrayList<Simpson> simpsons, Activity context) {
        // udemy de super'e neden custom view falan yazdığımıza bak.
        super(context, R.layout.custom_view,simpsons);
        this.simpsons = simpsons;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        TextView nameView = customView.findViewById(R.id.customTextView);
        nameView.setText(simpsons.get(position).getName());

        return customView;
    }
}
