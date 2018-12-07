package com.example.jayraj.pridictive__model.Services;

import android.support.annotation.NonNull;

import com.example.jayraj.pridictive__model.Model.HighLowResponse;

public interface FunctionService {

    void getHIIGHLOW(String fsyms, String tsyms,
                     @NonNull final CallbackService<HighLowResponse> callbackService);

}
