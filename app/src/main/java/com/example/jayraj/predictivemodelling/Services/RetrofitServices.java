package com.example.jayraj.predictive__model.Services;


import com.example.jayraj.predictive__model.Model.HighLowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServices {

//   String BPI_ENDPOINT = "https://api.coindesk.com/v1/bpi/";
    //  String BPI_HiGH_LOW = "https://min-api.cryptocompare.com/data/pricemultifull?fsyms=BTC&tsyms=USD";
       String BPI_HiGH_LOW = "https://min-api.cryptocompare.com/data/";

    @GET("pricemultifull")
    Call<HighLowResponse> getHIIGHLOW(@Query("fsyms") String fsyms,
                                      @Query("tsyms") String tsyms);


}


