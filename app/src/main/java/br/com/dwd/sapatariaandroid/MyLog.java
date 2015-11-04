package br.com.dwd.sapatariaandroid;

import android.util.Log;

public class MyLog {
    public static void i(Object o) {
        Log.i("TesteREST", o.toString());
    }

    public static void e(Object o) {
        Log.e("TesteREST", o.toString());
    }
}
