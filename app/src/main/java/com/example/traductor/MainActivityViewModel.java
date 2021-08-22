package com.example.traductor;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<String> traduccion;
    MutableLiveData<Integer> cartel;

    private String ingles [] = {"Table","Chair","Door","Window","Kitchen","Bedroom","Livingroom"};
    private String castellano [] = {"Mesa","Silla","Puerta","Ventana","Cocina","Dormitorio","Living"};

    public LiveData<String> getTraduccion(){
        if(traduccion == null){
            traduccion = new MutableLiveData<>();
        }
        return traduccion;
    }

    public LiveData<Integer> getCartel(){
        if(cartel == null){
            cartel = new MutableLiveData<>();
        }
        return cartel;
    }

    public void traducir(String palabra){
        boolean b=false;

            for (int i = 0; i < ingles.length; i++) {
                if (ingles[i].equals(palabra)) {
                    traduccion.setValue(castellano[i]);
                    b = true;
                    cartel.setValue(View.INVISIBLE);
                }
            }

            if (!b) {
                cartel.setValue(View.VISIBLE);
            }
        
    }
}
