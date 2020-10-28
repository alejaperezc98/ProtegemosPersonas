package com.protegemos.protegemospersonas;
import com.protegemos.protegemospersonas.data.entities.BeneficiariosEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BeneficiarioService {

    @GET("?con_cod='{codeBen}'&prefijo=D")
    Call<List<BeneficiariosEntity>> getBeneficiario(@Path(value = "codeBen")String codeBen);
}
