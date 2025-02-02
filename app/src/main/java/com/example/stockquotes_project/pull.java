package com.example.stockquotes_project;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import edu.cofc.stock.Stock;

public class pull extends AsyncTask<String, Void, Stock> {

    Context context;
    TextView symbolOutput;
    TextView nameOutput;
    TextView priceOutput;
    TextView timeOutput;
    TextView changeOutput;
    TextView weekOutput;


    public pull(TextView symbolOutput, TextView nameOutput, TextView priceOutput, TextView timeOutput, TextView changeOutput, TextView weekOutput, Context context){
        this.symbolOutput = symbolOutput;
        this.nameOutput = nameOutput;
        this.priceOutput = priceOutput;
        this.timeOutput = timeOutput;
        this.changeOutput = changeOutput;
        this.weekOutput = weekOutput;
        this.context = context;



    }
    @Override
    protected Stock doInBackground(String... strings) {

        Log.i(  "Stock.load()", "in doInBackground()");
        Stock stock = new Stock(strings[0]);
        try {
            stock.load();
            Log.i("Stock.load()", "after load()");
        } catch (IOException e) {
            //Toast.makeText(this, "Error in retrieving stock symbol", Toast.LENGTH_LONG).show();
            e.printStackTrace();

        }
        return stock;
    }

    @Override
    protected void onPostExecute(Stock stock) {
        super.onPostExecute(stock);
        Log.i("Stock.load()", "in onPostExecute()");
        Log.i("Stock.load()", "week output" + stock.getRange());
        //symbolOutput.setText(stock.getSymbol());
        //delegate.processFinish(stock);
        if(stock.getName() != null) {
            symbolOutput.setText(stock.getSymbol());
            nameOutput.setText(stock.getName());
            priceOutput.setText(stock.getLastTradePrice());
            timeOutput.setText(stock.getLastTradeTime());
            changeOutput.setText(stock.getChange());
            weekOutput.setText(stock.getRange());
        }
        else {
            Toast.makeText(context, "Error in retrieving stock symbol", Toast.LENGTH_SHORT).show();
        }
    }
}